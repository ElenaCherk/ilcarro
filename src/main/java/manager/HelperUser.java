package manager;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.interactions.Actions;

public interface HelperUser extends HelperBase{
    default void openLoginForm(){
        click(By.xpath("//*[.=' Log in ']"));
    }
    default void openRegistrationForm(){
        click(By.xpath("//*[.=' Sign up ']"));
    }
    default void fillLoginForm(String email, String password) {
        type(By.id("email"), email);
        type(By.id("password"), password);
    }
    default void fillLoginForm(User user) {
        type(By.id("email"), user.getEmail());
        type(By.id("password"),  user.getPassword());
    }
    default void fillRegistrationForm(User user) {
        type(By.id("name"), user.getName());
        type(By.id("lastName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
        clickCheckbox();
    }

    default void clickCheckbox(){
        // variant 1
        //click(By.cssSelector("label[for = 'terms-of-use']")); // кликни на элемент "label" у которого есть элемент
                                                        // который называется for, значение которого 'terms-of-use'
        // variant 2
        //JavascriptExecutor js = (JavascriptExecutor)wd;  // как бы подключили интерфейс Javascript к нашему объекту вэбдрайвера
            // засчеи приведения типа (кастинг), это добавляет только ту функциональность, которая есть в интерфейсе
            //JavascriptExecutor и исключает методы вэбдрайвера
        //js.executeScript("document.querySelector('#terms-of-use').click();");

         // variant 3
        Rectangle rect = wd.findElement(By.cssSelector("label[for = 'terms-of-use']")).getRect();
        int x = rect.getX()+rect.getWidth()/20;
        int y = rect.getY()+rect.getWidth()/4;
        Actions actions = new Actions(wd);
        actions.moveByOffset(x,y).click().perform();
    }

    default void submitLogin(){
            click(By.xpath("//button[@type = 'submit']"));
        }
    default void submitRegistration(){
        click(By.xpath("//button[@type = 'submit']"));
    }
    default boolean isRegistrationWithNameBlank(){
        return isElementPresent(
                By.xpath("//div[contains(text(),' Name is required ')]"));
    }
    default boolean isRegistrationWithLastNameBlank(){
        return isElementPresent(
                By.xpath("//div[contains(text(),' Last name is required ')]"));
    }
    default boolean isRegistrationWithWrongEmail(){
        return isElementPresent(
                By.xpath("//div[contains(text(),'Wrong email format')]"));
    }
    default boolean isRegistrationWithWrongPassword(){
        click(By.xpath("//label[@for='password']"));
        return isElementPresent(
                By.xpath("//div[contains(text(),'Password must contain minimum 8 symbols')]"));
    }
    default boolean isLoggedSuccess(){
        return isElementPresent(
                By.xpath("//h2[contains(text(),'success')]"));
    }

    default boolean isRegisteredSuccess(){
        return isElementPresent(
                By.xpath("//h2[contains(text(),'success')]"));
    }

    default boolean isLogged(){
        return isElementPresent(
                By.xpath("//*[.=' Logout ']"));
    }
    default void logout(){ 
            click(By.xpath("//*[.=' Logout ']"));// 
        }

    default void login(User user){
       openLoginForm();
       fillLoginForm(user);
       submitLogin();
       clickOkButton();
    }
    default void clickOkButton(){
            click(By.xpath("//button[@type='button']"));
        }
}


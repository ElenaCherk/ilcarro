import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestsBase {

    WebDriver wd;

    @BeforeMethod
    public void init() {
        wd = new ChromeDriver();
        wd.navigate().to("https://ilcarro.web.app/search");
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void openLoginRegistrationForm(){
        wd.findElement(By.xpath("//a[@class='navigation-link'][normalize-space()='Log in']")).click();
    }

    public void fillLoginRegistrationForm(String email, String password) {
        type(By.xpath("//input[@id='email']"), email);
//        WebElement emailImput = wd.findElement(By.xpath("//input[@id='email']"));
//        emailImput.clear();
//        emailImput.sendKeys(email);
        type(By.xpath("//input[@id='password']"), password);
//        WebElement passInput = wd.findElement(By.xpath("//input[@id='password']"));
//        passInput.clear();
//        passInput.sendKeys(password);
    }

    public void type(By locator, String text){                 // метод передает нужный текст нужному элементу
        WebElement element = wd.findElement(locator);          // нужен input[1]
        element.click();                                       // кликаем на этот элемент
        element.clear();                                       // очищаем содержимое (если там что то было)
        element.sendKeys(text);                                // присваиваем нужный текст
    }

    public void clickOnButton(By locator){
        wd.findElement(locator).click();
    }

    @AfterMethod
    public void tearDown() {
        pause(3000);
        wd.quit();
    }
    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }
    public boolean isLogged(){
       return isElementPresent(By.xpath("//a[normalize-space()='Logout']"));
    }
    public void logout(){
        clickOnButton(By.xpath("//a[normalize-space()='Logout']"));
    }

//    private boolean isAlertPresent() {
//        Alert alert = new WebDriverWait(wd, 5)
//                .until(ExpectedConditions.alertIsPresent());
//        if (alert == null) return false;
//        wd.switchTo().alert();
//        System.out.println(alert.getText());
//        alert.accept();
//        return true;
//    }
}

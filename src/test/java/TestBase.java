import manager.HelperCar;
import manager.HelperUser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase implements HelperUser, HelperCar {

    WebDriver wd;

    @BeforeSuite
//    public void init() {
//        wd = new ChromeDriver();
//        wd.navigate().to("https://ilcarro.web.app/search");
//        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//    }
    public void setup(){
        init();
    }
    @AfterSuite
    public void stop() {
        pause(5000);
        tearDown();
    }
//    public void tearDown() {
//        pause(3000);
//        wd.quit();
//    }
//    public void openLoginForm(){
//        click(By.xpath("//a[@class='navigation-link'][normalize-space()='Log in']"));
//           // click(By.xpath("//*[.=' Log in ']")); // можно и так
//           // wd.findElement(By.xpath("//a*[.=' Log in ']")).click(); // можно и так
//    }
//
//    public void fillLoginForm(String email, String password) {
//        type(By.id("email"), email);
//        WebElement emailImput = wd.findElement(By.xpath("//input[@id='email']"));
//        emailImput.clear();
//        emailImput.sendKeys(email);
//        type(By.id("password"), password);
//        WebElement passInput = wd.findElement(By.xpath("//input[@id='password']"));
//        passInput.clear();
//        passInput.sendKeys(password);
//    }
//    public void submitLogin(){ // click on "Y'alla"
//        click(By.xpath("//button[@type = 'submit']")); //ищем button с типом атрибута type = 'submit'
//    }
//    public boolean isLoggedSuccess(){
//       return isElementPresent(By.xpath("//h2[contains(text(),'success')]"));
//       //также можно проверить успешный логин, найдя кнопку logout уже после нажатия кнопки "OK"
//    }
//    public void logout(){ // нужно делать логаут перед запуском каждого следующего теста на Login
//        click(By.xpath("//*[.=' Logout ']"));// но при условии что пользователь был корректно залогинен
//    }
//    public void clickOkButton(){
//        click(By.xpath("//button[@type='button']"));
//    }
 }

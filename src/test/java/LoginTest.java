import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @BeforeMethod
    public void precondition(){
        if(isLogged()) logout();
    }
    @Test
    public void loginPositiveTest() {
        // open login form
        openLoginForm();
        // fill login form
        fillLoginForm("lenny_ch@mail.com", "123Ttt45$");
        //  click on Y'alla button (submitLogin)
        submitLogin();
        // assert
        Assert.assertTrue(isLoggedSuccess());
    }
        @Test
        public void loginPositiveTestModel() {
            User user = new User() // создаем объект класса User и используем модифицированные сеттеры
                .withEmail("lenny_ch@mail.com")
                .withPassword("123Ttt45$");
            openLoginForm();
            fillLoginForm(user.getEmail(), user.getPassword()); // получаем данные через геттеры
            submitLogin();
            Assert.assertTrue(isLoggedSuccess());
    }

    @AfterMethod
    public void postcondition(){
        clickOkButton();
    }
}

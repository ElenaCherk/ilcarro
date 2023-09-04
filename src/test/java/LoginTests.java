import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestsBase{

    @Test
    public void loginPositiveTest() {
        // open login form
        openLoginRegistrationForm();

        // fill login form
        fillLoginRegistrationForm("lenny_ch@mail.com","123Ttt45$");

        //  click on Y'alla button
        wd.findElement(By.xpath("//button[.='Y’alla!']")).click();

        // assert
        pause(3000);
        Assert.assertTrue(isElementPresent(By.tagName("BUTTON")));
        clickOnButton(By.xpath("//button[.='Ok']"));
        pause(3000);

        isLogged();
        pause(1000);
        logout();
        tearDown();
    }
}

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {
    @BeforeMethod(alwaysRun = true)
    public void precondition(){
        refresh();
        if(isLogged()) logout();
    }
    @Test(groups = {"positive"})
    public void registrationPositive(){
        int i = (int)(System.currentTimeMillis()/1000%3600);
        User user = new User(
                "John",
                "Black",
                "jb_" + i + "@mail.com",
                "$asDf1234");
        openRegistrationForm();
        fillRegistrationForm(user);
        submitRegistration();
        Assert.assertTrue(isRegisteredSuccess());
    }

    @Test(groups = {"negative"})
    public void registrationNegativeNameBlank(){
        int i = (int)(System.currentTimeMillis()/1000%3600);
        User user = new User(
                "",
                "Tyler",
                "ty_" + i + "@mail.com",
                "$aSrf1334");

        openRegistrationForm();
        fillRegistrationForm(user);
        Assert.assertTrue(isRegistrationWithNameBlank());
    }

    @Test(groups = {"negative"})
    public void registrationNegativeLastNameBlank(){
        int i = (int)(System.currentTimeMillis()/1000%3600);
        User user = new User(
                "Max",
                "",
                "ty_" + i + "@mail.com",
                "$aSrf1334");

        openRegistrationForm();
        fillRegistrationForm(user);
        Assert.assertTrue(isRegistrationWithLastNameBlank());
    }
    @Test(groups = {"negative"})
    public void registrationNegativeWrongEmail(){
        int i = (int)(System.currentTimeMillis()/1000%3600);
        User user = new User(
                "Max",
                "Tylor",
                "ty_" + i + "mail.com",
                "$aSrf1334");

        openRegistrationForm();
        fillRegistrationForm(user);
        Assert.assertTrue(isRegistrationWithWrongEmail());
    }

    @Test(groups = {"negative"})
    public void registrationNegativeWrongPassword(){
        int i = (int)(System.currentTimeMillis()/1000%3600);
        User user = new User(
                "Max",
                "Tylor",
                "ty_" + i + "@mail.com",
                "1234");

        openRegistrationForm();
        fillRegistrationForm(user);
        Assert.assertTrue(isRegistrationWithWrongPassword());
    }
}

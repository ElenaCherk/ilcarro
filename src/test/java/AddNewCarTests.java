import models.Car;
import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTests extends TestBase{

    @BeforeMethod // проверяем залогинились ли
    public void precondition(){
        if (isLogged() == false) {
            login(
                new User().withEmail("lenny_ch@mail.com").withPassword("123Ttt45$")
            );
        }
    }
    @Test
    public void addNewCarPositive(){
        int i = (int)(System.currentTimeMillis()/1000%3600);
        Car car = Car.builder()
                .location("Tel Aviv")
                .manufacture("Peogeout")
                .model("206")
                .year("2019")
                .fuel("Petrol")
                .seats("5")
                .carClass("S")
                .carRegNumber("375-456-"+i)
                .price("235")
                .about("Very good car")
                .build();
        openCarForm();
        fillCarForm(car);
    }
}

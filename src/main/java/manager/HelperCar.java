package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface HelperCar extends HelperBase{
    default void openCarForm(){
        pause(5000);
        click(By.xpath("//a[.=' Let the car work ']"));
    }

    default void fillCarForm(Car car){
        if(isCarFormPresent() == false) return;
        typeLocation(car.getLocation());
        type(By.id("make"), car.getManufacture());
        type(By.id("model"), car.getModel());
        type(By.id("year"), car.getYear());
        type(By.id("fuel"), car.getFuel());
        type(By.id("seats"), car.getSeats());
        type(By.id("class"), car.getCarClass());
     //   type(By.id("serialNumber"), car.getCarRegNumber());
        typeSerialNumber(car.getCarRegNumber());
        type(By.id("price"), car.getPrice());
        type(By.id("about"), car.getAbout());
    }

    default void typeLocation(String location){
        pause(5000);
        type(By.id("pickUpPlace"), location);
        click(By.className("pac-item"));
    }

    default void typeSerialNumber(String text){ // будем печатать по координатам
        Rectangle rect = wd.findElement(By.id("serialNumber")).getRect(); // создаем объект класса, в котором будет информация
                                                                          //о прямоугольнике для нашего serialNumber
        int x = rect.getX()+rect.getWidth()*7/8;
        int y = rect.getY()+rect.getWidth()/2;
        Actions actions = new Actions(wd);
        actions.moveByOffset(x,y).click().perform();


    }

    default boolean isCarFormPresent(){
        return new WebDriverWait(wd, 10)
                .until(ExpectedConditions.textToBePresentInElement(
                        wd.findElement(By.cssSelector("h2")), // жду пока не появится слово details
                        "details"));
    }
}

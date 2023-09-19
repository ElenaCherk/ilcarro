package manager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public interface HelperBase extends ApplicationManager{

    default void type(By locator, String text){
        WebElement element = wd.findElement(locator);
        element.click();
        //element.clear();
        element.sendKeys(text);
    }

    default void click(By locator){
        wd.findElement(locator).click();
    }

    @AfterMethod
    default void tearDown() {
        pause(3000);
        wd.quit();
    }
    default void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    default boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }

    default boolean isAlertPresent(){
       Alert alert = new WebDriverWait(wd, 5)
               .until(ExpectedConditions.alertIsPresent());
        if (alert == null) return false;
        wd.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        return true;
    }
}

package manager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public interface ApplicationManager{
    WebDriver wd = new ChromeDriver(); // константа должна быть инициализирована изначально
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    default void init(){
        String link = "https://ilcarro.web.app/search";
    //    wd.manage().window().maximize(); //разворачиваем браузер на полный экран
        wd.navigate().to(link);
        logger.info("Navigated to the link --->" +link);
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //---------------------------------------------------------------------------------------------------------

    }
    default void tearDown(){
        logger.info("Test completed");
        wd.quit();
    }
}

package driversetup;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.nio.file.Paths;

public class SetupDriver {
    public static WebDriver setupDriver() {

        String exePath = Paths.get("").toAbsolutePath().toString() + File.separator + "drivers" + File.separator; //Set path of our driver
        System.setProperty("webdriver.chrome.driver", exePath + "chromedriver"); //Identifying .exe for the driver
        /*ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);*/
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}

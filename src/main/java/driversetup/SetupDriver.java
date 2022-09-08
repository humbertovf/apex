package driversetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.nio.file.Paths;

public class SetupDriver {
    public static WebDriver setupDriver() {

        String exePath = Paths.get("").toAbsolutePath().toString() + File.separator + "drivers" + File.separator; //Set path of our driver
        System.setProperty("webdriver.chrome.driver", exePath + "chromedriver"); //Identifying .exe for the driver
        WebDriver driver = new ChromeDriver(); //Instancia de ChromeDriver para usar sus metodos


        return driver;
    }
}

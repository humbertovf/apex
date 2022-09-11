package pageobjects;

import dev.failsafe.Timeout;
import driversetup.SetupDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {

    //WebDriver driver = SetupDriver.setupDriver();
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#mainSearchbar")
    private WebElement searchBar;

    @FindBy(css = "button[class='input-group-text'] i[class='icon-zoom']")
    private WebElement searchBtn;

    public void inputArticleSearchBar(String article) {
        searchBar.sendKeys(article);
    }

    public void clickSearchBtn() {
        searchBtn.click();
    }

}

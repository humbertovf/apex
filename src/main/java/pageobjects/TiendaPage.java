package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TiendaPage {

    public TiendaPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".o-nullproduct-title-query")
    private WebElement nullProductMsg;

    @FindBy(css = ".a-checkbox__input.mdc-checkbox__native-control")
    private List<WebElement> checkBoxes;

    @FindBy(css = ".searchNum-result")
    private WebElement results;

    public void checkBoxBrand(WebDriver driver, String brand) {
        //Dynamically set the brand to the xpath
        driver.findElement(By.xpath("//input[@id='brand-"+brand.toUpperCase()+"']")).click();
    }

    public void checkBoxProcessor(WebDriver driver, String processorBrand){
        //driver.findElement(By.xpath("//input[@id='dynamicFacets.ae494-"+ processorBrand +"']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='dynamicFacets.ae494-" + processorBrand + "']"))).click();
    }

    public List<WebElement> checkBoxList(){
        return checkBoxes;
    }

    public String successMsg() {
        String result = results.getText();
        return result;
    }

    public String productNotFound(){
        String errorMsg = nullProductMsg.getText();
        return errorMsg;
    }
}

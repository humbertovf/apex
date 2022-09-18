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

    @FindBy(xpath = "//a[@class='a-link__viewMore']")
    private List<WebElement> viewMore;

    @FindBy(css = ".a-checkbox__input.mdc-checkbox__native-control")
    private List<WebElement> checkBoxes;

    @FindBy(css = ".a-radio__input.mdc-radio__native-control")
    private List<WebElement> radioBtn;

    @FindBy(css = ".searchNum-result")
    private WebElement results;

    @FindBy(id = "search-filter-brands")
    private WebElement searchBrandTxt;

    public void checkBoxBrand(WebDriver driver, String brand) {
        //Dynamically set the brand to the xpath
        driver.findElement(By.xpath("//input[@id='brand-"+brand.toUpperCase()+"']")).click();
    }

    public void viewMoreClick(){
        for (int i = 0; i < viewMore.size(); i++) {
            viewMore.get(i).click();
        }
    }

    public List<WebElement> checkBoxList(){
        return checkBoxes;
    }

    public List<WebElement> radioBtnList(){
        return radioBtn;
    }

    public String successMsg() {
        String result = results.getText();
        return result;
    }

    public String productNotFound(){
        String errorMsg = nullProductMsg.getText();
        return errorMsg;
    }

    /*public void selectBrand(WebDriver driver, String brand){
        driver.findElement(By.id("brand-"+brand)).click();
    }*/

    public void typeBrand(String brand){
        searchBrandTxt.sendKeys(brand);
    }
}

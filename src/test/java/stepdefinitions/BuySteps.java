package stepdefinitions;

import driversetup.SetupDriver;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageobjects.TiendaPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BuySteps {

    WebDriver driver = SetupDriver.setupDriver();
    TiendaPage tiendaPage = new TiendaPage(driver);


    Actions action = new Actions(driver);

    /*public void implicitWait(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }*/
    @And("^I select (\\d+) pulgadas at the \"Tamaño\" panel$")
    public void selectTVSize(int tvSize) {
        //implicitWait();
        List<WebElement> checkBoxes =  tiendaPage.checkBoxList();
        tiendaPage.viewMoreClick();
        System.out.println("entrando al loop");
        for (int i = 0; i < checkBoxes.size(); i++) {
            String value = checkBoxes.get(i).getAttribute("id");
            System.out.println(value);
            if(value.equals("variants.normalizedSize-"+tvSize+" pulgadas']")){
                //checkBoxes.get(i).click();
                action.moveToElement(checkBoxes.get(i)).click().build().perform();
                //Thread.sleep(5000);
            }
        }
    }

    @And("^I select price (?:less|greater) than (\\d+) at the \"Precios\" section$")
    public void selectPriceRange(int price) throws InterruptedException {
        //implicitWait();
        Thread.sleep(3000);
        List<WebElement> radioBtns = tiendaPage.radioBtnList();
        for (int i = 0; i < radioBtns.size(); i++) {
            String value = radioBtns.get(i).getAttribute("id");
            System.out.println(value);
           /* if (price <= 5000){
                radioBtns.get(i).click();
            }else {
                radioBtns.get(i).click();
            }*/
        }
    }
}

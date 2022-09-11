package stepdefinitions;

import dev.failsafe.Timeout;
import driversetup.SetupDriver;
import globalvariables.GlobalVariables;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.TiendaPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchSteps {

    @Test
    public void test(){
        System.out.println("hola");
    }
    WebDriver driver = SetupDriver.setupDriver();
    HomePage homePage = new HomePage(driver);
    TiendaPage tiendaPage = new TiendaPage(driver);

    List<WebElement> checkBoxes =  tiendaPage.checkBoxList();

    public void implicitWait(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Given("^I access Liverpool homepage$")
    public void i_access_liverpool_homepage() {

        driver.get(GlobalVariables.HOME_PAGE);
        driver.manage().window().maximize();
    }
    @When("^I input (.+) as article in search bar$")
    public void i_input_switch_as_article_in_search_bar(String article) {
        homePage.inputArticleSearchBar(article);
    }
    @And("^I click on the search button$")
    public void i_click_on_the_search_button() {
        homePage.clickSearchBtn();
    }
    @Then("^I should be presented with the (?:successful|error) message (.+)$")
    public void validateResults(String msg) {

        implicitWait();

        boolean results = msg.contains("resultados");
        boolean noResults = msg.contains("Lo sentimos, no encontramos nada para ");


        if (results){
            String[] actualMsg = tiendaPage.successMsg().split(" ",0);
            Assert.assertEquals(tiendaPage.successMsg().contains("resultados"), msg.contains("resultados"));
        } else if (noResults) {
           Assert.assertEquals(tiendaPage.productNotFound().contains("Lo sentimos"), msg.contains("Lo sentimos"));
        }

        driver.quit();
    }
    @When("^I select (.+) at the \"Marcas\" panel$")
    public void i_select_acer_at_the_panel(String brand) {
        implicitWait();
        tiendaPage.checkBoxBrand(driver, brand);
    }
    @When("^I select (.+) at the \"Modelo del Procesador\" panel$")
    public void selectProcessor(String processorBrand) throws InterruptedException {
        implicitWait();
        Thread.sleep(3000);
        for (int i = 0; i < checkBoxes.size(); i++) {
            String value = checkBoxes.get(i).getAttribute("id");
            if (value.equals("dynamicFacets.ae494-" + processorBrand)){
                checkBoxes.get(i).click();
            }
        }
    }
    @When("^I select (.+) Gb of RAM Memory at the \"Memoria RAM\" panel$")
    public void selectRAM(String ramSize) throws InterruptedException {
        implicitWait();
        Thread.sleep(3000);
        for (int i = 0; i < checkBoxes.size(); i++) {
            String value = checkBoxes.get(i).getAttribute("id");
            if (value.equals("dynamicFacets.memoriaramatt-" + ramSize + "GB")){
                checkBoxes.get(i).click();
            }
        }
    }
}



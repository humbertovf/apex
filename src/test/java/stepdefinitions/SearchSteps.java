package stepdefinitions;

import driversetup.SetupDriver;
import globalvariables.GlobalVariables;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pageobjects.HomePage;
import pageobjects.TiendaPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchSteps {


    WebDriver driver = SetupDriver.setupDriver();
    HomePage homePage = new HomePage(driver);
    TiendaPage tiendaPage = new TiendaPage(driver);

    //List<WebElement> checkBoxes = tiendaPage.checkBoxList();

    Actions action = new Actions(driver);

    @Before
    public void setup() {
        driver.manage().window().maximize();
    }

    @After
    public void exit() {
        driver.quit();
    }

    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Given("^I access Liverpool homepage$")
    public void i_access_liverpool_homepage() {

        driver.get(GlobalVariables.HOME_PAGE);
    }

    @When("^I input (.+) as article in search bar$")
    public void searchArticle(String article) {
        homePage.inputArticleSearchBar(article);
    }

    @And("^I click on the search button$")
    public void i_click_on_the_search_button() {
        homePage.clickSearchBtn();
    }

    @Then("^I should be presented with the (?:successful|error) message (.+)$")
    public void validateResults(String msg) throws InterruptedException {

        implicitWait();

        boolean results = msg.contains("resultados");
        boolean noResults = msg.contains("Lo sentimos, no encontramos nada para ");


        if (results) {
            String[] actualMsg = tiendaPage.successMsg().split(" ", 0);
            Assert.assertEquals(tiendaPage.successMsg().contains("resultados"), msg.contains("resultados"));
            Thread.sleep(5000);
        } else if (noResults) {
            Assert.assertEquals(tiendaPage.productNotFound().contains("Lo sentimos"), msg.contains("Lo sentimos"));
        }
    }

    @When("^I select (.+) at the \"Marcas\" panel$")
    public void selectBrand(String brand) {

        implicitWait();
        tiendaPage.viewMoreClick();

        WebElement brandBox = driver.findElement(By.xpath("//input[@id='brand-" + brand.toUpperCase() + "']"));

        brandBox.click();

        System.out.println("fin del metodo marcas");

    }

    @When("^I select (.+) at the \"Modelo del Procesador\" panel$")
    public void selectProcessor(String processorBrand) {

        List<WebElement> checkBoxes = tiendaPage.checkBoxList();
        tiendaPage.viewMoreClick();
        for (int i = 0; i < checkBoxes.size(); i++) {
            String value = checkBoxes.get(i).getAttribute("id");
            if (value.equals("dynamicFacets.ae494-" + processorBrand)) {
                checkBoxes.get(i).click();
                break;
            }
        }
    }
}



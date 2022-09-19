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
import pageobjects.LoginPage;
import pageobjects.TiendaPage;

import java.time.Duration;
import java.util.List;

public class StepDefinitions {


    WebDriver driver = SetupDriver.setupDriver();
    HomePage homePage;
    TiendaPage tiendaPage;
    LoginPage loginPage;

    Actions action;

    @Before
    public void setup() {
        homePage = new HomePage(driver);
        tiendaPage = new TiendaPage(driver);
        loginPage = new LoginPage(driver);
        action = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void teardown() {
        driver.quit();
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
    public void validateResults(String msg) {

        boolean results = msg.contains("resultados");
        boolean noResults = msg.contains("Lo sentimos, no encontramos nada para ");


        if (results) {
            String[] actualMsg = tiendaPage.successMsg().split(" ", 0);
            Assert.assertEquals(tiendaPage.successMsg().contains("resultados"), msg.contains("resultados"));
            //Thread.sleep(5000);
        } else if (noResults) {
            Assert.assertEquals(tiendaPage.productNotFound().contains("Lo sentimos"), msg.contains("Lo sentimos"));
        }
    }

    @When("^I select (.+) at the \"Marcas\" panel$")
    public void selectBrand(String brand) {

        tiendaPage.viewMoreClick();

        WebElement brandBox = driver.findElement(By.xpath("//input[@id='brand-" + brand.toUpperCase() +"']"));
        brandBox.click();
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

    @And("^I select (.+) pulgadas at the \"Tamaño\" panel$")
    public void selectTVSize(String tvSize) throws InterruptedException {

        Thread.sleep(3000);
        WebElement checkBox = driver.findElement(By.id("variants.normalizedSize-"+tvSize+ " pulgadas"));
        String value = checkBox.getAttribute("id");
        System.out.println(value);
        action.moveToElement(checkBox).click().build().perform();

    }

    @And("^I select price (?:less|greater) than (\\d+) at the \"Precios\" section$")
    public void selectPriceRange(int price) throws InterruptedException {
        //implicitWait();
        Thread.sleep(3000);
        List<WebElement> radioBtns = tiendaPage.radioBtnList();
        for (int i = 0; i < radioBtns.size(); i++) {
            String value = radioBtns.get(i).getAttribute("id");
            System.out.println(value);
            if (price <= 5000){
                WebElement sortPrice1 = driver.findElement(By.id("variants.prices.sortPrice-5000-10000"));
                sortPrice1.click();
            }else {
                WebElement sortPrice2 = driver.findElement(By.id("variants.prices.sortPrice-10000-700000"));
                sortPrice2.click();
            }
        }
    }

    @When("^I click on \"Crear cuenta\" link$")
    public void createAccount() {
        homePage.clickLoginBtn();
        List<WebElement> links = loginPage.crearCuentaLink();
        links.get(1).click();
    }

    @When("^I enter an email (.+)$")
    public void enterSpecificName(String email) {
        loginPage.email(email);
    }

    @And("^I enter a password (.+)$")
    public void inputPassword(String password) {
        loginPage.password(password);
    }

    @And("^I click on the \"Crear cuenta\"$")
    public void submitCrearCuentaForm() {
        loginPage.clickLoginBtn();
    }

    @And("^I fill the form with required information (.+) (.+) (.+) (.+) (.+) (.+)$")
    public void fillForm(String name, String apellidoPaterno, String apellidoMaterno, String day, String month, String year){

        loginPage.sendUserName(name);
        loginPage.sendApellidoPaterno(apellidoPaterno);
        loginPage.sendApellidoMaterno(apellidoMaterno);
        loginPage.selectDay(day);
        loginPage.selectMonth(month);
        loginPage.selectYear(year);
        loginPage.selectMaleSex();
        loginPage.clickCreateAccountBtn();
    }

    @Then("^I should be presented with a login validation message (.+)$")
    public void validateMessage(String expectedMsg) throws InterruptedException {
        Thread.sleep(3000);
        if (expectedMsg.contains("Verificación de celular")){
            Assert.assertEquals(loginPage.successfulMsg(), expectedMsg);
        } else if (expectedMsg.contains("El correo electrónico ya ha sido registrado")) {
            Assert.assertEquals(loginPage.errorValidationMsg(), expectedMsg);
        }
    }
}



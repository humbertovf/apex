package stepdefinitions;

import driversetup.SetupDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class CreateAccountSteps {

    WebDriver driver = SetupDriver.setupDriver();
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);

   @Before
    public void setup() {
        driver.manage().window().maximize();
    }

    @When("^I click on \"Crear cuenta\" link$")
    public void createAccount() {
        loginPage.clickCrearCuentaLink();
    }

    @When("^I enter an email (.+)$")
    public void enterSpecificName(String email) {
        loginPage.email(email);
    }

    @And("^I enter a password (.+)$")
    public void inputPassword(String password) {
        loginPage.password(password);
    }

    @And("^I click on the \"Crear cuenta\" button$")
    public void submitCrearCuentaForm() {
            loginPage.clickCrearCuentaBtn();
    }

    @And("^I fill the form with required information (.+)$")
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
    public void validateMessage(String msg){

    }
}

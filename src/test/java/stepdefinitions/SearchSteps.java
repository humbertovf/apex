package stepdefinitions;

import dev.failsafe.Timeout;
import driversetup.SetupDriver;
import globalvariables.GlobalVariables;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;

import java.util.concurrent.TimeUnit;

public class SearchSteps {

    WebDriver driver = SetupDriver.setupDriver();
    HomePage homePage = new HomePage(driver);

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
    @Then("^I should be presented with the successful message (.+)$")
    public void i_should_be_presented_with_a_successful_catalog_with_the_results(String expectedResult) throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        boolean actualResult = homePage.getResults(expectedResult);
        Assert.assertTrue(actualResult);
        driver.quit();
    }


}



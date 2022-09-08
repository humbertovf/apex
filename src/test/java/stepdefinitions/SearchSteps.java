package stepdefinitions;

import driversetup.SetupDriver;
import globalvariables.GlobalVariables;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SearchSteps {

    @Given("^I access Liverpool homepage$")
    public void i_access_liverpool_homepage() {
        WebDriver driver = SetupDriver.setupDriver();
        driver.get(GlobalVariables.HOME_PAGE);
        driver.manage().window().maximize();
    }
    @When("^I input (.+) as article in search bar$")
    public void i_input_switch_as_article_in_search_bar(String article) {
        System.out.println("this is the article " + article);
    }
    @And("^I click on the search button$")
    public void i_click_on_the_search_button() {
        System.out.println("step 3");
    }
    @Then("^I should be presented with a successful catalog with the results$")
    public void i_should_be_presented_with_a_successful_catalog_with_the_results() {
        System.out.println("step 4");
    }

    @Test
    public void printSomething(){
        System.out.println("hola");
    }
}



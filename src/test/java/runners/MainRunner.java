package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"classpath:features"}, glue = {"stepdefinitions"}, tags = "@apex", monochrome = false, dryRun = false, plugin = {"pretty", "html:target/cucumber.json"})
public class MainRunner extends AbstractTestNGCucumberTests {

}
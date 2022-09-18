package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"classpath:features"}, glue = {"stepdefinitions"}, tags = "@story1.3", monochrome = false, dryRun = false)
public class MainRunner extends AbstractTestNGCucumberTests {

}

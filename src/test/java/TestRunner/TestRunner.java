package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src//test//resources//features",
glue = {"StepDefinition", "Hooks"},
plugin = {"pretty","html:target/htmlreports.html"})

public class TestRunner extends AbstractTestNGCucumberTests {

}

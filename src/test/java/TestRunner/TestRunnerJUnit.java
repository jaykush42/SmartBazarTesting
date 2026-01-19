package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src//test//resources//features",
glue = {"StepDefinition"},
plugin = {"junit:target/junitReports/report.xml"}
)
public class TestRunnerJUnit {
}

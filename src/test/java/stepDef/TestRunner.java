package stepDef;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/featureFiles", plugin = { "pretty", "html:target/ReportsDestination"}, tags = " @dev")

public class TestRunner {
}

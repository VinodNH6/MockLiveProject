package productRestTest;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:MyFeatures",
		plugin = {"pretty", "html:target/cucumber-reports"})
public class CucumberIntegrationTest {
	
}
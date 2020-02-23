package productRestTest;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:MyFeatures", format = "pretty")
public class CucumberIntegrationTest {
	
}
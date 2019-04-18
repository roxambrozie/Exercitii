package cucumberTests;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="features",glue="stepimplementations")
public class LoginTestRunner {
}

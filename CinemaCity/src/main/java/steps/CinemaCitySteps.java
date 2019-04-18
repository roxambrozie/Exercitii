package steps;

import cinemacity.CinemaCity;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;

public class CinemaCitySteps {

    private static WebDriver driver;
    private static CinemaCity cinema;

    @Given("The user opens the Cinema City homepage")
    public void beforeSuiteOpenBrowserAndNavigateToCinemaCity() {
        cinema.beforeSuite();
        cinema.openCinemaCity();
    }

    @When("The user clicks on program button")
    @Then ("The program page shows up")
    public void checkCinemaProgram(){
        cinema.checkProgram();
    }
}

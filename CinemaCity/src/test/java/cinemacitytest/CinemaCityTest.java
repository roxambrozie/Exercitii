package cinemacitytest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Constants;
import cinemacity.CinemaCity;

import java.awt.*;


public class CinemaCityTest {


    private static WebDriver driver;
    private static CinemaCity cinema;

    @BeforeSuite()
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\roxana.ambrozie\\.m2\\repository\\org\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeTest
    public void init() {
        driver.get(Constants.BASE_URL);
        driver.manage().window().maximize();
        cinema = new CinemaCity(driver);
    }

    @Test(priority = 1, groups = {"PositiveTest"})
    public void checkProgram() {
        cinema.checkProgram();
    }

    @Test(priority = 2, groups = {"PositiveTest"})
    public void makeReservation() throws AWTException {
        cinema.makeReservation("1", driver);
    }


}

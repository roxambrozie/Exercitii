package parkingtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import parking.ParkingCalculator;
import util.Constants;


public class ParkingTest {
    private static WebDriver webdriver;
    private static ParkingCalculator calculator;

    @BeforeSuite()
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\roxana.ambrozie\\.m2\\repository\\org\\chromedriver.exe");
        webdriver = new ChromeDriver();
    }

    @BeforeTest
    public void init() {
        webdriver.get(Constants.BASE_URL);
        webdriver.manage().window().maximize();
        calculator = new ParkingCalculator(webdriver);
    }

    @Test(priority =1, groups ={"PositiveTest"})
    public void testDropdownSelect(){
        calculator.dropdownpopulate("LTS");
    }

    @Test(priority = 2, groups ={"PositiveTest"})
    public void testSetEntryInput(){
        calculator.setEntryTime(Constants.ENTRY_TIME);
        calculator.setEntryDate(Constants.ENTRY_DATE);
    }

    @Test(priority = 3, groups ={"PositiveTest"})
    public void testSetExitInput(){
        calculator.setExitTimeLocator(Constants.EXIT_TIME);
        calculator.setExitDateLocator(Constants.EXIT_DATE);
    }

    @Test(priority = 4, groups ={"PositiveTest"})
    public void testCalculate(){
        calculator.calculateCost();
    }

    @Test(priority = 5, groups ={"NegativeTest"})
    public void testInvalidEntryTime(){
        calculator.dropdownpopulate("LTS");
        calculator.setEntryTime(Constants.WRONG_ENTRY_TIME);
        calculator.setEntryDate(Constants.ENTRY_DATE);
        calculator.setExitTimeLocator(Constants.EXIT_TIME);
        calculator.setExitDateLocator(Constants.EXIT_DATE);
        calculator.calculateInvalidCost();
    }

    @AfterSuite
    public void closeBrowser() {
        webdriver.close();
    }
}

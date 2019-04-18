package smoketests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PageTitleJUnit {

    //Declare variable and object at class level in order to access in multiple methods through program
    WebDriver driver;
    String webURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";

    @BeforeTest
    public void setUp() {
        System.out.println("Initializing the driver.");
        driver = utilities.DriverFactory.open("chrome");
    }

    @Test
    public void pageTitleTest() {
        System.out.println("Running the test");
        driver.get(webURL);
        String actualTitle = driver.getTitle();
        String expectedTitle = "SDET Training | Account Management";
        Assert.assertEquals(expectedTitle, actualTitle);
//        Assert.fail("We intentionally failed this test.");
    }

    @After
    public void tearDown() {
        System.out.println("Closing the driver.");
        driver.close();
    }
}

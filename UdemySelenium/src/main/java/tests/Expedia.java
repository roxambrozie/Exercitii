package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Expedia {
    WebDriver driver;
    String browserType = "Chrome";
    String city = "New York, NY";
    String checkIn = "08/02/2020";
    String checkout = "08/03/2020";
    WebElement hotelButtonLocator, destinationFieldLocator, checkInFieldLocator, checkOutFieldLocator, searchButtonLocator, fourStarCheckBoxLocator;


    public void defineWebelements() {
        hotelButtonLocator = driver.findElement(By.id("tab-hotel-tab-hp"));
        destinationFieldLocator = driver.findElement(By.id("hotel-destination-hp-hotel"));
        checkInFieldLocator = driver.findElement(By.id("hotel-checkin-hp-hotel"));
        checkOutFieldLocator = driver.findElement(By.id("hotel-checkout-hp-hotel"));
        searchButtonLocator = driver.findElement(By.xpath("//*[@id=\"gcw-hotel-form-hp-hotel\"]/div[10]/label/button"));


    }

    @Test
    public void hotelReservation() throws AWTException {
        defineWebelements();
        //1. Search
        hotelButtonLocator.click();
        destinationFieldLocator.sendKeys(city);
        checkInFieldLocator.sendKeys(checkIn);
        checkOutFieldLocator.clear();
//        checkOutFieldLocator.sendKeys(checkout);
        searchButtonLocator.click();

        //2. Modify the search results page, give criteria
 //       driver.findElement(By.cssSelector("input[name='star'][id='star4']")).click();

        //3. Analyze the results and make our selection
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        Robot robotel = new Robot();
//        robotel.mouseMove(806,401); //rand 2 loc 6
////        robotel.mouseMove(760,620); //rand 1 loc 1
//        robotel.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        robotel.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        driver.findElement(By.xpath("//*[@id=\"22688753\"]/div[2]/div/a")).click();
//        driver.findElement(By.xpath("//*[@id=\"resultsContainer\"]/section/article[1]/div[2]/div/a")).click();

        //Switch the window to the pop
        ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));

        //Print hotel name
        String hotelName = driver.findElement(By.id("hotel-name")).getText();
//        String hotelName = driver.findElement(By.xpath("//element[@attribute='content-hotel-title']")).getText();
        System.out.println("Hotel name: " + hotelName);

        //4. Book reservation
        driver.findElement(By.id("mock-book-button")).click();
        driver.findElement(By.xpath("//*[@id=\"rooms-and-rates\"]/div/article/table/tbody[1]/tr/td[3]/div/form/div[1]/button")).click();

        String hotelPrice = driver.findElement(By.cssSelector("span[class='amount-value']")).getText();
        System.out.println("The price is: " + hotelPrice);

        //5. Fill out contact/billing

        //6. Get confirmation
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Payment"));

    }

    @BeforeMethod
    public void setUp() {
        driver = utilities.DriverFactory.open(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.expedia.com/");

    }

    @AfterMethod
    public void tearDown() {
        // driver.quit();
    }
}

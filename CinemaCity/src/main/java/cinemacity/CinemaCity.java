package cinemacity;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import utils.Constants;

import java.awt.*;
import java.awt.event.InputEvent;

import static java.lang.Thread.*;


public class CinemaCity {

    WebDriver driver;
    public CinemaCity(WebDriver webDriver)
    {
        this.driver = webDriver;
    }

    By programButtonLocator = new By.ByCssSelector(".dropdown:nth-child(1) > .h2");
    By chooseCinemaNearBy = new By.ByCssSelector(".content");
    By chooseMovieHour = new By.ByLinkText("22:30");
    By selectReserveLocator = new By.ById("rbr");
    By nextButtonLocator = new By.ByCssSelector(".nextBtn");
    By pasulUrmatorLocator = new By.ById("btnNext");
    By quantityDropdownLocator = new By.ById("ddQunatity_1");
    By buttonGoToSelectSeatsLocator = new By.ById("lbSelectSeats");
    By seatLocator = new By.ById("tbSelectedSeats");
    By nameFieldLocator = new By.ById("Field_5");
    By surnameFieldLocator = new By.ById("Field_7");
    By emailFieldLocator = new By.ById("Field_20");
    By phoneFieldLocator = new By.ById("Field_21");
    By lbNext = new By.ById("lbNext");


    JavascriptExecutor js;

    public void checkProgram(){
        WebElement element = driver.findElement(programButtonLocator);
        element.click();
        WebElement element2 = driver.findElement(chooseCinemaNearBy);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(chooseCinemaNearBy));
        element2.click();
    }

    public void makeReservation(String value, WebDriver driver) throws AWTException {
        WebElement element = driver.findElement(chooseMovieHour);
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.elementToBeClickable(chooseMovieHour));
        element.click();
        WebElement element1 = driver.findElement(selectReserveLocator);
        wait.until(ExpectedConditions.elementToBeClickable(selectReserveLocator));
        element1.click();
        WebElement element2 = driver.findElement(nextButtonLocator);
        wait.until(ExpectedConditions.elementToBeClickable(nextButtonLocator));
        element2.click();
        Select element3 = new Select(driver.findElement(quantityDropdownLocator));
        wait.until(ExpectedConditions.elementToBeClickable(quantityDropdownLocator));
        element3.selectByValue(value);
        WebElement element4 = driver.findElement(buttonGoToSelectSeatsLocator);
        wait.until(ExpectedConditions.elementToBeClickable(buttonGoToSelectSeatsLocator));
        element4.click();
        js = (JavascriptExecutor) driver;

        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Robot robotel = new Robot();
//        robotel.mouseMove(1000,700); rand 2 loc 6
        robotel.mouseMove(760,620); //rand 1 loc 1
        robotel.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robotel.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

//        WebElement element5 = driver.findElement(seatLocator);
//        wait.until(ExpectedConditions.elementToBeClickable(seatLocator));
//        element5.click();

        try {
            sleep(10000);
            js.executeScript("document.getElementById('tbSelectedSeats').value='3,9' ; ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement element6 = driver.findElement(pasulUrmatorLocator);
        element6.click();

        try {
            sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement element7 = driver.findElement(nameFieldLocator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameFieldLocator));
        element7.clear();
        element7.sendKeys("Marian");
        WebElement element8 = driver.findElement(surnameFieldLocator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(surnameFieldLocator));
        element8.clear();
        element8.sendKeys("Popovici");
        WebElement element9 = driver.findElement(emailFieldLocator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldLocator));
        element9.clear();
        element9.sendKeys("andrei@mailinator.com");
        WebElement element10 = driver.findElement(phoneFieldLocator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneFieldLocator));
        element10.clear();
        element10.sendKeys("0740123456");
        WebElement element11 = driver.findElement(lbNext);
        wait.until(ExpectedConditions.elementToBeClickable(lbNext));
        element11.click();



    }

    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\roxana.ambrozie\\.m2\\repository\\org\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    public void openCinemaCity() {
        driver.get(Constants.BASE_URL);
        driver.manage().window().maximize();
    }
}
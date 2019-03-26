package parking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

public class ParkingCalculator {

    WebDriver webDriver;

    By dropdownLocator = new By.ByName("Lot");
    By entryTimeLocator = new By.ByName("EntryTime");
    By exitTimeLocator = new By.ByName("ExitTime");
    By entryDateLocator = new By.ByName("EntryDate");
    By exitDateLocator = new By.ByName("ExitDate");
    By calculateLocator = new By.ByName("Submit");

    public ParkingCalculator(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void dropdownpopulate(String value) {
        Select element = new Select(webDriver.findElement(dropdownLocator));
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        element.selectByValue(value);
    }

    public void setEntryTime(String entryTime){
        WebElement element = webDriver.findElement(entryTimeLocator);
        element.clear();
        element.sendKeys(entryTime);
    }

    public void setEntryDate(String entryDate){
        WebElement element = webDriver.findElement(entryDateLocator);
        element.clear();
        element.sendKeys(entryDate);
    }

    public void setExitTimeLocator(String exitTime){
        WebElement element = webDriver.findElement(exitTimeLocator);
        element.clear();
        element.sendKeys(exitTime);
    }

    public void setExitDateLocator(String exitDate){
        WebElement element = webDriver.findElement(exitDateLocator);
        element.clear();
        element.sendKeys(exitDate);
    }

    public void calculateCost() {
        webDriver.findElement(calculateLocator).click();
        String actualString = webDriver.findElement(By.xpath("/html/body/form/table/tbody/tr[4]/td[2]/span[1]/font/b")).getText();
        assertTrue(actualString.contains("$ 2.00"), "The price is correct: $ 2.00");
    }

    public void calculateInvalidCost(){
        webDriver.findElement(calculateLocator).click();
        String actualString = webDriver.findElement(By.xpath("/html/body/form/table/tbody/tr[4]/td[2]/span[1]/font/b")).getText();
        assertTrue(actualString.contains("$ 156,600.00"), "The price is incorrect.");

    }
}

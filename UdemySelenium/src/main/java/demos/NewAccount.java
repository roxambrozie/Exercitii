package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {

    public static void main(String[] args) {
        String name = "Mary Smith";
        String email = "ms@testemail.com";
        String password = "mspass";
        String phoneNumber = "1231231234";
        String country = "Albania";
        String browserType = "firefox";
        String gender = "Female";
        boolean weeklyEmail = true;
        boolean monthlyEmail = false;
        String occassionalEmail;

        //Define WebDriver
        WebDriver driver;
        driver = utilities.DriverFactory.open(browserType);
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
        driver.findElement(By.xpath("//*[@id=\"ctl01\"]/div[3]/div[2]/div/div[2]/a")).click();

        //Define Web elements
        WebElement nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
        WebElement emailElement = driver.findElement(By.id("MainContent_txtEmail"));
        WebElement phoneNumberElement = driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]"));
        WebElement passwordElement = driver.findElement(By.cssSelector("input[type='password'][id='MainContent_txtPassword']"));
        WebElement verifyPasswordElement = driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword"));
        WebElement countryElement = driver.findElement(By.id("MainContent_menuCountry"));
        WebElement femaleRadio = driver.findElement(By.id("MainContent_Female"));
        WebElement maleRadio = driver.findElement(By.id("MainContent_Male"));
        WebElement weeklyCheckBox = driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail"));
        WebElement submitButton = driver.findElement(By.id("MainContent_btnSubmit"));

        // Fill out the form
        nameElement.sendKeys(name);
        emailElement.sendKeys(email);
        phoneNumberElement.sendKeys(phoneNumber);
        passwordElement.sendKeys(password);
        verifyPasswordElement.sendKeys(password);
        new Select(countryElement).selectByVisibleText(country);

        // Gender Radio Button Algorithm
        if (gender.equalsIgnoreCase("Female")) {
            femaleRadio.click();
        } else {
            maleRadio.click();
        }

        // CheckBox Algorithm
        if (weeklyEmail) {
            if (!weeklyCheckBox.isSelected()) {
                weeklyCheckBox.click();
            }
        } else {
            if (weeklyCheckBox.isSelected()) {
                weeklyCheckBox.click();
            }
        }

        submitButton.click();

        // 4. Get confirmation
        String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
        String expected = "Customer information added successfully";
        if (conf.contains(expected)) {
            System.out.println("Confirmation: " + conf);
        } else {
            System.out.println("Test Failed!");
        }

        // 5. Close the browser
        driver.close();


    }
}

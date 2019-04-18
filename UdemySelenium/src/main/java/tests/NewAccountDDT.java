package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

@RunWith(value = Parameterized.class)
public class NewAccountDDT {
    String name, email, phone, gender, password, country;
    boolean weeklyEmail, monthlyEmail, occasionalEmail;
    WebElement nameElement, emailElement, phoneNumberElement, passwordElement, verifyPasswordElement, countryElement, maleRadio, femaleRadio, weeklyCheckBox, submitButton;
    WebDriver driver;

    //This is the test method
    @Test
    public void newAccountTest() {
        System.out.println("New record: " + name + " " + email + " " + phone + " " + gender + " " + password + " " + country
                + " " + weeklyEmail + " " + monthlyEmail + " " + occasionalEmail);

        //Define Web elements
        defineWebElements();

        // Fill out the form
        nameElement.sendKeys(name);
        emailElement.sendKeys(email);
        phoneNumberElement.sendKeys(phone);
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
    }

    @Before
    public void setUp() {
        driver = utilities.DriverFactory.open("chrome");
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
        driver.findElement(By.xpath("//*[@id=\"ctl01\"]/div[3]/div[2]/div/div[2]/a")).click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public void defineWebElements() {
        nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
        emailElement = driver.findElement(By.id("MainContent_txtEmail"));
        phoneNumberElement = driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]"));
        passwordElement = driver.findElement(By.cssSelector("input[type='password'][id='MainContent_txtPassword']"));
        verifyPasswordElement = driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword"));
        countryElement = driver.findElement(By.id("MainContent_menuCountry"));
        femaleRadio = driver.findElement(By.id("MainContent_Female"));
        maleRadio = driver.findElement(By.id("MainContent_Male"));
        weeklyCheckBox = driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail"));
        submitButton = driver.findElement(By.id("MainContent_btnSubmit"));
    }

    //The annotated method is designed to pass parameters into the class via constructor
    @Parameterized.Parameters
    public static List<String[]> getData() {
        return utilities.CSV.get("C:\\SDETuniversity\\Files\\UserAccounts.csv");
    }

    //Constructor that passes parameters to the test method
    public NewAccountDDT(String name, String email, String phone, String gender, String password, String country,
                         String weeklyEmail, String monthlyEmail, String occasionalEmail) {
        this.name = name; //class variable = local variable
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.password = password;
        this.country = country;

        if (weeklyEmail.equals("TRUE")) {
            this.weeklyEmail = true;
        } else {
            this.weeklyEmail = false;
        }

        if (monthlyEmail.equals("TRUE")) {
            this.monthlyEmail = true;
        } else {
            this.monthlyEmail = false;
        }

        if (occasionalEmail.equals("TRUE")) {
            this.occasionalEmail = true;
        } else {
            this.occasionalEmail = false;
        }

    }
}

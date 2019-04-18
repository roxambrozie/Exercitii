package demos;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;

public class CreateAccount {

    public static void main(String[] args) {

        //Automation is used for regression, functional and acceptance
        //Given-When-Then structure using Cucumber framework and Gherkin language

        // 1. Create WebDriver
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\roxana.ambrozie\\.m2\\repository\\org\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        // 2. Open browser and navigate to Account Management Page >> Click on create Account
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
  //      driver.findElement(By.linkText("Create Account")).click();
        driver.findElement(By.xpath("//*[@id=\"ctl01\"]/div[3]/div[2]/div/div[2]/a")).click();

        // 3. Fill out the form
        driver.findElement(By.name("ctl00$MainContent$txtFirstName")).sendKeys("Mary Smith");
        driver.findElement(By.id("MainContent_txtEmail")).sendKeys("ms@testemail.com");
        driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]")).sendKeys("1231231234"); //relative xpath
//      driver.findElement(By.xpath("html/body/form/div[3]/div[2]/div/div[2]/div[3]/div[2]/input")).sendKeys("1231231234"); //absolute xpath
        driver.findElement(By.cssSelector("input[type='password'][id='MainContent_txtPassword']")).sendKeys("mspass");
        driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword")).sendKeys("mspass");

        //How to interact with elements
        driver.findElement(By.id("MainContent_Female")).click();
//        driver.findElement(By.cssSelector("input[name='ctl00$MainContent$Gender'][value='Female']")).click();

        new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText("Albania");
        driver.findElement(By.name("ctl00$MainContent$checkMonthlyEmail")).click();
        driver.findElement(By.id("MainContent_btnSubmit")).click();

        // 4. Get confirmation
        String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
        System.out.println("Confirmation: " + conf);

        // 5. Close the browser
        driver.close();


    }
}

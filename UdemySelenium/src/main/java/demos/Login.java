package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

    public static void main(String[] args) {
        //1. Define the web driver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\roxana.ambrozie\\.m2\\repository\\org\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //2. open web browser and navigate to page
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

        //Find Elements: Locate the element, Determine the action, Pass any parameters

        //3. Enter email address
        driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("tim@testemail.com");

        //4. Enter password
        driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("trpass");

        //5. Click login
        driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();

        //6. Get confirmation
        String message = driver.findElement(By.id("conf_message")).getText();
        System.out.println("Confirmation " + message);

        String pageTitle = driver.getTitle();
        System.out.println("aici " +pageTitle+"end");
        if (pageTitle.equals("SDET Training | Account Management")) {
            System.out.println("Page title test passed.");
        }

        //7. Close the browser
        driver.close();
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public void setUserName(String username){
        driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys(username);
    }

    public void setPassword(String password){
        driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys(password);
    }

    public void clickSubmit(){
        driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
    }

    //Constructor initializes the state of the driver
    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }
}

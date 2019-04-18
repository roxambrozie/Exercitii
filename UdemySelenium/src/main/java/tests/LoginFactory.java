package tests;

import org.openqa.selenium.WebDriver;
import pages.LoginPageFactory;

public class LoginFactory {

    String username = "tim@testemaik.com";
    String password = "trpass";

    public void loginTestPageFactory(){
        WebDriver driver = utilities.DriverFactory.open("Firefox");
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

        LoginPageFactory loginPage = new LoginPageFactory(driver);
        loginPage.login(username, password);

    }

}

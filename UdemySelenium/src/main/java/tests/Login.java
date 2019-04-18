package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class Login {

    @Test
    public void loginTestPOM() {
        WebDriver driver = utilities.DriverFactory.open("Firefox");
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("tim@testemail.com");
        loginPage.setPassword("trpass");
        loginPage.clickSubmit();

        DashboardPage dashboardPage = new DashboardPage(driver);
        String conf = dashboardPage.confirmationMessage();
        String title =dashboardPage.title();

        Assert.assertTrue(conf.contains("success"));
        Assert.assertTrue(title.contains("Account"));

        driver.quit();
    }
}

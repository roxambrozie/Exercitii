package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {

    WebDriver driver;

    @FindBy(name="ctl00$MainContent$txtUserName")
    WebElement userNameBox;

    @FindBy(name="ctl00$MainContent$txtPassword")
    WebElement passwordBox;

    @FindBy(name="ctl00$MainContent$btnLogin")
    WebElement loginButton;

    public void setUserName(String username){
     userNameBox.sendKeys(username);
    }

    public void setPassword(String password){
        passwordBox.sendKeys(password);
    }

    public void clickSubmit(){
        loginButton.click();
    }

    public void login(String username, String password){
        setUserName(username);
        setPassword(password);
        clickSubmit();
    }

    //Constructor initializes the state of the driver
    public LoginPageFactory(WebDriver driver) {
        this.driver=driver;

        //Initialize web elements
        PageFactory.initElements(driver, this);
    }

}

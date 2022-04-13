package pages;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;
import utilities.PropertyReader;

public class LoginPage {

    // Non-pageFactory style page object class

//    public WebElement username = Driver.getDriver().findElement(By.id("ctl00_MainContent_username"));
//    public WebElement password = Driver.getDriver().findElement(By.id("ctl00_MainContent_password"));
//    public WebElement loginButton = Driver.getDriver().findElement(By.id("MainContent_login_button"));

  // Page Factory - design pattern used specifically in Page Classes to simplify WebElement location through @FindBy annotations

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


   // instance variables
    @FindBy (id = "ctl00_MainContent_username")
    public WebElement username;

    @FindBy (name = "ctl00$MainContent$password")
    public WebElement password;

    @FindBy (xpath = "//input[@value='Login']")
    public WebElement loginButton;

    // instance methods

    public void loginWithValidCredentials(){
        username.sendKeys(PropertyReader.getProperty("usr"));
        password.sendKeys(PropertyReader.getProperty("pass"));
        loginButton.click();
    }







}

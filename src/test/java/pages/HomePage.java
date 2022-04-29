package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "dbshb")
    public WebElement usernameField;

    @FindBy(id = "sdfdsfsd")
    public WebElement passwordField;

    @FindBy(id = "fdsdfds")
    public WebElement loginButton;
}

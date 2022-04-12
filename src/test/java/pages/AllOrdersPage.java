package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.AllOrders;
import utilities.Driver;
import utilities.PropertyReader;

import java.util.List;

public class AllOrdersPage {

    public AllOrdersPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "ctl00_MainContent_btnCheckAll")
    public WebElement checkAllButton;

    @FindBy (xpath = "//input[@type='checkbox']")
    public List<WebElement> checkboxes;


}

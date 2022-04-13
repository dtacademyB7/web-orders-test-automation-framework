package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AllOrdersPage;
import pages.LoginPage;
import utilities.PropertyReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class AllOrders extends TestBase {


    @Test (groups = {"smoke"})
    public void verifyCheckAllButton() throws IOException {



        driver.get(PropertyReader.getProperty("url"));
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(PropertyReader.getProperty("usr"), Keys.TAB, PropertyReader.getProperty("pass"), Keys.ENTER);

        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        for (WebElement checkbox : checkboxes) {
            Assert.assertTrue(checkbox.isSelected());
        }

    }

    @Test (groups = {"smoke"})
    public void verifyCheckAllButtonUsingPAgeObjectModel() throws IOException {



        driver.get(PropertyReader.getProperty("url"));

        //login page
        LoginPage loginPage = new LoginPage();
        loginPage.username.sendKeys(PropertyReader.getProperty("usr"));
        loginPage.password.sendKeys(PropertyReader.getProperty("pass"));
        loginPage.loginButton.click();

        // all orders page
        AllOrdersPage allOrdersPage = new AllOrdersPage();

        allOrdersPage.checkAllButton.click();


        for (WebElement checkbox : allOrdersPage.checkboxes) {
            Assert.assertTrue(checkbox.isSelected());
        }

    }

    @Test
    public void verifyUnCheckAllButton() {


        driver.get(PropertyReader.getProperty("url"));
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(PropertyReader.getProperty("usr"), Keys.TAB, PropertyReader.getProperty("pass"), Keys.ENTER);

        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        driver.findElement(By.id("ctl00_MainContent_btnUncheckAll")).click();

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        for (WebElement checkbox : checkboxes) {
            Assert.assertFalse(checkbox.isSelected());
        }

    }


    @Test
    public void verifyDeleteSelectedButtonPOM() {


        driver.get(PropertyReader.getProperty("url"));

//        LoginPage loginPage = new LoginPage();
//        loginPage.username.sendKeys(PropertyReader.getProperty("usr"));
//        loginPage.password.sendKeys(PropertyReader.getProperty("pass"));
//        loginPage.loginButton.click();

        new LoginPage().loginWithValidCredentials();

        AllOrdersPage allOrdersPage = new AllOrdersPage();

        allOrdersPage.checkAllCheckboxes();


        allOrdersPage.deleteSelectedButton.click();

        Assert.assertTrue(driver.getPageSource().contains("List of orders is empty. In order to add new order use"));



    }

}

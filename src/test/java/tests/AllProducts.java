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
import org.testng.asserts.SoftAssert;
import pages.AllOrdersPage;
import pages.AllProductsPage;
import pages.LoginPage;
import utilities.PropertyReader;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class AllProducts extends TestBase {



    @Test
    public void verifyColumnNames() {



        driver.get(PropertyReader.getProperty("url"));
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(PropertyReader.getProperty("usr"), Keys.TAB, PropertyReader.getProperty("pass"), Keys.ENTER);

        driver.findElement(By.linkText("View all products")).click();

        List<WebElement> columns = driver.findElements(By.xpath("//table[@class='ProductsTable']//tr[1]//th"));

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(columns.get(0).getText(), "Product name");
        softAssert.assertEquals(columns.get(1).getText(), "Price");
        softAssert.assertEquals(columns.get(2).getText(), "Discount");

        softAssert.assertAll();


    }

    @Test
    public void verifyProductNames() {


        driver.get(PropertyReader.getProperty("url"));

        LoginPage loginPage = new LoginPage();

        loginPage.username.sendKeys(PropertyReader.getProperty("usr"));
        loginPage.password.sendKeys(PropertyReader.getProperty("pass"));
        loginPage.loginButton.click();

        AllOrdersPage allOrdersPage = new AllOrdersPage();

        allOrdersPage.allProductsLink.click();

        AllProductsPage allProductsPage = new AllProductsPage();


        Assert.assertEquals(allProductsPage.productNamesList.get(0).getText(), "MyMoney");
        Assert.assertEquals(allProductsPage.productNamesList.get(1).getText(), "FamilyAlbum");
        Assert.assertEquals(allProductsPage.productNamesList.get(2).getText(), "ScreenSaver");











    }




}

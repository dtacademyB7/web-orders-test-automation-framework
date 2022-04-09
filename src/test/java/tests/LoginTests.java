package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.PropertyReader;

import java.time.Duration;

public class LoginTests extends TestBase{



    @Test (groups = {"smoke"})
    public void positiveLoginTest() {

        driver.get(PropertyReader.getProperty("url"));
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(PropertyReader.getProperty("usr"), Keys.TAB, PropertyReader.getProperty("pass"), Keys.ENTER);

        Assert.assertEquals(driver.getCurrentUrl(), "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");
    }



}
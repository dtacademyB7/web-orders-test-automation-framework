package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utilities.Driver;
import utilities.PropertyReader;
import utilities.SeleniumUtils;

import java.time.Duration;

public class TestBase {

    WebDriver driver;


    @BeforeMethod(alwaysRun = true)
    public void setupMethod() {

        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


    }

    @AfterMethod(alwaysRun = true)
    public void tearDownMethod() {
        Driver.quitDriver();
    }




}

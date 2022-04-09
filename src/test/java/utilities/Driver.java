package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * Utility class that follows the singleton design pattern to prevent multiple instantiation of the WebDriver
 */

public class Driver {

    private static WebDriver driver;

    private Driver(){} // to prevent creating objects


    public static WebDriver getDriver(){

        if(driver == null) { // check if the WebDriver is not initialized

            String browser = PropertyReader.getProperty("browser").toLowerCase();
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                default:
                    throw new RuntimeException("Invalid browser");

            }
        }

        return driver;
    }


    public static  void quitDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }

    }







}

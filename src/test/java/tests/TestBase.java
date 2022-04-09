package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setupClass() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeMethod(alwaysRun = true)
    public void setupMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


    }

    @AfterMethod(alwaysRun = true)
    public void tearDownMethod() {
        driver.quit();
    }


}

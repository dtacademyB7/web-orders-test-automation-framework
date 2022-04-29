package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class LoginTests2 extends TestBase{

    @Test (enabled = false)
    public void test1(){

        driver.get("dcbgsdgvd");
        HomePage homePage = new HomePage();
        homePage.usernameField.sendKeys("dchsbvc");
        homePage.passwordField.sendKeys("dsc");
        homePage.loginButton.click();

        Assert.assertEquals(driver.getTitle(), "cdhgsgdcvs");

    }
}

package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import TestComponents.BaseTest;
import pageObject.UserLoginPage;

public class UserLoginTest extends BaseTest {

	WebDriver driver;
	UserLoginPage loginPage;
    @Test(priority = 1)
    public void testValidLogin() {
        loginPage = new UserLoginPage(driver);

        loginPage.enterUsername("testuser");
        loginPage.enterPassword("password123");
        loginPage.clickLoginButton();

        // Assertion example: Assuming successful login redirects to dashboard
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }

    @Test(priority = 2)
    public void testInvalidLogin() {
        loginPage = new UserLoginPage(driver);

        loginPage.enterUsername("invaliduser");
        loginPage.enterPassword("invalidpassword");
        loginPage.clickLoginButton();

        // Check for error message
        Assert.assertTrue(loginPage.getErrorMessage().contains("Invalid username or password"));
    }
}


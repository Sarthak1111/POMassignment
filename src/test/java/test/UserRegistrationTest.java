package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import TestComponents.BaseTest;
import pageObject.UserRegistrationPage;

public class UserRegistrationTest extends BaseTest {

	WebDriver driver;
	UserRegistrationPage registrationPage;
	
    @Test(priority = 1)
    public void testValidRegistration() {
        registrationPage = new UserRegistrationPage(driver);

        registrationPage.enterUsername("testuser");
        registrationPage.enterPassword("password123");
        registrationPage.enterConfirmPassword("password123");
        registrationPage.enterEmail("testuser@example.com");
        registrationPage.clickRegisterButton();

        // Assertion example: Assuming successful registration redirects to dashboard
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }

    @Test(priority = 2)
    public void testInvalidRegistration() {
        registrationPage = new UserRegistrationPage(driver);

        registrationPage.enterUsername("");
        registrationPage.enterPassword("password123");
        registrationPage.enterConfirmPassword("password123");
        registrationPage.enterEmail("testuser@example.com");
        registrationPage.clickRegisterButton();

        // Check for error message
        Assert.assertTrue(registrationPage.getErrorMessage().contains("Please enter username"));
    }
}


package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import TestComponents.BaseTest;
import pageObject.UserDashboardPage;

public class UserDashboardTest extends BaseTest {

	WebDriver driver;
	UserDashboardPage dashboardPage;
	
    @Test(priority = 1)
    public void testWelcomeMessage() {
        dashboardPage = new UserDashboardPage(driver);

        String welcomeMessage = dashboardPage.getWelcomeMessage();
        Assert.assertTrue(welcomeMessage.contains("Welcome"));
    }

    @Test(priority = 2)
    public void testNavigateToUserProfile() {
        dashboardPage = new UserDashboardPage(driver);

        dashboardPage.clickUserProfileLink();

        // Assertion example: Check if navigation to user profile page is successful
        Assert.assertTrue(driver.getCurrentUrl().contains("user/profile"));
    }

    @Test(priority = 3)
    public void testNavigateToMenuItems() {
        dashboardPage = new UserDashboardPage(driver);

        dashboardPage.navigateToMenuItem("Settings");

        // Assertion example: Check if navigation to settings page is successful
        Assert.assertTrue(driver.getCurrentUrl().contains("settings"));
    }
}


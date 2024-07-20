package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Utils.BasePage;
import java.util.List;

public class UserDashboardPage extends BasePage{
    WebDriver driver;

    // WebElements locators
    @FindBy(id = "welcomeMessage")
    WebElement welcomeMessage;

    @FindBy(css = ".user-profile")
    WebElement userProfileLink;

    @FindBy(xpath = "//ul[@id='menu']/li")
    List<WebElement> menuItems;

    // Constructor
    public UserDashboardPage(WebDriver driver) {
    	super(driver);
    }

    // Methods to interact with elements
    public String getWelcomeMessage() {
        try {
            return welcomeMessage.getText();
        } catch (Exception e) {
            logger.error("Error retrieving welcome message: {}", e.getMessage());
            return null;
        }
    }

    public void clickUserProfileLink() {
        userProfileLink.click();
    }

    public void navigateToMenuItem(String menuItemText) {
        for (WebElement menuItem : menuItems) {
            if (menuItem.getText().equalsIgnoreCase(menuItemText)) {
                menuItem.click();
                break;
            }
        }
    }
}


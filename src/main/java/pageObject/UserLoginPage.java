package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utils.BasePage;

public class UserLoginPage extends BasePage{
    WebDriver driver;

    // WebElements locators
    @FindBy(id = "username")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "loginBtn")
    WebElement loginButton;

    @FindBy(id = "errorMessage")
    WebElement errorMessage;

    // Constructor
    public UserLoginPage(WebDriver driver) {
        super(driver);
    }

    // Methods to interact with elements
    public void enterUsername(String username) {
    	if (!isInputValid(username)) {
            logger.warn("Invalid input provided for login");
            return;
        }
        usernameInput.sendKeys(username);
        logger.info("Login attempted with username: ", username);
    }

    public void enterPassword(String password) {
    	if (!isInputValid(password)) {
            logger.warn("Invalid input provided for login");
            return;
        }
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getErrorMessage() {
        try {
            return errorMessage.getText();
        } catch (Exception e) {
            logger.error("Error retrieving error message: {}", e.getMessage());
            return null;
        }
    }
}


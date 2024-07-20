package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Utils.BasePage;

public class UserRegistrationPage extends BasePage{
    WebDriver driver;

    // WebElements locators
    @FindBy(id = "username")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "confirmPassword")
    WebElement confirmPasswordInput;

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(id = "registerBtn")
    WebElement registerButton;

    @FindBy(id = "errorMessage")
    WebElement errorMessage;

    // Constructor
    public UserRegistrationPage(WebDriver driver) {
        super(driver);
    }

    // Methods to interact with elements
    public void enterUsername(String username) {
    	if (!isInputValid(username)) {
    		//Security measures
            logger.warn("Invalid input provided for registration");
            return;
        }
        usernameInput.sendKeys(username);
        logger.info("Registration attempted with username: ", username);
    }

    public void enterPassword(String password) {
    	if (!isInputValid(password)) {
            logger.warn("Invalid input provided for registration");
            return;
        }
        passwordInput.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    public void enterEmail(String email) {
    	if (!isInputValid(email)) {
            logger.warn("Invalid input provided for registration");
            return;
        }
        emailInput.sendKeys(email);
    }

    public void clickRegisterButton() {
        registerButton.click();
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


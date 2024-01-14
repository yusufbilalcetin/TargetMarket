package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TargetMarketLoginPage extends BasePage {

	@FindBy(id = "login-username-input")
	private WebElement usernameInputField;

	@FindBy(id = "login-password-input")
	private WebElement passwordInputField;

	@FindBy(id = "login-button")
	private WebElement loginButton;

	@FindBy(id = "username-error-alert")
	private WebElement usernameError;

	@FindBy(id = "password-error-alert")
	private WebElement passwordError;

	public boolean isErrorMessageDisplayed() {
		return usernameError.isDisplayed();
	}

	public String getErrorMessageText() {
		return usernameError.getText();
	}

	public boolean isPasswordErrorMessageDisplayed() {
		return passwordError.isDisplayed();
	}

	public String getPasswordErrorMessageText() {
		return passwordError.getText();
	}

	public void enterUsername(String username) {
		usernameInputField.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordInputField.sendKeys(password);
	}

	public void clickLogin() {
		loginButton.click();
	}

	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLogin();
	}

}

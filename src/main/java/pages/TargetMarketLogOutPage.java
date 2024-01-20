package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TargetMarketLogOutPage extends BasePage {

	@FindBy(xpath = "//button[contains(text(),'Logout')]")
	private WebElement logOutButton;

	@FindBy(xpath = " //strong[contains(text(),'Login')]")
	private WebElement logOutText;

	public void clickOnLogOutButton() {
		logOutButton.click();
	}

	public String getLogOutText() {
		return logOutText.getText();
	}

}

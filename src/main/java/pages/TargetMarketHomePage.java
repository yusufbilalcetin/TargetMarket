package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TargetMarketHomePage extends BasePage {

	@FindBy(xpath = "//*[@id='target-market']/div[1]/h5")
	private WebElement welcomeText;

	public String getWelcomeText() {
		return welcomeText.getText();
	}

}

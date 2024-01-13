package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InarAcademyHomePage extends BasePage {
    @FindBy(linkText = "Target Market")
    private WebElement targetMarketLink;


    public InarAcademyHomePage() {
        super();
    }

    public void clickOnTargetMarketLink() {
        targetMarketLink.click();
    }
}

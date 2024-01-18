package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TargetMarketHomePage extends BasePage {

	@FindBy(xpath = "//*[@id='target-market']/div[1]/h5")
	private WebElement welcomeText;

	@FindBy(css = "#splide02-list > li")
	private List<WebElement> productCategorySlide;

	@FindBy(css = ".card-body")
	private List<WebElement> productCards;

	@FindBy(xpath = "//*[@id='navbar']/div/div/button[1]")
	private WebElement logoutButton;

	@FindBy(xpath = "//*[@id='navbar']/div/div/button[2]")
	private WebElement cartButton;

	@FindBy(xpath = "//*[@id='navbar']/div/div/button[2]/span")
	private WebElement cartButtonProductNumber;

	@FindBy(className = "modal-content")
	private WebElement cartModal;

	@FindBy(xpath = "//*[@class='modal-content']/div[3]")
	private WebElement cartModalCloseButton;

	@FindBy(css = ".list-group-item")
	private List<WebElement> productsOnTheCart;

	@FindBy(xpath = "//*[@class='modal-footer']/div/p")
	private WebElement cartTotalPrice;

	@FindBy(xpath = "//*[@class='modal-footer']/div/button")
	private WebElement checkOutButton;

	@FindBy(xpath = "//p[contains(text(),'Your cart is empty.')]")
	private WebElement cartEmptyText;

	@FindBy(xpath = "//button[contains(text(),'Close')]")
	private WebElement cartEmptyCloseButton;

	public String getWelcomeText() {
		return welcomeText.getText();
	}

	public void clickOnCategory(int index) {
		executeJavaScript("window.scroll(0,500)");
		wait(3);
		productCategorySlide.get(index - 1).click();
	}

	public WebElement findProduct(String product) {
		for (WebElement card : productCards) {
			String productName = card.findElement(By.tagName("h5")).getText();
			if (productName.equalsIgnoreCase(product)) {
				return card;
			}
		}
		return null;
	}

	public String getProductName(String productName) {
		return findProduct(productName).findElement(By.tagName("h5")).getText();
	}

	public String getProductPrice(String productName) {
		return findProduct(productName).findElement(By.className("text-danger")).getText();
	}

	public String getDiscount(String productName) {
		return findProduct(productName).findElement(By.xpath(".//p[2]/span[2]")).getText();
	}

	public String getButtonText(String productName) {
		return findProduct(productName).findElement(By.tagName("button")).getText();
	}

	public String getProductDescription(String productName) {
		return findProduct(productName).findElement(By.className("card-text")).getText();
	}

	public void addToCart(String productName) {
		executeJavaScript("window.scroll(0,1300)");
		wait(3);
		findProduct(productName).findElement(By.tagName("button")).click();
	}

	public void clickOnCartButton() {
		actions.moveToElement(cartButton).click().perform();
	}

	public void clickOnLogoutButton() {
		actions.moveToElement(logoutButton).click().perform();
	}

	public String getProductNameOnTheCart(int index) {
		return productsOnTheCart.get(index - 1).findElement(By.tagName("h3")).getText();
	}

	public String getPerProductPriceOnTheCart(int index) {
		return productsOnTheCart.get(index - 1).findElement(By.xpath(".//div/div/p[1]")).getText();
	}

	public String getTotalProductPriceOnTheCart(int index) {
		return productsOnTheCart.get(index - 1).findElement(By.xpath(".//div/div/p[2]")).getText();
	}

	public void clickOnIncreaseButtonOnCart(int index, int times) {
		for (int i = 0; i < times; i++) {
			productsOnTheCart.get(index - 1).findElement(By.xpath(".//button[contains(text(), '+')]")).click();
		}
	}

	public void clickOnDecreaseButtonOnCart(int index, int times) {
		for (int i = 0; i < times; i++) {
			productsOnTheCart.get(index - 1).findElement(By.xpath(".//button[contains(text(), '-')]")).click();
		}
	}

	public String getProductNumberOnTheCart(int index) {
		return productsOnTheCart.get(index - 1).findElement(By.tagName("span")).getText();
	}

	public String getCartEmptyText() {
		return cartEmptyText.getText();
	}

	public void clickCartEmptyCloseButton() {
		cartEmptyCloseButton.click();
	}

}

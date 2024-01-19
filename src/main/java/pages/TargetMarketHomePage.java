package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

	@FindBy(id = "sortType")
	private WebElement sortType;

	@FindBy(xpath = "//*[@id=\"sortType\"]/option[1]")
	private WebElement sortNone;

	@FindBy(xpath = "//*[@id=\"sortType\"]/option[2]")
	private WebElement sortAtoZ;

	@FindBy(xpath = "//*[@id=\"sortType\"]/option[3]")
	private WebElement sortZtoA;

	@FindBy(xpath = "//*[@id=\"sortType\"]/option[4]")
	private WebElement sortHighestPrice;

	@FindBy(xpath = "//*[@id=\"sortType\"]/option[5]")
	private WebElement sortLowestPrice;

	@FindBy(xpath = "//p[@class='fs-4']")
	private WebElement cartEmptyMessage;

	@FindBy(xpath = "//*[@id='market-items-target']/div")
	private List<WebElement> items;

	@FindBy(xpath = "//*[@id=\"splide643-list\"]")
	private WebElement splideList;

	@FindBy(css = ".card-title")
	private List<WebElement> productNames;

	@FindBy(xpath = "//strong/i")
	private List<WebElement> productPrices;

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
		executeJavaScript("window.scroll(0,1000)");
		wait(4);
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

	public boolean isProductPictureLoadedProperly(String productName) {
		return findProduct(productName).findElement(By.xpath("preceding-sibling::*")).isDisplayed();
	}

	public boolean isAddToCartButtonVisible(String productName) {
		return findProduct(productName).findElement(By.tagName("button")).isDisplayed();
	}

	public void clickOnSortType() {
		sortType.click();
	}

	public void selectByAtoZ() {
		scrollDownWithPageDown();
		sortType.click();
		sortAtoZ.click();
	}

	public void selectByZtoA() {
		sortType.click();
		sortZtoA.click();
	}

	public void selectByHighestPrice() {
		sortType.click();
		sortHighestPrice.click();
	}

	public void selectByLowestPrice() {
		sortType.click();
		sortLowestPrice.click();
	}

	public boolean isSortedAtoZ() {
		List<String> names = new ArrayList<>();
		for (WebElement productName : productNames) {
			names.add(productName.getText().toLowerCase().replace('ı', 'i'));
		}
		return compareListEquality(names,false,false);
	}

	public boolean isSortedZtoA() {
		List<String> names = new ArrayList<>();
		for (WebElement productName : productNames) {
			names.add(productName.getText().toLowerCase().replace('ı', 'i'));
		}
		return compareListEquality(names,true,false);
	}


	public boolean isSortedHighToLow() {
		List<String> prices = new ArrayList<>();
		for (WebElement productPrice : productPrices) {
			prices.add(productPrice.getText().substring(1));
		}
		return compareListEquality(prices,true,true);

	}

	public boolean isSortedLowToHigh() {
		List<String> prices = new ArrayList<>();
		for (WebElement productPrice : productPrices) {
			prices.add(productPrice.getText().substring(1));
		}
		return compareListEquality(prices,false,true);

	}
	public boolean compareListEquality(List<String> list,boolean isReverse,boolean isInteger){
		List<String> newList= new ArrayList<>(list);
		if(isInteger) Collections.sort(list, Comparator.comparingInt(Integer::parseInt));
		else Collections.sort(newList);
		if(isReverse) Collections.reverse(newList);
		return list.equals(newList);
	}

	public boolean areItemsListedCategorically(int index) {
		List<Integer> numberList = new ArrayList<>();
		if (index == 1) {
			for (int i = 1; i <= 50; i++) {
				numberList.add(i);
			}
		} else {
			for (int i = 1; i <= 5; i++) {
				if (index == 2 || index == 3)
					numberList.add(i + 5 * (index - 2));
				else
					numberList.add(i + 5 * (index - 1));
			}
		}
		List<Integer> list = new ArrayList<>();
		for (WebElement item : items) {
			list.add(Integer.parseInt(item.getAttribute("id").substring(20)));
		}
		return numberList.equals(list);
	}

	public String getCartEmptyMessage() {
		return cartEmptyMessage.getText();
	}

	public void scrollCategoriesToLeft() {
		scrollDownWithPageDown();
		actions.moveToElement(productCategorySlide.get(4)).clickAndHold()
				.moveToElement(productCategorySlide.get(1)).release().build().perform();
	}

}

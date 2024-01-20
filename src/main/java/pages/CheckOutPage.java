package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage {

	@FindBy(xpath = "//li[contains(text(),'Checkout')]")
	private WebElement checkOutText;

	@FindBy(xpath = "//span[@class='fs-3'][1]")
	private WebElement productNameText;

	@FindBy(xpath = "//span[contains(text(), 'Plastic Table')]")
	private WebElement productNameText2;

	@FindBy(xpath = "//i[@class='fw-semibold']")
	private WebElement unitPriceText;

	@FindBy(xpath = "//span[@class='text-muted']")
	private WebElement productAmountText;

	@FindBy(xpath = "//h2[@class='fs-3 text-success']")
	private WebElement totalPricetext;

	@FindBy(xpath = "//button[contains(text(),'-')]")
	private WebElement decreaseButton;

	@FindBy(xpath = "//button[contains(text(),'+')]")
	private WebElement increaseButton;

	@FindBy(id = "firstName")
	private WebElement firstNameInputField;

	@FindBy(id = "lastName")
	private WebElement lastNameInputField;

	@FindBy(id = "address")
	private WebElement addressInputField;

	@FindBy(id = "cardNumber")
	private WebElement cardNumberInputField;

	@FindBy(id = "phoneNumber")
	private WebElement phoneNumberInputField;

	@FindBy(xpath = "//button[contains(text(),'Place Order')]")
	private WebElement placeOrderButton;

	@FindBy(xpath = "//*[@id='target-market']/div[1]/div/p[1]")
	private WebElement verifyOrderScreenNameText;

	@FindBy(xpath = "//div/p[3][@class='fs-3']")
	private WebElement verifyOrderScreenTotalCostText;

	@FindBy(xpath = "//div/p[4][@class='fs-3']")
	private WebElement getVerifyOrderScreenTotalAmountText;

	@FindBy(xpath = "//div[contains(text(),'Last name is required')]")
	private WebElement lastNameErrorMessage;

	@FindBy(xpath = "//div[contains(text(),'First name is required')]")
	private WebElement firstNameErrorMessage;

	@FindBy(xpath = "//div[contains(text(),'Address is required')]")
	private WebElement adressErrorMessage;

	@FindBy(xpath = "//div[contains(text(),'Card number is required')]")
	private WebElement cardNumberErrorMessage;

	@FindBy(xpath = "//div[contains(text(),'Phone number must be 10 digits')]")
	private WebElement phoneNumberDigitErrorMessage;

	@FindBy(xpath = "//div[contains(text(),'Phone number is required')]")
	private WebElement phoneNumberRequiredErrorMessage;

	public String getProductNameOnCheckoutPage() {
		return productNameText.getText();
	}

	public String getSecondProductNameOnCheckoutPage() {
		return productNameText2.getText();
	}

	public String getProductAmountOnCheckoutPage(String amount) {
		return productAmountText.getText().substring(1);
	}

	public String getUnitPriceOnCheckOutPage() {
		return unitPriceText.getText().substring(1);
	}

	public String getTotalPrice() {
		return totalPricetext.getText().substring(14);
	}

	public void clickOnDecreaseButton() {
		decreaseButton.click();
	}

	public void clickOnIncreaseButton() {
		increaseButton.click();
	}

	public void clickOnPlaceOrderButton() {
		placeOrderButton.click();
	}

	public WebElement getFirstNameInputField() {
		return firstNameInputField;
	}

	public WebElement getLastNameInputField() {
		return lastNameInputField;
	}

	public WebElement getAdressInputField() {
		return addressInputField;
	}

	public WebElement getCardNumberInputField() {
		return cardNumberInputField;
	}

	public WebElement getPhoneNumberInputField() {
		return phoneNumberInputField;
	}

	public WebElement getFirstNameErrorMessage() {
		return firstNameErrorMessage;
	}

	public WebElement getLastNameErrorMessage() {
		return lastNameErrorMessage;
	}

	public WebElement getAdresseErrorMessage() {
		return adressErrorMessage;
	}

	public WebElement getCardNumberErrorMessage() {
		return cardNumberErrorMessage;
	}

	public WebElement getPhoneNumberDigitErrorMessage() {
		return phoneNumberDigitErrorMessage;
	}

	public WebElement getPhoneNumberRequiredErrorMessage() {
		return phoneNumberRequiredErrorMessage;
	}

	public void enterName(String name) {
		firstNameInputField.sendKeys(name);
	}

	public void entersurName(String surname) {
		lastNameInputField.sendKeys(surname);
	}

	public void enterAdress(String adress) {
		addressInputField.sendKeys(adress);
	}

	public void enterCardNumber(String cardNumber) {
		cardNumberInputField.sendKeys(cardNumber);
	}

	public void enterPhoneNumber(String phoneNumber) {
		phoneNumberInputField.sendKeys(phoneNumber);
	}

	public WebElement getVerifyOrderScreenNameText() {
		return verifyOrderScreenNameText;
	}

	public WebElement getVerifyOrderScreenTotalCostText() {
		return verifyOrderScreenTotalCostText;
	}

	public WebElement getVerifyOrderScreenTotalAmountText() {
		return getVerifyOrderScreenTotalAmountText;
	}

	public void fillOrderInformation(String name, String surname, String address, String cardNumber,
			String phoneNumber) {
		enterName(name);
		entersurName(surname);
		enterAdress(address);
		enterCardNumber(cardNumber);
		enterPhoneNumber(phoneNumber);
	}

	public String getfullNameToVerify(String name, String surname) {
		return "Hello, " + name + " " + surname + "!";
	}

	public String getTotalCostToVerify(String price) {
		return "Total Price: $" + price;
	}

	public String getTotalAmountToVerify(String amount) {
		return "Total Product Count: " + amount;
	}

}

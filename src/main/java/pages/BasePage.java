package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;

public abstract class BasePage {

	protected final WebDriver DRIVER = Driver.getDriver();

	protected WebDriverWait wait = new WebDriverWait(DRIVER, Duration.ofSeconds(10));

	public Actions actions = new Actions(Driver.getDriver());

	public BasePage() {
		PageFactory.initElements(DRIVER, this);
		DRIVER.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	private JavascriptExecutor js = (JavascriptExecutor) DRIVER;

	public void executeJavaScript(String script) {
		js.executeScript(script);
	}

	public void scrollDownWithPageDown() {
		actions.keyDown(Keys.PAGE_DOWN).release().build().perform();
		wait(1);
	}

	public void scrollUpWithPageUp() {
		actions.keyDown(Keys.PAGE_UP).release().build().perform();
		wait(1);
	}

	public void wait(int timeout) {
		try {
			Thread.sleep((long) timeout * 1000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

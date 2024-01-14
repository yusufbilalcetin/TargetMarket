package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Driver {

	private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

	private Driver() {

	}

	public synchronized static WebDriver getDriver() {
		return getDriver(System.getProperty("browserType", "chrome"));
	}

	public synchronized static WebDriver getDriver(String browserType) {
		if (DRIVER_THREAD_LOCAL.get() == null) {
			WebDriver driver;

			switch (browserType.toLowerCase()) {
				case "firefox" -> {
					FirefoxOptions firefoxOptions = new FirefoxOptions();
					firefoxOptions.addArguments("--ignore-certificate-errors");
					firefoxOptions.addArguments("--allow-running-insecure-content");
					driver = new FirefoxDriver(firefoxOptions);
					driver.manage().window().maximize();
				}

				case "edge" -> {
					EdgeOptions edgeOptions = new EdgeOptions();
					edgeOptions.addArguments("--start-maximized");
					edgeOptions.addArguments("--ignore-certificate-errors");
					edgeOptions.addArguments("--allow-running-insecure-content");
					driver = new EdgeDriver(edgeOptions);
				}

				default -> {
					ChromeOptions chromeOptions = new ChromeOptions();
					chromeOptions.addArguments("--start-maximized");
					chromeOptions.addArguments("--ignore-certificate-errors");
					chromeOptions.addArguments("--allow-running-insecure-content");
					driver = new ChromeDriver(chromeOptions);
				}
			}

			driver.get("https://InarAcademy:Fk160621.@test.inar-academy.com");
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				throw new RuntimeException(e);
			}

			if (browserType.equalsIgnoreCase("firefox")) {
				driver.navigate().refresh();
				try {
					Thread.sleep(1000);
				}
				catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}

			DRIVER_THREAD_LOCAL.set(driver);
		}
		return DRIVER_THREAD_LOCAL.get();
	}

	public static void closeDriver() {
		WebDriver currentDriver = DRIVER_THREAD_LOCAL.get();

		if (currentDriver != null) {
			currentDriver.quit();
			DRIVER_THREAD_LOCAL.remove();
		}
	}

}

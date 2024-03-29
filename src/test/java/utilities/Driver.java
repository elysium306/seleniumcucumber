package utilities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import io.github.bonigarcia.wdm.managers.InternetExplorerDriverManager;

public class Driver {
	
	/* Driver class is reusable class for webDriver and it checks the webDriver on the system.
	 * If there isn't any driver on the system, it downloads the driver and sets up the path and environment  
	 * For this purpose, I've used WebDriver manager
	 * And if I want to run my script on different browser, 
	 * all I have to do is change the browser name in the properties file.
	 */
	
	private static final String sauceHub = "https://oauth-mamatweli1-6c0b2:c6e0a686-381d-4a11-a722-6cbe8f437ce0@ondemand.us-west-1.saucelabs.com:443/wd/hub";
	
	private static WebDriver driver;
	public static WebDriver getDriver() {
		String browser = System.getProperty("browser");
		if (browser == null) {
			browser = PropertiesReader.getProperty("browser");
		}
		if (driver == null || ((RemoteWebDriver) driver).getSessionId() == null) {
			switch (browser) {
			case "firefox":
				FirefoxDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "ie":
				InternetExplorerDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;
			case "safari":
				driver = new SafariDriver();
				break;
			case "chrome":
				ChromeDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "saucelabs":
				sauceLabsSetup();
				break;
			case "headless":
			default:
				ChromeDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				driver = new ChromeDriver(options);
			}
		}
		return driver;
	}
	
	// Sauecelab configs
	
	public static void sauceLabsSetup() {
		MutableCapabilities sauceOptions = new MutableCapabilities();
		sauceOptions.setCapability("screenResolution", "1280x960");

		FirefoxOptions browserOptions = new FirefoxOptions();
		browserOptions.setCapability("platformName", "macOS 10.15");
		browserOptions.setCapability("browserVersion", "75.0");
		browserOptions.setCapability("sauce:options", sauceOptions);
		try {
			driver = new RemoteWebDriver(new URL(sauceHub), browserOptions);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}

	}

}

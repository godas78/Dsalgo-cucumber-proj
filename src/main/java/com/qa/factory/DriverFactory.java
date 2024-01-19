package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public static WebDriver driver;
	//public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	/** This method is used to initialize*/

	public WebDriver init_driver(String browser) {

		System.out.println("browser value is: " + browser);
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver();
			driver = new FirefoxDriver();
		}
		else if(browser.equals("edge")) {
			WebDriverManager.edgedriver();
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Please print the correct browser value:" + browser);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}

	public static synchronized WebDriver getDriver() {
		return driver;
	}
	public void closeallDriver() {
		driver.close();
	}

}

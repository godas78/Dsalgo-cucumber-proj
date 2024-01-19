package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

public class Portalpage {

	private static WebDriver driver = DriverFactory.getDriver();

	ConfigReader configReader = new ConfigReader();
	static String portalurl = ConfigReader.getApplicationUrl();

	//1. By locators

	//constructor of the page class:
	public static void openDsalgoportal() {
		try {
			driver.get(portalurl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Portalpage() {
		//this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public String HomePage_Title() {
		return driver.getTitle();
	}
	public String getPortalpagetitle() {
		return driver.getTitle();
	}
}


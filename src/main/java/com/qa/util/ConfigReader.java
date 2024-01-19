package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.factory.DriverFactory;

import io.cucumber.messages.types.Duration;


public class ConfigReader
{
	private static Properties prop;
	private static WebDriver driver = DriverFactory.getDriver();
	private final static String propertyFilePath = "./src/test/resources/config/config.properties";
	//private DriverFactory driverFactory;
	//driverFactory= new DriverFactory();
	//This method is used to load the properties from config.properties file
	//@return it returns properties prop object
	public static Properties init_prop()
	{
		prop=new Properties();
		try
		{
			FileInputStream ip = new FileInputStream(propertyFilePath);
			try
			{
				prop.load(ip);
				ip.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		return prop;
	}

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;

	/*public static boolean webElement_Click(WebElement element) {
		try {
			WebElement ele_toclick = new WebDriverwait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.visibilityOf(element));
				if(ele_toclick.isDisplayed())
				{
				  if(ele_toclick.isEnabled())
				  {
					try {
						ele_toclick.click();
						return true;
					    }
					catch(Exception e)
					{
						e.printStackTrace();
						return false;
					}
				  }
				  else
				  {
					throw new Exception("Element is not ENABLED");
				  }
				}
				  else {
						throw new Exception("Element is not DISPLAYED");
					}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean webSendKeys(WebElement element, String text) {
		try {
				WebElement ele = new WebDriverWait(driver, Duration.ofSeconds(10)).
					until(ExpectedConditions.visibilityOf(element));
				if(ele.isDisplayed())
				{
					if(ele.isEnabled())
					{
						try
						{
							ele.clear();
							ele.sendKeys(text);
							return true;
						}
						catch(Exception e)
						{
							e.printStackTrace();
							return false;
						}
					}
					else
					{
						throw new Exception("Element is not enabled");
					}
				}
				else
				{
					throw new Exception("Element is not displayed");
				}
			}

		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}*/
	public static String getApplicationUrl() {
		String url = prop.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	public static String getHomePageUrl() {
		String homepageurl = prop.getProperty("homepage_url");
		if (homepageurl != null)
			return homepageurl;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	public static String getcorrepondingUrl(String correspUrl) {
		String correspondingUrl = prop.getProperty(correspUrl);
		if (correspondingUrl != null)
			return correspondingUrl;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	public static String getPageTitle() {
		String title = DriverFactory.getDriver().getTitle();
		return title;
	}
	public static String getPageurl() {
		String url = DriverFactory.getDriver().getCurrentUrl();
		return url;
	}
	public static String getHomeUrl()
	{
		String home_url = DriverFactory.getDriver().getCurrentUrl();
		return home_url;

	}
	public static String registerPageURL() {
		String register_url = DriverFactory.getDriver().getCurrentUrl();
		return register_url;
	}
	public static String getexcelfilepath() {
		String excelfilelpath = prop.getProperty("excelfilepath");
		if (excelfilelpath != null)
			return excelfilelpath;
		else
			throw new RuntimeException("Excel file path not specified in the config.properties file.");
	}

	public static String getLoginPage() {
		String loginurl = prop.getProperty("loginpage");
		if (loginurl != null)
			return loginurl;
		else
			throw new RuntimeException("Homeurl not specified in the Configuration.properties file.");
	}
	// Linked list
		public static String getLinkedListUrl() {
			String linkedlisturl = prop.getProperty("linkedlisturl");
			if (linkedlisturl != null)
				return linkedlisturl;
			else
				throw new RuntimeException("linked list url not specified in the Configuration.properties file.");
		}
		
		public static String tryURL(String pagename) {
			String url = prop.getProperty(pagename);
			if (url != null)
				return url;
			else
				throw new RuntimeException(pagename + "url not specified in the Configuration.properties file.");
		}
		public static String tryEditorURL() {
			String tryeditorurl = prop.getProperty("tryeditorurl");
			if (tryeditorurl != null)
				return tryeditorurl;
			else
				throw new RuntimeException("tryeditorurl not specified in the Configuration.properties file.");
		}
		public static String geturl(String pagename) {
			String url = prop.getProperty(pagename);
			if (url != null)
				return url;
			else
				throw new RuntimeException(pagename + " url not specified in the Configuration.properties file.");
		}
		public static String getGraphUrl() {
			String graphurl = prop.getProperty("graphurl");
			if (graphurl != null)
				return graphurl;
			else
				throw new RuntimeException("graph url is not specified in the Configuration.properties file.");
		}

		public static String getGraphGraphUrl() {
			String graphgraphurl = prop.getProperty("graphgraphurl");
			if (graphgraphurl != null)
				return graphgraphurl;
			else
				throw new RuntimeException("graphgraph url is not specified in the Configuration.properties file.");
		}

		public static String getGraphRepresentationsUrl() {
			String graphrepresentationsurl = prop.getProperty("graphrepresentationsurl");
			if (graphrepresentationsurl != null)
				return graphrepresentationsurl;
			else
				throw new RuntimeException(
						"graphrepresentations url is not specified in the Configuration.properties file.");
		}
	/* this method is used to load the properties from config.properties file*/

	/*public Properties init_prop() {

		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;


	}*/

}

package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

public class LoginPage {
	public  static WebDriver driver=DriverFactory.getDriver();;
	String loginURL=ConfigReader.getLoginPage();
	boolean isRequired;
	
	@FindBy(id = "id_username")WebElement userid;
	@FindBy(id = "id_password")WebElement pass;
	@FindBy(xpath="//*[@type='submit']")WebElement Login;
	@FindBy (xpath="//div[@class='alert alert-primary']")WebElement alert;
	@FindBy (xpath="//a[@href='/register']")WebElement register;
	@FindBy (xpath="//a[@href='/logout']")WebElement signout;
	
	public LoginPage(WebDriver driver) {
		//this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public void login_page() {
		driver.get(loginURL);
	}

	public Boolean doLogin(String username, String password) {

		userid.clear();
		userid.sendKeys(username);
		pass.clear();
		pass.sendKeys(password);

		// To check empty fields , we need to check "required" field is on an attribute
		if (username.isBlank()) {
			JavascriptExecutor js_user = (JavascriptExecutor) driver;
			isRequired = (Boolean) js_user.executeScript("return arguments[0].required;", userid);
			return isRequired;
		} else if (password.isBlank()) {
			JavascriptExecutor js_password = (JavascriptExecutor) driver;
			isRequired = (Boolean) js_password.executeScript("return arguments[0].required;", pass);
			return isRequired;

		}
		return isRequired;
	}
	// input fields empty -click login
		public void login_button() {
			Login.click();
		}

		// login for excel sheet data
		public String click_login() {

			Login.click();
			String msg = alert.getText();
			return msg;
		}

		public void register_link() {
			register.click();
		}

		public String register_page() {
			String Title = driver.getTitle();
			return Title;
		}

		public void signout() {
			signout.click();
		}

}

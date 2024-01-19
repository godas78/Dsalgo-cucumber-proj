package com.pages;

	import java.util.List;
	import java.util.Map;

	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.NoSuchElementException;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import com.qa.factory.DriverFactory;
	import io.cucumber.datatable.DataTable;
	import com.qa.util.ConfigReader;
	import com.qa.util.Loggerload;

	public class Registerpage {
		public static WebDriver driver=DriverFactory.getDriver();
		String registerPageURL=ConfigReader.registerPageURL();
			
		@FindBy (xpath="//form/input[@type='submit']")WebElement registerButton;
		@FindBy (xpath="//*[@id='id_username']") WebElement user;
		@FindBy (xpath="//*[@id='id_password1']") WebElement pwd;
		@FindBy (xpath="//*[@id='id_password2']") WebElement confirmpwd;
		@FindBy (xpath="//*[@class='alert alert-primary']") WebElement errorMsg;
		

		public Registerpage(WebDriver webDriver) {

			PageFactory.initElements(driver, this);
		}

		public void navigatetoRegisterPage() {
			driver.get(registerPageURL);

		}
		public void clickOnRegisterButton() throws InterruptedException {
			Loggerload.info("The user clicks on Register button");
			registerButton.click();
			Thread.sleep(2000);
		}
		public String getEmptyfieldErrormsgUser() {
			return user.getAttribute("validationMessage");
		}
		public Boolean getEmptyRequiredUser() {
			boolean isRequired = false;
			// To check empty fields , we need to check "required" field is on an attribute
			if (user.getText().isBlank()) {
				JavascriptExecutor js_user = (JavascriptExecutor) driver;
				isRequired = (Boolean) js_user.executeScript("return arguments[0].required;", user);
			}
			return isRequired;
		}
		public void entervalidUsername(DataTable dataTable) {
			List<Map<String, String>> userdetail = dataTable.asMaps(String.class, String.class);
			for (Map<String, String> form : userdetail) {

				String userName = form.get("username");
				Loggerload.info("The user enter username as : " + userName);
				user.sendKeys(userName);
			}

		}
		public String getEmptyfieldErrormsgCofmPswd() {
			return confirmpwd.getAttribute("validationMessage");
		}
		public Boolean getEmptyRequiredPswd() {
			boolean isRequired = false;
			// To check empty fields , we need to check "required" field is on an attribute
			if (pwd.getText().isBlank()) {
				JavascriptExecutor js_user = (JavascriptExecutor) driver;
				isRequired = (Boolean) js_user.executeScript("return arguments[0].required;", pwd);
			}
			return isRequired;
		}
		public String getEmptyfieldErrormsgPswd() {
			return pwd.getAttribute("validationMessage");
		}
		public Boolean getEmptyRequiredCofmPswd() {
			boolean isRequired = false;
			// To check empty fields , we need to check "required" field is on an attribute
			if (confirmpwd.getText().isBlank()) {
				JavascriptExecutor js_user = (JavascriptExecutor) driver;
				isRequired = (Boolean) js_user.executeScript("return arguments[0].required;", confirmpwd);
			}
			return isRequired;
		}
		public void entervalidPassword(DataTable dataTable) {
			List<Map<String, String>> userdetail = dataTable.asMaps(String.class, String.class);
			for (Map<String, String> form : userdetail) {

				String passwd = form.get("password");
				Loggerload.info("The user enter password as : " + passwd);
				pwd.sendKeys(passwd);

			}

		}
		
		public void entervalidConfmPassword(DataTable dataTable) {
			List<Map<String, String>> userdetail = dataTable.asMaps(String.class, String.class);
			for (Map<String, String> form : userdetail) {

				String cpasswd = form.get("password confirmation");
				Loggerload.info("The user enter confirm password as : " + cpasswd);
				confirmpwd.sendKeys(cpasswd);

			}

		}
		public String getErrormsg() {
			String msg = null;
			try {
				msg = errorMsg.getText();
			} catch (NoSuchElementException e) {
				Loggerload.info("No such element");
			}
			return msg;

		}	
		public String getPageTitle() {
			String title = driver.getTitle();
			return title;
		}
}

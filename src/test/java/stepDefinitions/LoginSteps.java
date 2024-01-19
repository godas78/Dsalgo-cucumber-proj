package stepDefinitions;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.time.Duration;
import io.cucumber.core.cli.Main;

import java.util.Map;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.*;
import com.pages.Homepage;
import com.pages.LoginPage;
import com.pages.Registerpage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import com.qa.util.ExcelReader;
import com.qa.util.Loggerload;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	public WebDriver driver = DriverFactory.getDriver();

	LoginPage sign = new LoginPage(DriverFactory.getDriver());
	static String username;
	static String password;
	static String message;
	Boolean isRequired;
	String Excelpath = ConfigReader.getexcelfilepath();

	// User is on Sigin page
	@Given("The user is on signin page")
	public void the_user_is_on_signin_page() {

		Loggerload.info("User is on Sigin Page");
		sign.login_page();
	}
	@When("The user clicks on register link on signin page")
	public void the_user_clicks_on_register_link_on_signin_page() {
		Loggerload.info("User clicks on Register ");
		sign.register_link();
	}

	@Then("The user redirected to Registration page from signin page")
	public void the_user_redirected_to_registration_page_from_signin_page() {
		Loggerload.info("User redirected to Registraion page ");
		String Title = sign.register_page();
		System.out.println("Title of the page:" +Title);
		Loggerload.info("Title of the Page : \" " + Title + "\" ");
		assertEquals(Title, "Registration", "Title do not match");
	}
	@When("The user enter invalid {string} and {string}")
	public void the_user_enter_invalid_and(String username, String password) {
		Loggerload.info("User Enter username as \" " + username + " \" and Password as \" " + password + "\" ");
		isRequired = sign.doLogin(username, password);
		assertTrue(isRequired);
		Loggerload.info("Empty field value is validated");
	}

	@Then("click login button to verify")
	public void click_login_button_to_verify() {
		Loggerload.info("User clicks on login button");
		sign.login_button();
	}
	@Given("The user is on signin page with valid username {string} and password {string}")
	public void the_user_is_on_signin_page_with_valid_username_and_password(String username, String password) {
		sign.doLogin(username, password);
		sign.click_login();
	}

	@When("The user click signout button")
	public void the_user_click_signout_button() {
		sign.signout();
	}

	@Then("The user redirected to homepage")
	public void the_user_redirected_to_homepage() {
		Loggerload.info("User redirected to Homepage ");
	}
	@When("The user enter sheet {string} and {int}")
	public void the_user_enter_sheet_and(String sheetname, Integer rownumber) throws Exception{
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testdata = reader.getData(Excelpath, sheetname);
		username = testdata.get(rownumber).get("username");
		password = testdata.get(rownumber).get("password");
		message = testdata.get(rownumber).get("expectedmessage");

		Loggerload.info("User Enter username as \" " + username + " \"and Password as \" " + password + "\" ");
		if (username != null || password != null)
			sign.doLogin(username, password);

	}

	@Then("click login button")
	public void click_login_button() {
		Loggerload.info("User clicks on login button");
		Loggerload.info("Expected Message - Excel Sheet :  " + message);
		String msg = sign.click_login();
		Loggerload.info("Actual Message :  " + msg);
		assertEquals(msg, message);
	}
	
	@Given("The user is on Signin page of DS Algo portal")
	public void the_user_is_on_signin_page_of_ds_algo_portal() {
		Loggerload.info("User is on Sigin Page");
		sign.login_page();
	}

	@When("The user enter valid {string} and {string}")
	public void the_user_enter_valid_and(String username, String password) {
		sign.doLogin(username, password);
		
	}

	@When("The user click on login button")
	public void the_user_click_on_login_button() {
		sign.click_login();
	}
	@Then("The user logged in successfully")
	public void the_user_logged_in_successfully() {
		Loggerload.info("User is logged on success");
	}


}

package stepDefinitions;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pages.DataStructurepage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import com.qa.util.ExcelReader;
import com.qa.util.Loggerload;

public class DataStructureSteps {
	DataStructurepage dspage = new DataStructurepage();
	String Excelpath = ConfigReader.getexcelfilepath();
	static String expectedMsg;
	//static String expectedMsg;
		
	@Given("The user is on the {string} after logged in")
	public void the_user_is_on_the_after_logged_in(String string) {
		Loggerload.info("User is on the");
	}

	@When("The user clicks the {string} button in Data Structure Page introduction Panel")
	public void the_user_clicks_the_button_in_data_structure_page_introduction_panel(String string) {
	    dspage.getStarted_DS();
	}

	@Then("The user be directed to {string} page")
	public void the_user_be_directed_to_page(String pgname) {
		Loggerload.info("User redirected to " + pgname + " Page ");
		String Title = dspage.getPageTitle();
		Loggerload.info("Title of current page is : " + Title);
		assertEquals(Title, pgname, "Title do not match");
	}
	@When("The user clicks Time Complexity link")
	public void the_user_clicks_time_complexity_link() {
		dspage.getStarted_DS();
		dspage.clickOnTimeComplexitylink();
	}
	@Then("The user is redirected to {string} page")
	public void the_user_is_redirected_to_page(String pgname) {
		Loggerload.info("User redirected to " + pgname + " Page ");
		String Title = dspage.getPageTitle();
		Loggerload.info("Title of current page is : " + Title);
		assertEquals(Title, pgname, "Title do not match");
	}
	@When("The user clicks Try Here button")
	public void the_user_clicks_button_on_page() {
		dspage.getStarted_DS();
		dspage.clickOnTimeComplexitylink();
		dspage.clickOntryhereds();
	}

	@Then("The user should be redirected to a page having an tryEditor with a Run button to test")
	public void the_user_should_be_redirected_to_a_page_having_an_try_editor_with_a_run_button_to_test() {
		String Title = dspage.getPageTitle();
		String expected = dspage.getPageTitle();
		Loggerload.info("Title of current page is : " + Title);
		assertEquals(Title, expected, "Title do not match");
	}
	@Given("The user is in a page having an tryEditor with a Run button to test")
	public void the_user_is_in_a_page_having_an_try_editor_with_a_run_button_to_test() throws InterruptedException {
		dspage.getStarted_DS();
		dspage.clickOnTimeComplexitylink();
		dspage.clickOntryhereds();
		//Thread.sleep(5000);
	}

	@When("The user enter valid python code in tryEditor from sheet {string} and {int}")
	public void the_user_enter_valid_python_code_in_try_editor_from_sheet_and(String sheetName, Integer rowNum) throws Exception {
		
		Loggerload.info("The user enter valid python code in tryEditor from sheetname :" + sheetName
				+ " and row number : " + rowNum);
		dspage.enterPythonCode(sheetName, rowNum);
		expectedMsg = dspage.getExpectedResult(sheetName, rowNum);
		//dspage.entereditor(pythonC,Result);
		
	}

	@When("The user clicks on run button")
	public void the_user_clicks_on_run_button() {
	    dspage.clickrun();
	}

	@Then("The user should be presented with Run result")
	public void the_user_should_be_presented_with_run_result() {
		System.out.println("printing:");
	}
	@When("The user enter python code with invalid syntax in tryEditor from sheet {string} and {int}")
	public void the_user_enter_python_code_with_invalid_syntax_in_try_editor_from_sheet_and(String sheetName, Integer rowNum) throws InvalidFormatException, IOException {
		Loggerload.info("The user enter python code with invalid syntax in tryEditor from sheetname :" + sheetName
				+ " and row number : " + rowNum);
		dspage.enterPythonCode(sheetName, rowNum);
	}

	@Then("The user should be presented with error message")
	public void the_user_should_be_presented_with_error_message() {
		String actualMsg = dspage.getErrorText();
		Loggerload.info("Actual Error message is  :" + actualMsg);
		assertEquals(actualMsg,"NameError: name 'hello' is not defined on line 1", "Result do not match");
	}



}

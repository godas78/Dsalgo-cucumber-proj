package stepDefinitions;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.pages.LinkedListPage;
import com.pages.DataStructurepage;

import io.cucumber.java.en.*;
//import pageObjects.LinkedListPage;
import com.qa.util.ConfigReader;
import com.qa.util.Loggerload;


public class LinkedListSteps {
	LinkedListPage ll = new LinkedListPage();
	String Excelpath = ConfigReader.getexcelfilepath();
	static String expectedMsg;

	// @ll_01
	@When("The user selecting linkedlist item from the drop down menu")
	public void the_user_selecting_linkedlist_item_from_the_drop_down_menu() {
		Loggerload.info("The user select Linked List from the drop down menu");
		ll.dropdown_LinkedList();
	}
	@Then("The user redirected to {string} Page")
	public void the_user_redirected_to_page(String pgname) {
		Loggerload.info("User redirected to " + pgname + " Page ");
		String Title = ll.getPageTitle();
		Loggerload.info("Title of current page is : " + Title);
		assertEquals(Title, pgname, "Title do not match");
	}
	@When("The user clicks Introduction link")
	public void the_user_clicks_introduction_link() {
		ll.dropdown_LinkedList();
		ll.clickOnintrolink();
	}
	@Then("The user should be directed to {string} of Linked List Page")
	public void the_user_should_be_directed_to_of_linked_list_page(String pagename) {
		Loggerload.info("User redirected to the Page " + pagename);
		String Title = ll.getLinkedListPageTitle();
		Loggerload.info("Title of current page is checking:" + Title);
		assertEquals(Title, pagename, "Title do not match");
	}
	@When("The user clicks {string} button in the {string} page")
	public void the_user_clicks_button_in_the_page(String bname, String dsname) {
		ll.dropdown_LinkedList();
		ll.clickOnintrolink();
		ll.click_Tryhere(bname, dsname);
	}

	@Then("The user redirected to the page having an tryEditor with a Run button to test")
	public void the_user_redirected_to_the_page_having_an_try_editor_with_a_run_button_to_test() {
		Loggerload.info("User redirected to a page having an tryEditor with a Run button to test");
		String Title = ll.getLinkedListPageTitle();
		Loggerload.info("Title of current page is :" + Title);
		assertEquals(Title, "Assessment", "Title do not match");
	}
	@Given("The user is in a try here page having  tryEditor with a Run button to test")
	public void the_user_is_in_a_try_here_page_having_try_editor_with_a_run_button_to_test() {
		Loggerload.info("The user is in a page having an tryEditor with a Run button to test");
		ll.navigateTotryEditor();
		String Title = ll.getLinkedListPageTitle();
		Loggerload.info("Title of current page is :" + Title);
	}

	@When("The user Enter valid python code in tryEditor from sheet {string} and {int}")
	public void the_user_enter_valid_python_code_in_try_editor_from_sheet_and(String sheetName, Integer rowNum)
			throws InvalidFormatException, IOException {
		Loggerload.info("The user enter valid python code in tryEditor from sheetname :" + sheetName
				+ " and row number : " + rowNum);
		ll.enterPythonCode(sheetName, rowNum);
		expectedMsg = ll.getExpectedResult(sheetName, rowNum);
	}

	@When("user click on Run button")
	public void user_click_on_run_button() {
		ll.clickOnRunButton();
	}

	@Then("The user should be presented with the Run output")
	public void the_user_should_be_presented_with_the_run_output() {
		Loggerload.info("Expected result - Excel Sheet :  " + expectedMsg);
		String actualMsg = ll.getActualResult();
		Loggerload.info("Actual result  :" + actualMsg);
		assertEquals(actualMsg, expectedMsg, "Result do not match");
	}
	@When("The user Enter invalid python code in tryEditor from sheet {string} and {int}")
	public void the_user_enter_invalid_python_code_in_try_editor_from_sheet_and(String sheetName, Integer rowNum) throws InvalidFormatException, IOException {
		Loggerload.info("The user enter python code with invalid syntax in tryEditor from sheetname :" + sheetName
				+ " and row number : " + rowNum);
		ll.enterPythonCode(sheetName, rowNum);
	}

	@Then("The user get the error message")
	public void the_user_get_the_error_message() {
		String actualMsg = ll.getErrorText();
		Loggerload.info("Actual Error message is  :" + actualMsg);
		assertEquals(actualMsg,"NameError: name 'hello' is not defined on line 1", "Result do not match");
	}

	@When("The user clicks creating linked list link")
	public void the_user_clicks_creating_linked_list_link() {
		ll.dropdown_LinkedList();
		ll.click_creatingLinkedList();
	}
	@When("The user clicks the Types of Linked List button")
	public void the_user_clicks_the_types_of_linked_list_button() {
		ll.dropdown_LinkedList();
		ll.click_typesOflLinkedList();
	}
	@When("The user clicks the Implement Linked List in Python button")
	public void the_user_clicks_the_implement_linked_list_in_python_button() {
		ll.dropdown_LinkedList();
		ll.click_implementlinkedListInPython();
	}
	@When("The user clicks the Traversal button")
	public void the_user_clicks_the_traversal_button() {
		ll.dropdown_LinkedList();
		ll.click_traversal();
	}
	@When("The user clicks the Insertion button")
	public void the_user_clicks_the_insertion_button() {
		ll.dropdown_LinkedList();
		ll.click_insertion();
	}
	@When("The user clicks the Deletion button")
	public void the_user_clicks_the_Deletion_button() {
		ll.dropdown_LinkedList();
		ll.click_deletion();;
	}
	@When("The user clicks on the Practice Questions")
	public void the_user_clicks_on_the_practice_questions() {
		ll.click_practiceQuestion();
	}

	@Then("The user should be directed to Practice Questions of Linked List Page")
	public void the_user_should_be_directed_to_practice_questions_of_linked_list_page() {
		String Title = ll.getLinkedListPageTitle();
		Loggerload.info("Title of current page is :" + Title);
		assertEquals(Title, "Practice Questions", "Title do not match");
		Loggerload.info("NO questions found ");
	}
}

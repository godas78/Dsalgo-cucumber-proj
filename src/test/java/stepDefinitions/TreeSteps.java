package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v119.browser.Browser;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pages.TreePage;
import com.qa.util.ConfigReader;
import com.qa.util.Loggerload;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TreeSteps {
	TreePage Treep = new TreePage();
	
	String Excelpath = ConfigReader.getexcelfilepath();
	String expectedMsg;
	
	@When("The user selects Tree item from the drop down menu")
	public void the_user_selects_tree_item_from_the_drop_down_menu() {
		Loggerload.info("User click on Data Structure dropdown ");
		Loggerload.info("User select Stack from Data Structure dropdown ");
		Treep.dropdown_Tree();
	}

	@Then("The user should be directed to the {string} Page")
	public void the_user_should_be_directed_to_the_page(String pagename) {
		Loggerload.info("User redirected to Tree Data Structure Page ");
		String Title = Treep.getTreePageTitle();
		Loggerload.info("Title of current page is : " + Title);
		assertEquals(Title, pagename, "Title do not match");
	}
	@When("The user clicks on the Overview of Trees link")
	public void the_user_clicks_on_the_overview_of_trees_link() {
		Treep.dropdown_Tree();
		Treep.clickOnoverviewOfTreesPage();
	}

	@Then("The user should be directed to the {string} of tree Page")
	public void the_user_should_be_directed_to_the_of_tree_page(String pagename) {
		Loggerload.info("User redirected to " + pagename);
		String Title = Treep.getTreePageTitle();
		Loggerload.info("Title of current page is : " + Title);
		assertEquals(Title, pagename, "Title do not match");
	}
	@When("The user clicks {string} button in a {string} page")
	public void the_user_clicks_button_in_a_page(String btnname, String dstname) {
		Treep.dropdown_Tree();
		Treep.clickOnoverviewOfTreesPage();
		Treep.click_Tryhere(btnname, dstname);
	}

	@Then("The user should be redirected to a page having tryEditor with a Run button to test")
	public void the_user_should_be_redirected_to_a_page_having_try_editor_with_a_run_button_to_test() {
		Loggerload.info("User redirected to a page having an tryEditor with a Run button to test");
		String Title = Treep.getTreePageTitle();
		Loggerload.info("Title of current page is :" + Title);
		assertEquals(Title, "Assessment", "Title do not match");
	}
	@Given("The user is in trees page having an tryEditor with a Run button to test")
	public void the_user_is_in_trees_page_having_an_try_editor_with_a_run_button_to_test() {
		Loggerload.info("The user is in a page having an tryEditor with a Run button to test");
		Treep.navigateTotryEditor();
		String Title = Treep.getTreePageTitle();
		Loggerload.info("Title of current page is :" + Title);
	}

	@When("The user gets input from sheet {string} and {int} in trees")
	public void the_user_gets_input_from_sheet_and_in_trees(String sheetName, Integer rowNum) throws InvalidFormatException, IOException {
		Loggerload.info("The user enter valid python code in tryEditor from sheetname :" + sheetName
				+ " and row number : " + rowNum);
		Treep.enterTreePythoncode(sheetName, rowNum);
		expectedMsg = Treep.getExpectedResult(sheetName, rowNum);
	}

	@When("The user clicks on Run button after Entering valid python code in trees tryEditor")
	public void the_user_clicks_on_run_button_after_entering_valid_python_code_in_trees_try_editor() {
		Treep.clickOnRun();
	}

	@Then("The user should be presented with Run output for trees")
	public void the_user_should_be_presented_with_run_output_for_trees() {
		Loggerload.info("Expected result - Excel Sheet :  " + expectedMsg);
		String actualMsg = Treep.getActualResult();
		Loggerload.info("Actual result  :" + actualMsg);
		assertEquals(actualMsg, expectedMsg);
	}
	@When("The user gets invalid input from sheet {string} and {int} in trees")
	public void the_user_gets_invalid_input_from_sheet_and_in_trees(String sheetName, Integer rowNum) throws InvalidFormatException, IOException {
		Loggerload.info("The user enter python code with invalid syntax in tryEditor from sheetname :" + sheetName
				+ " and row number : " + rowNum);
		Treep.enterTreePythoncode(sheetName, rowNum);
	}

	@When("The user clicks on Run button after Entering invalid python code in trees tryEditor")
	public void the_user_clicks_on_run_button_after_entering_invalid_python_code_in_trees_try_editor() {
		Treep.clickOnRun();
	}

	@Then("The user should get the error message for trees")
	public void the_user_should_get_the_error_message_for_trees() {
		String actualMsg = Treep.getErrormsg();
		Loggerload.info("Actual result  :" + actualMsg);
		assertEquals(actualMsg,"NameError: name 'hello' is not defined on line 1", "Result do not match");
	}
	@When("The user clicks on the Terminologies button")
	public void the_user_clicks_on_the_terminologies_button() {
		Treep.dropdown_Tree();
		Treep.clickOnTerminologiesLink();
	}
	@When("The user clicks on the Types of Trees button")
	public void the_user_clicks_on_the_types_of_trees_button() {
		Treep.dropdown_Tree();
		Treep.clickOnTypesOfTreesPage();
	}
	@When("The user clicks on the Tree Traversals button")
	public void the_user_clicks_on_the_tree_traversals_button() {
		Treep.dropdown_Tree();
		Treep.clickOnTreeTraversalsLink();
	}
	@When("The user clicks on the Traversal illustration button")
	public void the_user_clicks_on_the_Traversal_illustration_button() {
		Treep.dropdown_Tree();
		Treep.clickOnTrav_illus_Link();
	}
	
	@When("The user clicks on the binary trees button")
	public void the_user_clicks_on_the_binary_trees_button() {
		Treep.dropdown_Tree();
		Treep.clickOnBinaryTreesLink();
		
	}
	@When("The user clicks on the types of binary trees button")
	public void the_user_clicks_on_the_types_of_binary_trees_button() {
		Treep.dropdown_Tree();
		Treep.clickOnTypesOfBTLink();
	}
	@When("The user clicks on the Implementation in Python button")
	public void the_user_clicks_on_the_Implementaion_in_Python_button() {
		Treep.dropdown_Tree();
		Treep.click_implementationinPython();
	}
	@When("The user clicks on the binary tree traversals button")
	public void the_user_clicks_on_the_binary_tree_traversals_button() {
		Treep.dropdown_Tree();
		Treep.click_binaryTreeTraversals();
	}
	@When("The user clicks on the Implementation of Binary Trees button")
	public void the_user_clicks_on_the_Implementation_of_Binary_Trees_button() {
		Treep.dropdown_Tree();
		Treep.click_implementationOfBinaryTrees();
	}
	@When("The user clicks on the Applications of Binary Trees button")
	public void the_user_clicks_on_the_Applications_of_Binary_Trees_button() {
		Treep.dropdown_Tree();
		Treep.click_applicationsOfBinaryTrees();
	}
	@When("The user clicks on the Binary Search Trees button")
	public void the_user_clicks_on_the_Binary_Search_Trees_button() {
		Treep.dropdown_Tree();
		Treep.click_binarySearchTrees();
	}
	@When("The user clicks on the Implementation of BST button")
	public void the_user_clicks_on_the_Implementation_of_BST_button() {
		Treep.dropdown_Tree();
		Treep.click_implementationOfBST();
	}
	@When("The user clicks on the Practice Questions in Overview of Trees")
	public void the_user_clicks_on_the_practice_questions_in_overview_of_trees() {
		Treep.dropdown_Tree();
		Treep.clickOnoverviewOfTreesPage();
		Treep.click_practiceQuestion();
	}

	@Then("The user should be directed to Practice Questions of tree page Page")
	public void the_user_should_be_directed_to_practice_questions_of_tree_page_page() {
		String Title = Treep.getTreePageTitle();
		Loggerload.info("Title of current page is :" + Title);
		assertEquals(Title, "Practice Questions", "Title do not match");
		Loggerload.info("NO questions found ");
	}
	
}

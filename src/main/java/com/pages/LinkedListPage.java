package com.pages;
import java.io.IOException;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import com.qa.util.Constants;
import com.qa.util.ElementUtil;
import com.qa.util.Loggerload;

public class LinkedListPage {
	public static WebDriver driver = DriverFactory.getDriver();
	ElementUtil eleUtil = new ElementUtil();
	String tryEditorURL = ConfigReader.tryEditorURL();

	// Homepage
	@FindBy(linkText = "Get Started")WebElement getStarted;
	@FindBy(xpath = "//a[@href='data-structures-introduction']")WebElement getStartDataStructures;
	@FindBy(xpath = "//a[@href='linked-list']")WebElement getstart_linkedlist;
	@FindBy(xpath = "//a[@class='nav-link dropdown-toggle']")WebElement dropDown;
	@FindBy(xpath = "//a[@href='/linked-list']")WebElement dropdown_linkedlist;

	// LinkedListPage
	@FindBy (xpath="//*[text()='Introduction']")WebElement introductionLink;  
	@FindBy (xpath="//a[@href='creating-linked-list']")WebElement creatinglinkedlistLink; 
	@FindBy (xpath="//a[@href='types-of-linked-list']")WebElement typesOfLLLink;  
	@FindBy (xpath="//a[@href='implement-linked-list-in-python']")WebElement implementLLInPythonLink; 
	@FindBy (xpath="//a[@href='traversal']")WebElement traversalLink; 
	@FindBy (xpath="//a[@href='insertion-in-linked-list']")WebElement insertionLink; 
	@FindBy (xpath="//a[@href='deletion-in-linked-list']")WebElement deletionLink; 
	@FindBy (xpath="//a[@href='/linked-list/practice']")WebElement practiceQuestionLink; 
	
	@FindBy(xpath = "//a[@href='/tryEditor']")WebElement tryHereLink;
	@FindBy(xpath = "//*[@class=' CodeMirror-line ']")WebElement editorInput; 
	@FindBy(xpath = "//*[@id='answer_form']/button")WebElement runButton;
	@FindBy(id = "output")WebElement output;
	
	public LinkedListPage() {

		PageFactory.initElements(driver, this);
	}

	public void dropdown_LinkedList() {
		Loggerload.info("click " + dropDown.getText() + "on drop down"); // Data Structure
		dropDown.click();
		Loggerload.info("click" + dropdown_linkedlist.getText() + "from drop down"); // Linked List
		dropdown_linkedlist.click();
	}

	public String getPageTitle() {
		String title = driver.getTitle();
		return title;
	}
	public void clickOnintrolink() {
		introductionLink.click();
	}
	public void click_Tryhere(String bname, String dsname) {
		Loggerload.info("click on " + bname + " button on " + dsname);
		tryHereLink.click();
	}
	public void enterPythonCode(String sheetname, int rownumber) throws InvalidFormatException, IOException {
		String code = eleUtil.getCodefromExcel(sheetname, rownumber);
		eleUtil.enterCode(code, editorInput);
	}
	public String getLinkedListPageTitle() {
		String title = driver.getTitle();
		return title;
	}
	public void navigateTotryEditor() {
		driver.get(tryEditorURL);
	}
	public void navigateTo(String pagename) {
		String urlName = ConfigReader.geturl(pagename);
		driver.get(urlName);
	}
	public String getExpectedResult(String sheetName, Integer rowNum) throws InvalidFormatException, IOException {
		String expectedResult = eleUtil.getResultfromExcel(sheetName, rowNum);
		return expectedResult;
	}
	public String getActualResult() {
		return output.getText();
	}
	public void clickOnRunButton() {
		runButton.click();
	}
	public String getErrorText() {
		String errorMsg = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return errorMsg;
	}
	public void click_creatingLinkedList() {
		Loggerload.info("click " + creatinglinkedlistLink.getText() + " On linked list page");
		creatinglinkedlistLink.click();
		Loggerload.info(" Title of the page " + driver.getTitle());
	}
	public void click_typesOflLinkedList() {
		Loggerload.info("click " + typesOfLLLink.getText() + " On linked list page");
		typesOfLLLink.click();
		Loggerload.info(" Title of the page " + driver.getTitle());
	}
	public void click_implementlinkedListInPython() {
		Loggerload.info("click " + implementLLInPythonLink.getText() + " On linked list page");
		implementLLInPythonLink.click();
		Loggerload.info(" Title of the page " + driver.getTitle());
	}
	public void click_traversal() {
		Loggerload.info("click " + traversalLink.getText() + " On linked list page");
		traversalLink.click();
		Loggerload.info(" Title of the page " + driver.getTitle());
	}
	public void click_insertion() {
		Loggerload.info("click " + insertionLink.getText() + " On linked list page");
		insertionLink.click();
		Loggerload.info(" Title of the page " + driver.getTitle());
	}
	public void click_deletion() {
		Loggerload.info("click " + deletionLink.getText() + " On linked list page");
		deletionLink.click();
		Loggerload.info(" Title of the page " + driver.getTitle());
	}

	public void click_practiceQuestion() {
		Loggerload.info("click " + practiceQuestionLink.getText() + " On linked list page");
		practiceQuestionLink.click();
		Loggerload.info(" Title of the page " + driver.getTitle());
	}
}

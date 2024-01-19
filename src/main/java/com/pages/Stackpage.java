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

public class Stackpage {
	public static WebDriver driver = DriverFactory.getDriver();
	ElementUtil eleUtil = new ElementUtil();
	String tryEditorURL = ConfigReader.tryEditorURL();

	// Homepage
	@FindBy(xpath = "//a[@href='data-structures-introduction']")WebElement getStartDataStructures;
	@FindBy(xpath = "//a[@href='stack']")WebElement getstart_stack;
	@FindBy(xpath = "//a[@class='nav-link dropdown-toggle']")WebElement dropdown;
	@FindBy(xpath = "//a[@href='/stack']")WebElement dropdown_stack;

	// StackPage_operationsinstack
	@FindBy(xpath = "//a[@href=\"operations-in-stack\"]")WebElement operationsInStackLink;
	@FindBy(xpath = "//a[@href=\"implementation\"]")WebElement implementationLink;
	@FindBy(xpath = "//a[@href='stack-applications']")WebElement applicationLink;
	@FindBy(xpath = "//a[@class='list-group-item list-group-item-light text-info']")WebElement practiceQuestionLink;

	@FindBy(xpath = "//a[@href='/tryEditor']")WebElement TryHereLink;
	@FindBy(xpath = "//textarea[@tabindex='0']")WebElement editorInput;
	@FindBy(xpath = "//*[@id='answer_form']/button")WebElement runButton;
	@FindBy(id = "output")WebElement output;
	
	public Stackpage() {
		//Stackpage.driver = null;
		PageFactory.initElements(driver, this);
		
	}
	public void dropdown_stack(){
		Loggerload.info("click " + dropdown.getText() + "on drop down");
		dropdown.click();
		Loggerload.info("click " + dropdown_stack.getText() + "from the drop down");
		//Thread.sleep(5000);
		dropdown_stack.click();
	}
	public String getStackPageTitle() {
		String title = driver.getTitle();
		return title;
	}
	public void navigateTo(String pagename) {
		String URL = ConfigReader.tryURL(pagename);
		driver.get(URL);
		String urlName = ConfigReader.geturl(pagename);
		driver.get(urlName);
	}
	public void clickOnOperationsInstackpage() {
		Loggerload.info("click " + operationsInStackLink.getText() + "On stack page");
		operationsInStackLink.click();
	}
	public void clickOnimplementationlink() {
		Loggerload.info("click " + implementationLink.getText() + "On stack implementation page");
		implementationLink.click();
	}
	public void clickOnapplicationslink() {
		Loggerload.info("click " + applicationLink.getText() + "On stack applications page");
		applicationLink.click();
	}

	public void clickOnPracticeQuestionspage() {
		practiceQuestionLink.click();
	}
	public void clickTryHereLink(String bname, String dsname) {
		Loggerload.info("click on " + bname + " button on " + dsname);
		TryHereLink.click();

	}
	public void enterStackPythoncode(String sheetname, int rownumber) throws InvalidFormatException, IOException {
		String code = eleUtil.getCodefromExcel(sheetname, rownumber);
		eleUtil.enterCode(code, editorInput);
	}
	public String getExpectedResult(String sheetName, Integer rowNum) throws InvalidFormatException, IOException {
		String expectedResult = eleUtil.getResultfromExcel(sheetName, rowNum);
		return expectedResult;
	}
	public String getActualResult() {
		return output.getText();
	}
	public void clickOnRun() {
		runButton.click();
	}
	public String getErrormsg() {
		String errormsg = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return errormsg;
	}
	public void navigateTotryEditor() {
		driver.get(tryEditorURL);

	}
	public String getErrorText() {
		String errorMsg = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return errorMsg;
	}
}

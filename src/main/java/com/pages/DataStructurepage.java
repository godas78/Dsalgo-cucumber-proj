package com.pages;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import com.qa.util.ElementUtil;
import com.qa.util.Loggerload;

public class DataStructurepage {
public static WebDriver driver=DriverFactory.getDriver();
	ElementUtil eleUtil = new ElementUtil();
	String tryEditorURL = ConfigReader.tryEditorURL();
	public String pythonCode;
	@FindBy (xpath="//a[@href='data-structures-introduction']")WebElement dataStrucIntroLink;
	//@FindBy (xpath="//a[@href='time-complexity']")WebElement timeComplexitylink;
	
	@FindBy (xpath="//*[text()='Time Complexity']")WebElement timeComplexitylink; 
	@FindBy (xpath="//*[text()='Try here>>>']")WebElement tryhereds;
	//@FindBy (xpath="//div[@class='CodeMirror cm-s-default']")WebElement tryeditor;
	//private WebElement editorInput = By.xpath("//*[@class='CodeMirror cm-s-default']");
	@FindBy (xpath="//*[@class=' CodeMirror-line ']")WebElement editorInput;
	@FindBy (xpath="//*[@id='answer_form']/button")WebElement run;
	@FindBy(xpath = "//a[@href='/tryEditor']")WebElement tryHereLink;
	@FindBy(id = "output")WebElement output;
	
	public DataStructurepage() {

		PageFactory.initElements(driver, this);
	}

	public void getStarted_DS() {

		Loggerload.info("click " + dataStrucIntroLink.getText() + " link on home page");
		dataStrucIntroLink.click();
	}

	public String getPageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public void clickOnTimeComplexitylink() {
		timeComplexitylink.click();

	}
	public void clickOntryhereds() {
		tryhereds.click();

	}
	public void click_Tryhere(String bname, String dsname) {
		Loggerload.info("click on " + bname + " button on " + dsname);
		tryHereLink.click();
	}
	public void enterPythonCode(String sheetname, int rownumber) throws InvalidFormatException, IOException {
		String code = eleUtil.getCodefromExcel(sheetname, rownumber);
		eleUtil.enterCode(code, editorInput);
	}
	public void clickrun() {
		run.click();
	}
	public String getExpectedResult(String sheetName, Integer rowNum) throws InvalidFormatException, IOException {
		String expectedResult = eleUtil.getResultfromExcel(sheetName, rowNum);
		return expectedResult;
	}
	public String getActualResult() {
		return output.getText();
	}
	public String getErrorText() {
		String errorMsg = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return errorMsg;
	}
}

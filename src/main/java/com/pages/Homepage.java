package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import com.qa.util.Loggerload;

import io.cucumber.messages.types.Duration;

public class Homepage {

	public WebDriver driver = DriverFactory.getDriver();
	String url=ConfigReader.getApplicationUrl();
	String homepage_url=ConfigReader.getHomePageUrl();

	//ConfigReader configReader = new ConfigReader();
	//String portalurl = ConfigReader.getApplicationUrl();
	//Dsalgo page
	@FindBy (xpath="//a[@href='/home']")WebElement getstart_link;
	@FindBy (xpath="//*[text()='Get Started']")WebElement getstart;
	 //alert 
	@FindBy (xpath="//*[@class='alert alert-primary']")WebElement nosign_msg;
	
	
		//Homepage
		@FindBy (xpath="//a[@href='data-structures-introduction']")WebElement getstart_datastructures;
		@FindBy (xpath="//a[@href='array']")WebElement getstart_array;
		@FindBy (xpath="//a[@href='linked-list']")WebElement getstart_linkedlist;
		@FindBy (xpath="//a[@href='stack']")WebElement getstart_stack;
		@FindBy (xpath="//a[@href='queue']")WebElement getstart_queue;
		@FindBy (xpath="//a[@href='tree']")WebElement getstart_tree;
		@FindBy (xpath="//a[@href='graph']")WebElement getstart_graph;
		
		@FindBy (xpath="//a[@href='#']")WebElement dropdown;
		@FindBy (xpath="//div[@class='dropdown-menu show']")WebElement dropdown_array;
		@FindBy (xpath="//*[@id='navbarCollapse']//a[2]")WebElement dropdown_linkedlist;
		@FindBy (xpath="//*[@id='navbarCollapse']//a[3]")WebElement dropdown_stack;
		@FindBy (xpath="//*[@id='navbarCollapse']//a[4]")WebElement dropdown_queue;
		@FindBy (xpath="//*[@id='navbarCollapse']//a[5]")WebElement dropdown_tree;
		@FindBy (xpath="//*[@id='navbarCollapse']//a[6]")WebElement dropdown_graph;
		
		//sigin
		@FindBy (xpath="//a[@href='/login']") WebElement signin;
		//register
		@FindBy (xpath="//a[@href='/register']")WebElement register;
		
	//1. By locators

		
	public Homepage() {
			PageFactory.initElements(driver,this);
			
		}
	public void dsalgopage() {

		driver.get(url);

	}
	
	public String getPageTitle() {

		String title = driver.getTitle();
		return title;

	}
	public void getStarted_link(String str) {
		getstart_link.click();
	}
	public String nosign() {

		String msg = nosign_msg.getText();
		return msg;

	}

	// Home page Elements
	public void homepage() {

		driver.get(homepage_url);

	}
	public void getStarted_home(String string) throws InterruptedException {
		
		switch (string) {
		case "Data Structures-Introduction":
			Loggerload.info("click " + getstart_datastructures.getText() + "link on  DataStructures ");
			System.out.println("now click on DS GS");
			Thread.sleep(2000);
			getstart_datastructures.click();
			break;
		case "Arrays":
			Loggerload.info("click " + getstart_array.getText() + "link on Array ");
			Thread.sleep(2000);
			getstart_array.click();
			break;
		case "Linkedlist":
			Loggerload.info("click " + getstart_linkedlist.getText() + "link on LinkedList");
			Thread.sleep(2000);
			getstart_linkedlist.click();
			break;
		case "Stack":
			Loggerload.info("click " + getstart_stack.getText() + "link on stack");
			Thread.sleep(2000);
			getstart_stack.click();
			break;
		case "Queue":
			Loggerload.info("click " + getstart_queue.getText() + "link on queue ");
			Thread.sleep(2000);
			getstart_queue.click();
			break;
		case "Tree":
			Loggerload.info("click " + getstart_tree.getText() + "link on Tree ");
			Thread.sleep(2000);
			getstart_tree.click();
			break;
		case "Graph":
			Loggerload.info("click " + getstart_graph.getText() + "link on Graph ");
			Thread.sleep(2000);
			getstart_graph.click();
			break;
		}
	}
	public void dropdown(String string) throws InterruptedException {

		dropdown.click();
		switch (string) {
		case "Arrays":
			Loggerload.info("User click on " + string);
			Thread.sleep(2000);
			dropdown_array.click();
			Thread.sleep(2000);
			break;
		case "Linkedlist":
			Loggerload.info("User click on " + string);
			Thread.sleep(2000);
			dropdown_linkedlist.click();
			break;
		case "Stack":
			Loggerload.info("User click on " + string);
			Thread.sleep(2000);
			dropdown_stack.click();
			break;
		case "Queue":
			Loggerload.info("User click on " + string);
			Thread.sleep(2000);
			dropdown_queue.click();
			break;
		case "Tree":
			Loggerload.info("User click on " + string);
			Thread.sleep(2000);
			dropdown_tree.click();
			break;
		case "Graph":
			Loggerload.info("User click on " + string);
			Thread.sleep(2000);
			dropdown_graph.click();
			break;
		}

	}
	public void signin_link() {
		signin.click();
	}

	public String login_page() {
		String title = driver.getTitle();
		return title;
	}

	// Register
	public void register_link() {
		register.click();
	}

	public String register_page() {
		String title = driver.getTitle();
		return title;
	}
}


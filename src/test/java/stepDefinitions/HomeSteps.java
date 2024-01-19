package stepDefinitions;

import org.testng.Assert;

import com.pages.Homepage;
import com.qa.util.Loggerload;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeSteps {

	//public WebDriver driver;
	//public WebDriver driver = DriverFactory.getDriver();
	Homepage home = new Homepage();
	
	
	@Given("The user opens DS Algo portal link")
	public void the_user_opens_ds_algo_portal_link() throws Exception {

		Loggerload.info("User is on DSAlgo portal page");
		home.dsalgopage();
	}

	@When("User Click on {string}")
	public void user_click_on(String string) throws InterruptedException {
		Loggerload.info("User clicks on \"Getstarted link\" on Main Page");
		home.getStarted_link(string);
		Thread.sleep(2000);
	}

	@Then("Home Page Title should be {string}")
	public void home_page_title_should_be(String string) {
		String Title = home.getPageTitle();
		Loggerload.info("Title of current page is ***** " + Title + " ****");
		Assert.assertEquals(Title, "NumpyNinja", "Title do not match");

		//Assert.assertTrue(title.contains(expectedpageTitle));
	}
	@Given("User is on Homepage")
	public void user_is_on_homepage() {
		String title = home.getPageTitle();
	    System.out.println("title of the page is :" +title);
	}	
	@When("now click on {string} get started without login")
	public void now_click_on_get_started_without_login(String string) throws InterruptedException {
		Loggerload.info("User clicks on \"Getstarted link\" on Main Page");
		home.getStarted_home(string);
	}

	@Then("The user get warning message {string}")
	public void the_user_get_warning_message(String expectedmsg) {
		System.out.println("i am locating the element");
		String msg = home.nosign();
		//WebDriverWait wait = new WebDriverWait(driver,Duration(200));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(msg));
		System.out.println("i see error message :" +msg);
		Loggerload.info("Actual Message : " +msg);
		Assert.assertEquals(msg, expectedmsg, "Title do not match");

}
	@When("The user clicks on dropdown {string}")
	public void the_user_clicks_on_dropdown(String string) throws InterruptedException {
		Loggerload.info("User clicks on dropdown without login");
		home.dropdown(string);
	}
	@When("The user clicks on signin link")
	public void the_user_clicks_on_signin_link() throws InterruptedException {
		Loggerload.info("User clicking on Sign in ");
	    home.signin_link();
	    Thread.sleep(2000);
	}

	@Then("The user redirected to login page")
	public void the_user_redirected_to_login_page() {
		Loggerload.info("User is now redirected to login page ");
		String Title = home.login_page();
		Loggerload.info("Title of current page is : " + Title);
		Assert.assertEquals(Title, "Login", "Title do not match");
	}

	@When("The user clicks on register link")
	public void the_user_clicks_on_register_link() {
		Loggerload.info("User clicking on Sign in ");
	    home.register_link();;
	}

	@Then("The user redirected to Registration page")
	public void the_user_redirected_to_registration_page() {
		Loggerload.info("User redirected to Registraion page ");
		String Title = home.register_page();
		Loggerload.info("Title of current page is : " + Title);
		Assert.assertEquals(Title, "Registration", "Title do not match");
	}

}

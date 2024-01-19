package stepDefinitions;
import org.testng.Assert;

import com.pages.Portalpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Portalsteps {
	private static String title;
	Portalpage pp = new Portalpage();

	@Given("user is on Portalpage")
	public void user_is_on_portalpage() {
		//DriverFactory.getDriver().get("https://dsportalapp.herokuapp.com/");
		pp.openDsalgoportal();
	}

	@When("user gets title of the page")
	public void user_gets_title_of_the_page() {
		title = pp.getPortalpagetitle();
		System.out.println("Portal page Title is :"+ title);
	}

	@Then("portal Page Title should be {string}")
	public void portal_page_title_should_be(String expectedpageTitle) {
		Assert.assertTrue(title.contains(expectedpageTitle));
	}

}

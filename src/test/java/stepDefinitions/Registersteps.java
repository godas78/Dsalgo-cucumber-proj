package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qa.factory.DriverFactory;
import com.qa.util.Loggerload;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.pages.Registerpage;

public class Registersteps {
	public WebDriver driver = DriverFactory.getDriver();

	Registerpage register = new Registerpage(DriverFactory.getDriver());

	// @TS_register_02
	@Given("The user opens Register Page")
	public void the_user_opens_register_page() {
		Loggerload.info("The user opens Register Page");
		register.navigatetoRegisterPage();
	}

	@When("The user clicks {string} button with all fields empty")
	public void the_user_clicks_button_with_all_fields_empty(String string) throws InterruptedException {
		Loggerload.info("The user do not enter any values");
		register.clickOnRegisterButton();
	}

	@Then("It should display an error message {string} below Username textbox")
	public void it_should_display_an_error_message_below_username_textbox(String expErrormsg) {
		Loggerload.info("Error message is displayed " + register.getEmptyfieldErrormsgUser()
				+ " an error below Username textbox");
		Assert.assertTrue(register.getEmptyRequiredUser(), "Username Field is Empty - required attribute is validated");
		Assert.assertEquals(register.getEmptyfieldErrormsgUser(), expErrormsg);
	}
	@When("The user clicks {string} button after entering username with other fields empty")
	public void the_user_clicks_button_after_entering_username_with_other_fields_empty(String string,
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		Loggerload.info("The user enter valid username with other fields empty");
		register.entervalidUsername(dataTable);
		register.clickOnRegisterButton();
		
	}

	@Then("It should display an error message {string} below Password textbox")
	public void it_should_display_an_error_message_below_password_textbox(String expErrormsg) {
}
	@When("The user clicks {string} button after entering {string} and {string} with Password Confirmation field empty")
	public void the_user_clicks_button_after_entering_and_with_password_confirmation_field_empty(String string,
			String string2, String string3, io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		register.entervalidUsername(dataTable);
		register.entervalidPassword(dataTable);
		register.clickOnRegisterButton();
	}

	@Then("It should display an error message {string} below Password Confirmation textbox")
	public void it_should_display_an_error_message_below_password_confirmation_textbox(String expErrormsg) {
		Loggerload.info("Error message is displayed " + register.getEmptyfieldErrormsgCofmPswd()
				+ " an error below Username textbox");
		Assert.assertTrue(register.getEmptyRequiredCofmPswd(), "Username Field is Empty - required attribute is validated");
		Assert.assertEquals(register.getEmptyfieldErrormsgCofmPswd(), expErrormsg);
	}
	@When("The user enters a {string} with characters other than Letters, digits and {string}")
	public void the_user_enters_a_with_characters_other_than_letters_digits_and(String string, String string2, io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		register.entervalidUsername(dataTable);
		register.entervalidPassword(dataTable);
		register.entervalidConfmPassword(dataTable);
		register.clickOnRegisterButton();
	}
	@Then("It should display an error message {string}")
	public void it_should_display_an_error_message(String expErrormsg) {
		Loggerload.info("Expected Error message is as : " + expErrormsg);
		Loggerload.info("Error message is displayed as : " + register.getErrormsg());
		Assert.assertEquals(register.getErrormsg(), expErrormsg);    
	}
	@When("The user clicks {string} button after entering valid {string} and different passwords in {string} and {string} fields")
	public void the_user_clicks_button_after_entering_valid_and_different_passwords_in_and_fields(String string, String string2, String string3, String string4, io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		register.entervalidUsername(dataTable);
		register.entervalidPassword(dataTable);
		register.entervalidConfmPassword(dataTable);
		register.clickOnRegisterButton();
	}
	@When("The user enters a valid {string} and {string} and {string}")
	public void the_user_enters_a_valid_and_and(String string, String string2, String string3, io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		register.entervalidUsername(dataTable);
		register.entervalidPassword(dataTable);
		register.entervalidConfmPassword(dataTable);
		register.clickOnRegisterButton();
	}
	@Then("The user should be redirected to Homepage with the message {string}")
	public void the_user_should_be_redirected_to_homepage_with_the_message(String string) {
		Loggerload.info("User redirected to Homepage ");
		String Title = register.getPageTitle();
		Loggerload.info("Title of current page is : " + Title);
		Assert.assertEquals(Title, "NumpyNinja", "Title do not match");
	}
}
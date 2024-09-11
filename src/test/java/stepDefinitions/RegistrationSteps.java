package stepDefinitions;

import java.util.Map;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import pageObjects.HomePage;

import pageObjects.RegistrationPage;

public class RegistrationSteps {
	WebDriver driver;
	HomePage hp;
	RegistrationPage regPage;
	
	@Given("the user navigates to Register Account Page")
	public void the_user_navigates_to_register_account_page() {
		hp=new HomePage(BaseClass.getDriver());
		hp.hoverMyAccount();
		hp.clickRegister();
	}

	@When("the user fills in the registration form with valid details")
	public void the_user_fills_in_the_registration_form_with_valid_details(DataTable dataTable) {
		Map<String, String> dataMap=dataTable.asMap(String.class,String.class);
		regPage=new RegistrationPage(BaseClass.getDriver());
		regPage.SetFirstName(dataMap.get("firstName"));
		regPage.SetlastName(dataMap.get("lastName"));
		regPage.SetEmail(BaseClass.randomAlphaNumeric()+"@gmail.com");
		regPage.SetTelephone(dataMap.get("Telephone"));
		regPage.SetPassword(dataMap.get("password"));
		regPage.SetConfirmPassword(dataMap.get("Confirmpassword"));
		
	}

	@When("the user selects Newsletter Subscribe")
	public void the_user_selects_newsletter_subscribe() {
	    regPage.selectSubscribe();
	}

	@When("the user selects Privacy policy")
	public void the_user_selects_privacy_policy() {
	   regPage.acceptPrivacy();
	}

	@When("the user click on Continue button")
	public void the_user_click_on_continue_button() {
	   regPage.clickContinue();
	}

	@Then("the user Account should be created successfully")
	public void the_user_account_should_be_created_successfully() {
	   String expectedMgs=regPage.getConfirmationMessage();
	   Assert.assertEquals(expectedMgs, "Your Account Has Been Created!");
	}

}

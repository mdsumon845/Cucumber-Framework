package stepDefinitions;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import org.junit.Assert;

import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.ConfirmOrder;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.RegistrationPage;

public class E2ESteps {
	
	HomePage hp;
	RegistrationPage regPage;
	MyAccountPage mypage;
	CartPage cartPage;
	CheckoutPage checkout;
	ConfirmOrder confirmOrder;
	@Given("the user navigates to the Register Account Page")
	public void the_user_navigates_to_the_register_account_page() {
	    hp=new HomePage(BaseClass.getDriver());
	    hp.hoverMyAccount();
	    hp.clickRegister();
	}

	@When("the user selects Subscribe to Newsletter")
	public void the_user_selects_subscribe_to_newsletter() {
		regPage=new RegistrationPage(BaseClass.getDriver());
		regPage.selectSubscribe();
	}

	@When("the user accepts the Privacy Policy")
	public void the_user_accepts_the_privacy_policy() {
		regPage.acceptPrivacy();
	}

	@When("the user clicks on the Continue button")
	public void the_user_clicks_on_the_continue_button() {
		regPage.clickContinue();
	}

	@Then("the user account should be created successfully")
	public void the_user_account_should_be_created_successfully() throws Exception {
		String expectedMgs=regPage.getConfirmationMessage();
		Assert.assertEquals(expectedMgs, "Your Account Has Been Created!");
		
	}
	
	@When("the user click the continue button")
	public void the_user_click_the_continue_button() throws Exception {
		mypage=new MyAccountPage(BaseClass.getDriver());
		mypage.ClickContinueAfterRegister();
	}

	@Then("the user should be redirected to the dashboard")
	public void the_user_should_be_redirected_to_the_dashboard() {
		 mypage=new MyAccountPage(BaseClass.getDriver());
		   boolean tergetPage=mypage.isMyAccountPageExists();
		  Assert.assertTrue(tergetPage);
	}
	
	@When("the user searches for a product {string}")
	public void the_user_searches_for_a_product(String string) throws Exception {
		   hp=new HomePage(BaseClass.getDriver());
		   hp.productSearch(BaseClass.getProperties().getProperty("searchProductName3"));
	}

	@When("the user adds the product to the cart")
	public void the_user_adds_the_product_to_the_cart() throws Exception {
		cartPage=new CartPage(BaseClass.getDriver());
		cartPage.addProductToCart();
	}

	@When("the user navigates to the cart")
	public void the_user_navigates_to_the_cart() {
		cartPage.navigateToCartPage();
	}

	@Then("the shopping Cart text should be displayed")
	public void the_shopping_cart_text_should_be_displayed() {
		boolean expectedPage=cartPage.getCartPage();
		Assert.assertEquals(expectedPage, true);
	}
	
	@When("the user proceeds to checkout")
	public void the_user_proceeds_to_checkout() {
		cartPage.clickCheckout();
	}

	@When("the user enters shipping details")
	public void the_user_enters_shipping_details() {
		checkout=new CheckoutPage(BaseClass.getDriver());
		checkout.setFirstName(BaseClass.firstname());
		checkout.setLastName(BaseClass.lastName());
		checkout.setCompanyName(BaseClass.CompanyName());
		checkout.setAddress1(BaseClass.Address1());
		checkout.setAddress2(BaseClass.Address2());
		checkout.setCity(BaseClass.city());
		checkout.setPostCode(BaseClass.postCode());
		checkout.selectCountry();
		checkout.selectState();
		checkout.setComment(BaseClass.comment());
		checkout.selectTermsAndConditions();
		checkout.clickContinue();	
	}

	@Then("the user sees the order confirmation page")
	public void the_user_sees_the_order_confirmation_page() {
		boolean expectedPage=confirmOrder.getTargetPage();
		Assert.assertEquals(expectedPage, true);
	}

	@When("the user clicks on the Confirm Order button")
	public void the_user_clicks_on_the_confirm_order_button() {
		confirmOrder.clickConfirmBtn();
	}

	@Then("the order confirmation text should be displayed")
	public void the_order_confirmation_text_should_be_displayed() {
		boolean expectedMgs=confirmOrder.getOrderConfirmationMgs();
		Assert.assertEquals(expectedMgs, true);
	}

}

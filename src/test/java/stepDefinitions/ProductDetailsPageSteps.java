package stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.ProductDetailsPage;
import pageObjects.ProductPage;

public class ProductDetailsPageSteps {
	HomePage hp;
	ProductPage pp;
	ProductDetailsPage pdp;
	
	@When("the user searches for {string} and clicks the search button")
	public void the_user_searches_for_and_clicks_the_search_button(String string) throws Exception {
	    hp=new HomePage(BaseClass.getDriver());
	    hp.productSearch(BaseClass.getProperties().getProperty("searchProductName2"));
	}

	@When("the search results are displayed")
	public void the_search_results_are_displayed() {
	   pp=new ProductPage(BaseClass.getDriver());
	  List<WebElement> results=pp.results();
	  for(WebElement  result:results) 
	  {
		 Assert.assertTrue(result.isDisplayed()); 
	  }
	}

	@When("the user clicks on the {string} product link")
	public void the_user_clicks_on_the_product_link(String string) {
		pp.productLinkClick();
	}

	@Then("the product code should be visible, confirming successful navigation to the product details page")
	public void the_product_code_should_be_visible_confirming_successful_navigation_to_the_product_details_page() {
	   pdp=new ProductDetailsPage(BaseClass.getDriver());
	  boolean targetPage=pdp.isProductCodeExists();
	  Assert.assertEquals(targetPage, true);
	}

}

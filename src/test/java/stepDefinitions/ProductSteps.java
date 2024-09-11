package stepDefinitions;

import java.io.IOException;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.ProductPage;

public class ProductSteps {
	HomePage hp;
	ProductPage pp;
	@When("the user searches for {string}")
	public void the_user_searches_for(String string) throws Exception {
		hp=new HomePage(BaseClass.getDriver());
		hp.productSearch(BaseClass.getProperties().getProperty("searchProductName"));
		Thread.sleep(3000);
		
	}

	@Then("the search results should display products related to {string}")
	public void the_search_results_should_display_products_related_to(String string) {
	   pp=new ProductPage(BaseClass.getDriver());
	   pp.searchResults();
	}
}

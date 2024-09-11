package stepDefinitions;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.ProductSearch;

public class ProductAdvanceSearchSteps {

	HomePage hp;
	ProductSearch ps;
	
	@Given("the search bar is displayed on the homepage")
	public void the_search_bar_is_displayed_on_the_homepage() {
	   hp =new HomePage(BaseClass.getDriver());
	   hp.searchBarPresence();
	}

	@When("the user clicks on the search button")
	public void the_user_clicks_on_the_search_button() {
	  hp.clickSearchBtn();
	}

	@When("the user scrolls up to the Price Filter")
	public void the_user_scrolls_up_to_the_price_filter() {
	   ps=new ProductSearch(BaseClass.getDriver());
	   ps.scrollUptoPriceFillter();
	}

	@When("filters the price using mouse actions")
	public void filters_the_price_using_mouse_actions() {
	   ps.priceFilltering();
	}

	@When("clicks on the Apple Brand")
	public void clicks_on_the_apple_brand() {
	   ps.clickOnAppleBrand();
	}

	@When("clicks on the In Stock button")
	public void clicks_on_the_in_stock_button() {
	   ps.clickInStockBtn();
	}

	@When("clicks on the List icon")
	public void clicks_on_the_list_icon() {
	   ps.clickOnListIcon(); 
	}

	@Then("all products should be related to the Apple Brand and within the filtered price range")
	public void all_products_should_be_related_to_the_apple_brand_and_within_the_filtered_price_range() {
	   ps.ProductAdvanceSearchResults();
	}

}

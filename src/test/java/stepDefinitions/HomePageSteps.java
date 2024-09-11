package stepDefinitions;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pageObjects.HomePage;

public class HomePageSteps {
	HomePage hp;
	
	@Then("the user should see the logo")
	public void verifyLogoIsDisplayed() {
		BaseClass.getLogger().info("verifying logo is displayed "); 
		hp=new HomePage(BaseClass.getDriver());
		boolean logoIsPresence=hp.logoPresence();
		Assert.assertEquals(logoIsPresence, true);
	}
	
	
	
}

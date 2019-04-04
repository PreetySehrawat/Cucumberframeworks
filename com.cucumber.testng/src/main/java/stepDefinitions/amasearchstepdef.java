package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class amasearchstepdef {
	@Given("^Amazon website is open$")
	public void amazon_website_is_open() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println("Inside testng Given");
	}

	@When("^search is enabled$")
	public void search_is_enabled() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Inside testng When");
	}

	@Then("^all fiction books should be listed$")
	public void all_fiction_books_should_be_listed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Inside testng Then");
	}
}

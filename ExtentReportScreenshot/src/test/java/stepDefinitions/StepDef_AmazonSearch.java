package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.AmazonMainPage;

public class StepDef_AmazonSearch {
	
	AmazonMainPage amp = new AmazonMainPage();

	@Given("^Amazon website is open$")
	public void amazon_website_is_open() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		amp.launchBrowser();
	}

	@When("^search is enabled$")
	public void search_is_enabled() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		amp.SearchFictionBooks();
	}

	@Then("^all fiction books should be listed$")
	public void all_fiction_books_should_be_listed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String expectedTitle = "Literature & Fiction Books";
		String actualTitle = amp.getPageTitle();
		if(actualTitle.contains(expectedTitle))
		{
			System.out.println("Test is successful");
		}
		else
			System.out.println("Test is Failed");
		
		amp.closedriver();
	}
	
	
	/*
	@Given("^Amazon website is open$")
	public void amazon_website_is_open() {
	    // Write code here that turns the phrase above into concrete actions
	    amp.launchBrowser();
	}

	@When("^search is enabled$")
	public void search_is_enabled() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		amp.SearchFictionBooks();
	}

	@Then("^all fiction books should be listed$")
	public void all_fiction_books_should_be_listed() {
	    // Write code here that turns the phrase above into concrete actions
		String expectedTitle = "Literature & Fiction Books";
		String actualTitle = amp.getPageTitle();
		if(actualTitle.contains(expectedTitle))
		{
			System.out.println("Test is successful");
		}
		else
			System.out.println("Test is Failed");
		
		amp.closedriver();
		
	}*/

}

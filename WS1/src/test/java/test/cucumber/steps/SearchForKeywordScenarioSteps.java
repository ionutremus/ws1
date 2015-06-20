package test.cucumber.steps;

import net.thucydides.core.annotations.Steps;
import test.junit.steps.search.SearchSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class SearchForKeywordScenarioSteps {

	@Steps
    SearchSteps imdb;
	
    @Given("I (?:want|would like) to see (.*)")
    public void buyerWantsToBuy(String keyword) {
        imdb.openHomePage();
    }
    
    @When("I search for '(.*)'")
    public void searchFor(String keyword){
    	imdb.searchForKeyword(keyword);
    }
    
    @Then("I should see only movies related to '(.*)'")
    public void verifyIfSearchResultsContain(String keyword){
    	imdb.verifyIfSearchResultsContain(keyword);
    }
}

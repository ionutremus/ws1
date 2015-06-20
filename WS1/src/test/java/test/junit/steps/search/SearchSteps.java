package test.junit.steps.search;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.concurrent.TimeUnit;

import test.pages.SearchPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class SearchSteps extends ScenarioSteps {

	SearchPage search;

	@Step
	public void searchForKeyword(String keyword) {
		search.enterKeyword(keyword);
		search.clickSearchButton();
	}

	@Step
	public void verifyIfSearchResultContains(String keyword) {
		assertEquals(keyword.toLowerCase(), search.getFirstResultLinkText()
				.toLowerCase());
		assertThat(search.getFirstResultLinkText()).isEqualToIgnoringCase(
				keyword);
	}

	@Step
	public void verifyIfSearchResultsContain(String keyword) {
		List<String> searchResultTexts = search.getResultsLinkTests();
		for (String resultText : searchResultTexts) {
//			assertTrue(resultText.toLowerCase().contains(keyword.toLowerCase()));
			assertThat(resultText).containsIgnoringCase(keyword);
		}
	}

	public void openHomePage() {
		 search.open();		
	}

}

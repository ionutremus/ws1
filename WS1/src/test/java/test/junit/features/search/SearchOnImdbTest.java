package test.junit.features.search;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import test.junit.steps.search.SearchSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;

@WithTags( {
    @WithTag(type="priority",name="medium"),
    @WithTag(type="component",name="search"),
    @WithTag(type="special", name="JUnit")

})
@RunWith(SerenityRunner.class)
public class SearchOnImdbTest {
    @Managed
    WebDriver driver;

    @Steps
    SearchSteps imdb;
    
    @Before
    public void setUp() throws Exception {
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      driver.manage().window().maximize();
      driver.get("http://www.imdb.com");
    }

    @Test
    public void searchByKeyword() {
    	String keyword = "supernatural";
        imdb.searchForKeyword(keyword);
        imdb.verifyIfSearchResultContains(keyword);
        imdb.verifyIfSearchResultsContain(keyword);
    }
}

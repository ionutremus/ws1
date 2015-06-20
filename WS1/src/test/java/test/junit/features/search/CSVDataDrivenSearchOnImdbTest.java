package test.junit.features.search;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import test.junit.steps.search.SearchSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.TestData;
import net.thucydides.junit.annotations.UseTestDataFrom;

@WithTags( {
    @WithTag(type="priority",name="medium"),
    @WithTag(type="component",name="search"),
    @WithTag(type="special", name="JUnit")

})
@RunWith(SerenityParameterizedRunner.class)
@Concurrent
@UseTestDataFrom(value="src/test/resources/testData/data.csv")
public class CSVDataDrivenSearchOnImdbTest {
    @Managed
    WebDriver driver;

    @Steps
    SearchSteps imdb;

    private String keyword;
    
    public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public CSVDataDrivenSearchOnImdbTest(String keyword) {
        this.keyword = keyword;
    }
    
    @Before
    public void setUp() throws Exception {
      driver.manage().window().maximize();
      driver.get("http://www.imdb.com");
    }

    @Test
    public void searchByKeyword() {
        imdb.searchForKeyword(keyword);
        imdb.verifyIfSearchResultContains(keyword);
    }
}

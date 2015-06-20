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

@WithTags( {
    @WithTag(type="priority",name="medium"),
    @WithTag(type="component",name="search"),
    @WithTag(type="special", name="JUnit")

})
@RunWith(SerenityParameterizedRunner.class)
@Concurrent
public class DataDrivenSearchOnImdbTest {
    @Managed
    WebDriver driver;

    @Steps
    SearchSteps imdb;
    
    @TestData                                               
    public static Collection<Object[]> testData(){
        return Arrays.asList(new Object[][]{
                {"supernatural"},
                {"avatar"},
                {"friends"}
        });
    }

    private final String keyword;
    
    public DataDrivenSearchOnImdbTest(String keyword) {
        this.keyword = keyword;
    }
    
    @Before
    public void setUp() throws Exception {
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      driver.manage().window().maximize();
      driver.get("http://www.imdb.com");
    }

    @Test
    public void searchByKeyword() {
        imdb.searchForKeyword(keyword);
        imdb.verifyIfSearchResultContains(keyword);
        imdb.verifyIfSearchResultsContain(keyword);
    }
}

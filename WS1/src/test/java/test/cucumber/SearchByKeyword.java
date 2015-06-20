package test.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;

@WithTags( {
    @WithTag(type="priority",name="medium"),
    @WithTag(type="component",name="search"),
    @WithTag(type="special", name="Cucumber")

})
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/search/searchByKeyword.feature")
public class SearchByKeyword {

}

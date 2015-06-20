package test.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://www.imdb.com")
public class SearchPage  extends PageObject{

    @FindBy(id="navbar-query")
    WebElementFacade searchInput;
    
    @FindBy(id="navbar-submit-button")
    WebElementFacade searchButton;
    
    @FindBy(xpath="(//table[@class='findList']//td[@class='result_text']/a)[1]")
    WebElementFacade firstResultLink;
    
    @FindBy(xpath="//table[@class='findList']//td[@class='result_text']/a")
    List<WebElement> searchResultLinks;
    
	public void enterKeyword(String keyword) {
		searchInput.type(keyword);
	}

	public void clickSearchButton() {
		searchButton.click();
	}

	public String getFirstResultLinkText() {
		return firstResultLink.getText();
	}
	
	public List<String> getResultsLinkTests(){
		return searchResultLinks.stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
	}

}

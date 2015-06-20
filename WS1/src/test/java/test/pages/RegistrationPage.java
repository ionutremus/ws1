package test.pages;

import java.util.UUID;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class RegistrationPage   extends PageObject{

    @FindBy(xpath="//input[@value='Register']")
    WebElementFacade registerButton;
    
    @FindBy(id="nblogin")
    WebElementFacade loginButton;
    
    @FindBy(linkText="Register")
    WebElementFacade registerLink;
    
    @FindBy(id="first_name")
    WebElementFacade firstName;
    
    @FindBy(id="last_name")
    WebElementFacade lastName;
    
    @FindBy(id="gender_f")
    WebElementFacade genderF;
    
    @FindBy(id="year")
    WebElementFacade year;
    
    @FindBy(xpath="//select[@id='country']/option[@value='RO']")
    WebElementFacade countryRo;
    
    @FindBy(id="postal")
    WebElementFacade postal;
    
    @FindBy(id="email")
    WebElementFacade email;
    
    @FindBy(id="password1")
    WebElementFacade password1;
    
    @FindBy(id="password2")
    WebElementFacade password2;
    
    public void navigateToRegistrationPage(){
    	withAction().moveToElement(loginButton).perform();
    	registerLink.click();
    }
    
    public void fillInDummyData(){
    	firstName.sendKeys("John");
    	lastName.sendKeys("Doe");
    	genderF.click();
    	year.sendKeys("1984");
    	countryRo.click();
    	postal.sendKeys("123456");
    	email.sendKeys(UUID.randomUUID() + "@test.com");
    	password1.sendKeys("12345678Qq#");
    	password2.sendKeys("12345678Qq#");
    }

	public void clickOnRegisterButton() {
			registerButton.click();
	}
	
	public String getWelcomeText(){
        return $("//h1").getText();
	}
	
}

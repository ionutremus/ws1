package test.junit.steps.registration;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import test.pages.RegistrationPage;
import static org.junit.Assert.assertEquals;


public class RegistrationSteps  extends ScenarioSteps {

	RegistrationPage user;
	
	@Step
	public void navigateToRegistrationPage() {
		user.navigateToRegistrationPage();
	}

	@Step
	public void fillInAllTheFields() {
		user.fillInDummyData();
		
	}

	@Step
	public void clickRegister() {
		user.clickOnRegisterButton();
	}

	@Step
	public void verifyIfRegistrationIsCorrect() {
		assertEquals(user.getWelcomeText(),"John Doe, welcome to your new IMDb account!");
	}

}

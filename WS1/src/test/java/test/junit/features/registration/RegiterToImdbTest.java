package test.junit.features.registration;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import test.junit.steps.registration.RegistrationSteps;
import test.junit.steps.search.SearchSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;

@WithTags( {
    @WithTag(type="priority",name="high"),
    @WithTag(type="component",name="registration"),
    @WithTag(type="special", name="JUnit")

})

@RunWith(SerenityRunner.class)
public class RegiterToImdbTest {
    @Managed
    WebDriver driver;

    @Steps
    RegistrationSteps user;
    
    @Before
    public void setUp() throws Exception {
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      driver.manage().window().maximize();
      driver.get("http://www.imdb.com");
    }

    @Test
    public void tegisterToImdb() {
    	user.navigateToRegistrationPage();
    	user.fillInAllTheFields();
    	user.clickRegister();
    	user.verifyIfRegistrationIsCorrect();
    }
}

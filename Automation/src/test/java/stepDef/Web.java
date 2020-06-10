package stepDef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Log;
import base.Utilities;

	
@RunWith(Cucumber.class)
public class Web {
	
	public WebDriverWait wait;
	
    private Utilities utl;
    public Web(Utilities utl) {
        this.utl = utl;
    }

    @Then("^User is taken to Google Homepage$")
    public void user_is_taken_to_google_homepage() throws InterruptedException  {
        utl.switchToWebContext();
    }
    
    @Given("^The \"([^\"]*)\" is open$")
    public void the_something_is_open(String arg1)  {
        utl.check(arg1);
    }
    
    @And("^Scroll$")
    public void scroll() {
        utl.scroll();
    }

    @Then("^Drag \"([^\"]*)\" and drop to \"([^\"]*)\"$")
    public void drag_something_and_drop_to_something(String arg1, String arg2) {
    	utl.dragndrop(arg1, arg2);
    }
    
    @And("^Slide \"([^\"]*)\" to \"([^\"]*)\"$")
    public void slide_something_to_something(String arg1, String arg2) throws Throwable {
        utl.moveSliderToNumber(arg1, arg2);
    }


}
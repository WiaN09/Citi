package stepDef;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;
import org.junit.Assert;

import base.Log;
import base.Utilities;

public class LogIn extends Utilities{
	
    private Utilities utl;
    public LogIn(Utilities utl) {
        this.utl = utl;
    }
    
    @Given("^App is open$")
    public void app_is_open() {
        Log.info("App is open");
    }

    @When("^User selects the value from \"([^\"]*)\" with \"([^\"]*)\"$")
    public void user_selects_the_value_from_with(String arg1, String arg2) throws Throwable {
    	utl.click(arg1);
    	utl.scrollToFind(arg2);
    }
   
    @And("^User enters the \"([^\"]*)\" with \"([^\"]*)\"$")
    public void user_enters_the_with(String arg1, String arg2) throws Throwable {
    	utl.enterText(arg1, arg2);
    }
    
    @And("^User selects a value$")
    public void user_selects_a_value(DataTable arg1) {
    	List<List<String>> data = arg1.asLists(String.class);
    	
    }
    @And("^User selects a \"([^\"]*)\"$")
    public void user_selects_a(String arg1) throws Throwable {
    	utl.click((arg1));
    }
    
    @And("^User clicks on \"([^\"]*)\"$")
    public void user_clicks_on(String arg1) {
        utl.click(arg1);
    }

    @Then("^User navigates to the \"([^\\\"]*)\" page$")
    public void user_navigates_to_the_something_page(String arg1) {
    	Assert.assertTrue(utl.check(arg1));
    	Log.info("User is on "+arg1+" page");
    }
}

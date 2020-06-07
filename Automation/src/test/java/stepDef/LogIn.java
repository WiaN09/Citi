package stepDef;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;
import org.junit.Assert;
import base.Utilities;

public class LogIn extends Utilities{
	
    private Utilities utl;
    public LogIn(Utilities utl) {
        this.utl = utl;
    }
    
    @Given("^App is open$")
    public void app_is_open() {
        System.out.println("App is open");
    }

    @When("^User selects the value from dropdown$")
    public void user_selects_the_value_from_dropdown(DataTable arg1) {
    	List<List<String>> data = arg1.asLists(String.class);
    	utl.click("dropdown");
    	utl.scrollToFind(data.get(0).get(1));
    }

    @And("^User enters the detail$")
    public void user_enters_the_detail(DataTable arg1) {
    	List<List<String>> data = arg1.asLists(String.class);
    	utl.enterText(data.get(0).get(0), data.get(0).get(1));
    }

    @And("^User selects a value$")
    public void user_selects_a_value(DataTable arg1) {
    	List<List<String>> data = arg1.asLists(String.class);
    	utl.click((data.get(0).get(1)));
    }

    @And("^User clicks on \"([^\"]*)\"$")
    public void user_clicks_on(String arg1) {
        utl.click(arg1);
    }

    @Then("^User navigates to the \"([^\\\"]*)\" page$")
    public void user_navigates_to_the_something_page(String arg1) {
    	Assert.assertTrue(utl.check(arg1));
    	//System.out.println("True for now");
    }
}

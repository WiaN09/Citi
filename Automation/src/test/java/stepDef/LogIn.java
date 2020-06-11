package stepDef;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import excel_utl.DataHelper;

import java.util.HashMap;
import java.util.List;
import org.junit.Assert;

import base.Log;
import base.Utilities;

public class LogIn extends Utilities{

    private Utilities utl;
    public List<HashMap<String,String>> datamap;
	public static int index;
    public LogIn(Utilities utl) {
        this.utl = utl;
        datamap = DataHelper.data(System.getProperty("user.dir")+"\\src\\test\\java\\excel_utl\\data.xlsx","Sheet1");
    }

    @Given("^App is open$")
    public void app_is_open() {
        Log.info("App is open");
    }
    @When("^User get data from excel at \"([^\"]*)\" row$")
    public void user_get_data_from_excel_at_row(String arg1) throws Throwable {
    	index = Integer.parseInt(arg1)-1;
        System.out.println("current data set at" + index);
    }
    @And("^User selects the value from \"([^\"]*)\" with \"([^\"]*)\"$")
    public void user_selects_the_value_from_with(String arg1, String arg2) {
    	utl.click(arg1);
    	String value = datamap.get(index).get(arg2);
    	utl.scrollToFind(value);
    }

    @And("^User enters the \"([^\"]*)\" with \"([^\"]*)\"$")
    public void user_enters_the_with(String arg1, String arg2) {
    	String value = datamap.get(index).get(arg2);
    	utl.enterText(arg1, value);
    }

    @And("^User selects a \"([^\"]*)\"$")
    public void user_selects_a(String arg1) {
    	String value = datamap.get(index).get(arg1);
    	utl.click((value));
    }

    @And("^User clicks on \"([^\"]*)\"$")
    public void user_clicks_on(String arg1) {
        utl.click(arg1);
    }

    @And("^User selects a value$")
    public void user_selects_a_value(DataTable arg1) {
    	List<List<String>> data = arg1.asLists(String.class);
    	utl.click(data.get(0).get(1));
    }

    @When("^User selects the value from dropdown$")
    public void user_selects_the_value_from_dropdown(DataTable arg1) throws Throwable {
    	List<List<String>> data = arg1.asLists(String.class);
    	utl.click("dropdown");
    	utl.scrollToFind(data.get(0).get(1));
    }

    @And("^User enters the detail$")
    public void user_enters_the_detail(DataTable arg1) {
    	List<List<String>> data = arg1.asLists(String.class);
    	utl.enterText(data.get(0).get(0), data.get(0).get(1));

    }
    @Then("^User clicks on the \"([^\"]*)\"$")
    public void user_clicks_on_the(String arg1) throws Throwable {
    	String value = datamap.get(index).get(arg1);
    	utl.click(arg1);
    }

}

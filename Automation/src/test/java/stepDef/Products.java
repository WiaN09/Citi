package stepDef;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;

import base.Log;
import base.Utilities;

public class Products extends Utilities{
	
    private Utilities utl;
    public Products(Utilities utl) {
        this.utl = utl;
    }
    
    @Given("^User is on products page$")
    public void user_is_on_products_page()  {
        Log.info("Products page is open");
    }
    
    @Then("^User adds products to the cart$")
    public void user_adds_products_to_the_cart(DataTable arg1)  {
    	List<List<String>> data = arg1.asLists(String.class);
    	utl.products(data);
    }


}

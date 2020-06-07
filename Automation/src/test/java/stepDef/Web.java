package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import java.util.List;
import base.Utilities;

	
@RunWith(Cucumber.class)
public class Web {
	
	public WebDriverWait wait;
	
    private Utilities utl;
    public Web(Utilities utl) {
        this.utl = utl;
    }
    
    @Given("^User is on the Cart Page$")
    public void user_is_on_the_cart_page()  {
        System.out.println("On the cart page");
    }

    @Then("^User is taken to Google Homepage$")
    public void user_is_taken_to_google_homepage() throws InterruptedException  {
        utl.switchToWebContext();
    }

}
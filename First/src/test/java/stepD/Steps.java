package stepD;

import java.io.IOException;
import java.net.MalformedURLException;

import org.json.simple.parser.ParseException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.LoginPage;
import pageObjects.ProfilePage;
import facades.Startup;
import data.ProfileJava;
import data.UserJava;
import facades.Log;

public class Steps {
		
	    AndroidDriver<AndroidElement> driver; 
	    
	    //Currently two users
	    int UserNumber = 2;
	    
	    
	@Given("^I'm at the homescreen$")
	public void when_I_m_at_the_homescreen() throws InterruptedException, MalformedURLException  {
		Startup startup = new Startup();
		driver = startup.capabilities(); 
		Log.info("I'm at the home screen");
	}

	@When("^I have opened the app$")
	public void i_have_opened_the_app()  {
		LoginPage loginPage = new LoginPage(driver);
        if (!loginPage.isDisplayed()) {
            return;   
        }
        Log.info("App opened");	
    }

	@When("^I fill out the login details$")
	public void i_fill_out_the_login_details() throws IOException, ParseException  {
		UserJava u = new UserJava();
		String[] data = u.loginfo(UserNumber-1);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(data[0], data[1]); 
		Log.info("Login details entered");
	}

	@When("^I press the Login button$")
	public void i_press_the_Login_button()  {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickLogin(); 
		Log.info("Login button clicked");
	}
	
	@Then("^I fill out the profile details$")
	public void i_fill_out_the_profile_details() throws IOException, ParseException  {
		ProfileJava p = new ProfileJava();
		String[] data = p.profileinfo(UserNumber-1);
		ProfilePage profilePage = new ProfilePage(driver);
        profilePage.profile(data[0], data[1], data[2], data[3]);
        Log.info("Profile details filled");
	}
	@Then("^I press Save$")
	public void i_press_save()  {
		ProfilePage profilePage = new ProfilePage(driver);
		profilePage.save(); 
		Log.info("Profile details saved");
	}
	@Then("^My details are stored$")
	public void my_details_are_stored()  {
		ProfilePage profilePage = new ProfilePage(driver);
        if(!profilePage.isSaved()) {
        	return;
        }
        profilePage.logout();
        Log.info("Logged out");
	}

}


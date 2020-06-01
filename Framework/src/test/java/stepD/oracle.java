package stepD;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class oracle {
	
	    AndroidDriver<MobileElement> driver;
	    
	public void startup() throws MalformedURLException {	
	    AppiumDriverLocalService appiumService;
	    String appiumUrl;
	    appiumService = AppiumDriverLocalService.buildDefaultService();
	    appiumService.start();
	    appiumUrl = appiumService.getUrl().toString();
	        
	    File appDir = new File("src");
	    File app = new File(appDir, "hybrid.apk");
	     
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability("deviceName","Demo");
	    capabilities.setCapability("avd","Demo"); 
	    capabilities.setCapability("platformName","Android");
	    capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	    capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
		capabilities.setCapability("autoAcceptAlerts", true);
		driver = new AndroidDriver<MobileElement>(new URL(appiumUrl), capabilities); 
		  
	}	    	
	    	
	@Given("^I'm at the homescreen$")
	public void i_m_at_the_homescreen(){
		System.out.println("I'm at the homescreen");
	}

	@When("^I open the app$")
	public void i_open_the_app() throws MalformedURLException{
		startup();
		System.out.println("The app is opened");
	}
	
	public void webview () {
   	 	Set<String> s = driver.getContextHandles();
   	 		for(String handle : s)
   	 		{
   	 			System.out.println(handle);
   	 		}
   	 	System.out.println("Changing driver context to webview");
   	 	driver.context((String) s.toArray()[1]);
   	}

	@When("^I press the menu button$")
	public void i_press_the_menu_button(){
		webview();
		System.out.println("Entering random words in the search bar and searching");
		driver.findElementById("askoracleinput").sendKeys("k\n");
		System.out.println("Pressing the menu button");
		driver.findElementById("u02menulink").click();
	}

	@When("^I locate the Java SE SDK link$")
	public void i_locate_the_Java_SE_SDK_link() {
		System.out.println("Scrolling to find Java SE SDK");
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,800)");
	}

	@Then("^I navigate to the Java SE SDK page$")
	public void i_navigate_to_the_Java_SE_SDK_page() {
		System.out.println("Clicking the link");
    	driver.findElement(By.xpath("//*[@id=\"u02mainmenu\"]/div/ul/li[2]/div/ul/li[5]/div/ul/li[10]/a")).click();
	}
}

package stepDef;

import base.Utilities;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Hook extends Utilities{

    private Utilities utl;

    public Hook(Utilities utl) {
        this.utl = utl;
    }
	AppiumDriverLocalService appiumService;
	
		@Before
		public void startup() throws MalformedURLException
		{
		    
			String appiumUrl;
	    	appiumService = AppiumDriverLocalService.buildDefaultService();
	    	appiumService.start();
	    	appiumUrl = appiumService.getUrl().toString();
	    	System.out.println("Appium server is open");
	    	System.out.println("Opening the app");
	    	DesiredCapabilities capabilities = new DesiredCapabilities();
		    capabilities.setCapability("deviceName","Demo");
		    capabilities.setCapability("avd","Demo"); 
		    capabilities.setCapability("platformName","Android");
		    
		    capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
			capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
			capabilities.setCapability("autoAcceptAlerts", true);
			
	        capabilities.setCapability("appPackage", "com.androidsample.generalstore");
	        capabilities.setCapability("appActivity", "com.androidsample.generalstore.SplashActivity");

			
	        // Initialize driver
			utl.driver = new AndroidDriver<AndroidElement>(new URL(appiumUrl), capabilities);
			utl.wait = new WebDriverWait(utl.driver, 15);
			System.out.println("App Opened");
		}
	
		@After
    	public void End() throws InterruptedException {
    			   Thread.sleep(5000L);
                   System.out.println("Stop driver");
                   utl.driver.quit();
                   System.out.println("Stop appium service");
                   appiumService.stop();
    }
}

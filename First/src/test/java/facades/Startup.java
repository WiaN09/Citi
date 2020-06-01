package facades;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Startup {

    private final static String APP_PACKAGE_NAME = "io.testproject.demo";
    private final static String APP_ACTIVITY_NAME = ".MainActivity";
    
	public AndroidDriver<AndroidElement> capabilities() throws MalformedURLException
	{
		AndroidDriver<AndroidElement> driver;
		AppiumDriverLocalService appiumService;
	    String appiumUrl;
	   
	    appiumService = AppiumDriverLocalService.buildDefaultService();
	    appiumService.start();
	    appiumUrl = appiumService.getUrl().toString();
	     
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability("deviceName","Demo");
	    capabilities.setCapability("avd","Demo"); 
	    capabilities.setCapability("platformName","Android");
	    
	    capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
		capabilities.setCapability("autoAcceptAlerts", true);
		
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, APP_PACKAGE_NAME);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY_NAME); 
		
        // Initialize driver
		driver = new AndroidDriver<AndroidElement>(new URL(appiumUrl), capabilities);
	    
		return driver;
	}

}

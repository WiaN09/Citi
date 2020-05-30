package skeleton;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class SetupCalc {
	
	AndroidDriver<MobileElement> driver;
    AppiumDriverLocalService appiumService;
    String appiumUrl;
   
    @BeforeSuite
	public void Startup() throws MalformedURLException
	{ 
        appiumService = AppiumDriverLocalService.buildDefaultService();
        appiumService.start();
        appiumUrl = appiumService.getUrl().toString();
        //System.out.println("Appium Service URL Address : - "+ appiumUrl);
    
	 /*File appDir = new File("src");
     File app = new File(appDir, "paytm.apk");
     File app = new File(appDir, "hybrid.apk")*/
     
     
     DesiredCapabilities capabilities = new DesiredCapabilities();
     capabilities.setCapability("deviceName","Trial");
     capabilities.setCapability("avd","Trial"); 
     capabilities.setCapability("platformName","Android");
     //capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Demo");
     //capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
     capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
	 capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
	 capabilities.setCapability("autoAcceptAlerts", true);
	 capabilities.setCapability("appPackage", "com.android.calculator2");
     capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
	 driver = new AndroidDriver<MobileElement>(new URL(appiumUrl), capabilities);
     
	 
	}
    
    @AfterSuite
    public void End() throws InterruptedException {
    			   Thread.sleep(3000L);
                   System.out.println("Stop driver");
                   driver.quit();
                   System.out.println("Stop appium service");
                   appiumService.stop();
    }


}

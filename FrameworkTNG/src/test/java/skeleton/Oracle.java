package skeleton;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.Test;

public class Oracle {
	
    AppiumDriverLocalService appiumService;
    String appiumUrl;
    AndroidDriver<MobileElement> driver;
    
    @BeforeSuite
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
    @Test
	public void Test () {
   	 	Set<String> s = driver.getContextHandles();
   	 	for(String handle : s)
   	 	{
   	 		System.out.println(handle);
   	 	}
   	 	driver.context((String) s.toArray()[1]);
    	driver.findElementById("askoracleinput").sendKeys("k\n");
    	driver.findElementById("u02menulink").click();
    	((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");
    	driver.findElement(By.xpath("//*[@id=\"u02mainmenu\"]/div/ul/li[2]/div/ul/li[5]/div/ul/li[10]/a")).click();
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


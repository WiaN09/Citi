package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Reader;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;

public class Utilities {
	
	public AndroidDriver<AndroidElement> driver;
    public final static String repo = "repo.properties";
    public Reader reader = new Reader();
    public WebDriverWait wait;
    
    public boolean scrollToFind(String country) {
    	try {
    		//scrolls and finds
    		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" +country +"\"))").click();
    	}
    	catch (Exception e){
    		e.printStackTrace();
    		return false;
    	}
    	return true;
    }
    
    public boolean enterText(String text) {
    	try {
    		//Find path of element to be clicked
    		String path = reader.path("name");
    		//wait and then enter
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(path))).sendKeys(text);    
    		//remove the keyboard
    		driver.pressKey(new KeyEvent(AndroidKey.ESCAPE));
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		return false;
    	}
    	return true;
    }
    
    public boolean click(String object) {
    	try {
    		//Find path of element to be clicked
    		String path = reader.path(object);
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(path))).click();    
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		return false;
    	}
    	return true;
    }
    
    public boolean scroll() {
    	try {
    		//general scrolling
    		Dimension size = this.driver.manage().window().getSize();
    		int startX = size.width / 2;
    		int startY = (int) (size.height * 0.60);
    		int endY = (int) (size.height * 0.30);
    		TouchAction action = new TouchAction(this.driver);
    		action.moveTo(PointOption.point(startX, endY));
    		new TouchAction(driver)
    		.press(PointOption.point(startX, startY))
    		.moveTo(PointOption.point(startX, endY))
    		.release().perform();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		return false;
    	}
    	return true;
    }
    
    public boolean check(String object) {
    	try {
    		//Check whether element is present or not
    		String path = reader.path(object);
    		driver.findElementByXPath(path);  
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		return false;
    	}
    	return true;
    }
    
    }

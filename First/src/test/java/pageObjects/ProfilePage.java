package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;


public class ProfilePage {
    private AndroidDriver<AndroidElement> driver;
    public ProfilePage() {
    }
    
    public ProfilePage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    
    @AndroidFindBy(className = "UIAKeyboard")
    private AndroidElement keyboard;
    @AndroidFindBy(id = "logout")
    private AndroidElement logoutElement;
    @AndroidFindBy(id = "country")
    private AndroidElement countryElement;
    @AndroidFindBy(id = "address")
    private AndroidElement addressElement;
    @AndroidFindBy(id = "email")
    private AndroidElement emailElement;
    @AndroidFindBy(id = "phone")
    private AndroidElement phoneElement;
    @AndroidFindBy(id = "save")
    private AndroidElement saveElement;
    @AndroidFindBy(id = "saved")
    private AndroidElement savedElement;
    
    //public boolean isDisplayed() {
        //return greetingsElement.isDisplayed();
    //}
    public void typeCountry(String country) {
        countryElement.sendKeys(country);
    }
    public void typeAddress(String address) {
        addressElement.sendKeys(address);
    }
    public void typeEmail(String email) {
        emailElement.sendKeys(email);
    }
    public void typePhone(String phone) {
        phoneElement.sendKeys(phone);
    }
    public void hideKeyboardIfVisible() {
        if (keyboard != null) {
        	driver.pressKey(new KeyEvent(AndroidKey.ESCAPE));
        }
    }
    public void profile (String country, String address, String email, String phone) {
        hideKeyboardIfVisible();
        typeCountry(country);
        typeAddress(address);
        typeEmail(email);
        typePhone(phone);
    }
    
    public void save() {
        saveElement.click();
    }
    
    public void logout() {
        logoutElement.click();
    }
    
    public boolean isSaved() {
        return savedElement.isDisplayed();
    }
}
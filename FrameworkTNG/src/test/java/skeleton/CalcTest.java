
package skeleton;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;

public class CalcTest extends SetupCalc{
        @Test
        public void Sum() {
       	               System.out.println("Calculate sum of two numbers");
                       MobileElement oneBtn=driver.findElement(By.id("com.android.calculator2:id/digit_1"));
                       oneBtn.click();
                       MobileElement plusBtn=driver.findElement(By.id("com.android.calculator2:id/op_add"));
                       plusBtn.click();
                       MobileElement fiveBtn=driver.findElement(By.id("com.android.calculator2:id/digit_5"));
                       fiveBtn.click();
                       MobileElement equalToBtn=driver.findElement(By.id("com.android.calculator2:id/eq"));
                       equalToBtn.click();
        
        }
}

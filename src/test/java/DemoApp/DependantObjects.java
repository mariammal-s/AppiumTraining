package DemoApp;

import base.TestBase;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class DependantObjects extends TestBase {


    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        driver = Initialize("Emulator");
        driver.findElement(By.xpath("//android.widget.TextView[@text ='Preference']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text ='3. Preference dependencies']")).click();
        if(! driver.findElement(By.xpath("//android.widget.TextView[@text = 'WiFi settings']")).isEnabled())
            System.out.println("Wifi Settings Disabled");
        driver.findElement(By.id("android:id/checkbox")).click();
        System.out.println("Clicked on Wifi Checkbox");
       if(driver.findElement(By.xpath("//android.widget.TextView[@text = 'WiFi settings']")).isEnabled())
           System.out.println("Wifi Settings Enabled");
        driver.findElement(By.xpath("//android.widget.TextView[@text = 'WiFi settings']")).click();
        driver.findElement(By.id("android:id/edit")).sendKeys("abcdef");
        driver.findElementById("android:id/button1").click();

    }

}

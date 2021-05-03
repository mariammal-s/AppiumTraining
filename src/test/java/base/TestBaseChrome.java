package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBaseChrome {

    public static AndroidDriver<AndroidElement> driver;

    public static AndroidDriver<AndroidElement> Initialize(String device) throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        if (device.equals("Real")) {
            cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Device");

        }else {
            cap.setCapability(MobileCapabilityType.DEVICE_NAME,"PieEmulator");

        }
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Device");
        cap.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
        cap.setCapability(MobileCapabilityType.VERSION,"10");
        cap.setCapability("noReset",true);
        cap.setCapability("platformName", "Android");


        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver;
    }
}

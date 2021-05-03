package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static AndroidDriver<WebElement> driver;

    public static AndroidDriver<WebElement> Initialize(String device) throws MalformedURLException {

        File appDir = new File("app");
        File appDemo = new File(appDir , "ApiDemos-debug.apk");
        File appEcommerce = new File(appDir,"General-Store.apk");

        DesiredCapabilities cap = new DesiredCapabilities();
        if (device.equals("Real")) {
            cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Device");

        }else {
            cap.setCapability(MobileCapabilityType.DEVICE_NAME,"PieEmulator");

        }
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Device");
        //cap.setCapability(MobileCapabilityType.APP,appDemo.getAbsolutePath());
        cap.setCapability(MobileCapabilityType.APP , appEcommerce.getAbsolutePath());
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "20");
        cap.setCapability("platformName", "Android");
        cap.setCapability("noReset","true");

        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver;
    }
}

package DemoApp;

import base.TestBase;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class ScrollDemo extends TestBase {
    public static void main(String[] args) throws MalformedURLException {
        driver = Initialize("Real");
        driver.findElement(By.xpath("//android.widget.TextView[@text ='Views']")).click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Radio Group\"));");

    }

}

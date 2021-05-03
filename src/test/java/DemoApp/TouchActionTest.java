package DemoApp;

import base.TestBase;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.time.Duration;


public class TouchActionTest extends TestBase {

    public static void main(String[] args) throws MalformedURLException {
        driver = Initialize("Real");
        driver.findElement(By.xpath("//android.widget.TextView[@text ='Views']")).click();
        TouchAction touch = new TouchAction(driver);
        WebElement expandList = driver.findElementByXPath("//android.widget.TextView[@text ='Expandable Lists']");
        touch.tap(TapOptions.tapOptions().withElement(ElementOption.element(expandList))).perform();
        WebElement customAdaptor = driver.findElementByXPath("//android.widget.TextView[@text ='1. Custom Adapter']");
        touch.tap(TapOptions.tapOptions().withElement(ElementOption.element(customAdaptor))).perform();
        WebElement peopleNames = driver.findElementByXPath("//android.widget.TextView[@text ='People Names']");
        touch.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(peopleNames)).withDuration(Duration.ofSeconds(2))).release().perform();
        System.out.println(driver.findElementById("android:id/title").isDisplayed());
    }

}

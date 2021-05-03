package DemoApp;

import base.TestBase;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.time.Duration;

public class SwipeDemo extends TestBase {

    public static void main(String[] args) throws MalformedURLException {
        driver = Initialize("Real");
        driver.findElement(By.xpath("//android.widget.TextView[@text ='Views']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text ='Date Widgets']")).click();
        driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
        driver.findElementByXPath("//*[@content-desc='9']").click();
        WebElement minuteFrom = driver.findElementByXPath("//*[@content-desc='15']");
        WebElement minuteTo = driver.findElementByXPath("//*[@content-desc='45']");
        TouchAction t  = new TouchAction(driver);
        t.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(minuteFrom)).withDuration(Duration.ofSeconds(2))).moveTo(ElementOption.element(minuteTo)).release().perform();

    }

}

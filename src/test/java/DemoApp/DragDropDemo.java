package DemoApp;

import base.TestBase;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class DragDropDemo extends TestBase {

    public static void main(String[] args) throws MalformedURLException {
        driver = Initialize("Emulator");
        driver.findElement(By.xpath("//android.widget.TextView[@text ='Views']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text ='Drag and Drop']")).click();
        TouchAction t = new TouchAction(driver);
        WebElement dotSource = driver.findElementById("io.appium.android.apis:id/drag_dot_1");
        WebElement dotDestination = driver.findElementById("io.appium.android.apis:id/drag_dot_3");
        t.longPress(ElementOption.element(dotSource)).moveTo(ElementOption.element(dotDestination)).release().perform();

    }

}

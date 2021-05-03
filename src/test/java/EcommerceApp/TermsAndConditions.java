package EcommerceApp;

import base.TestBase;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

public class TermsAndConditions extends TestBase {

    public static void main (String[] args) throws MalformedURLException, InterruptedException {
        driver = Initialize("Emulator");
        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Hello");
        driver.hideKeyboard();
        driver.findElementByClassName("android.widget.Button").click();
        Thread.sleep(1000);
        List<WebElement> productList = driver.findElementsById("com.androidsample.generalstore:id/productAddCart");
        for (WebElement e : productList) {
            e.click();
        }
        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
        Thread.sleep(1000);

        driver.findElementByClassName("android.widget.CheckBox").click();

        TouchAction touch = new TouchAction(driver);
        WebElement termsC = driver.findElementByXPath("//*[@text = 'Please read our terms of conditions']");
        touch.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(termsC)).withDuration(Duration.ofSeconds(2))).release().perform();
        driver.findElementById("android:id/button1").click();
        driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();


    }


}

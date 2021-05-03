package EcommerceApp;

import base.TestBase;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;

public class WebView extends TestBase {

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
        driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();

        Thread.sleep(5000);
        Set<String> context = driver.getContextHandles();
        for (String c : context){
            System.out.println(c);
        }
        driver.context("WEBVIEW_com.androidsample.generalstore");

        driver.findElementByName("q").sendKeys("hello");

        driver.findElementByName("q").sendKeys(Keys.ENTER);

        driver.pressKeyCode(AndroidKeyCode.BACK);
        Thread.sleep(2000);

        driver.context("NATIVE_APP");

    }



}

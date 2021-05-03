package EcommerceApp;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.util.List;

public class SelectProduct extends TestBase {

    public static void main (String[] args) throws MalformedURLException, InterruptedException {
        driver = Initialize("Emulator");
        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Hello");
        driver.hideKeyboard();
        driver.findElementByClassName("android.widget.Button").click();
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))");

        int count = driver.findElementsById("com.androidsample.generalstore:id/productName").size();

        for (int i = 0 ; i < count ; i++) {
            String name = driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();

            if (name.equals("Jordan 6 Rings")) {
                driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
                break;
            }
        }
        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
        String productInCart = driver.findElementById("com.androidsample.generalstore:id/productName").getText();
        Assert.assertEquals(productInCart,"Jordan 6 Rings");

    }

}

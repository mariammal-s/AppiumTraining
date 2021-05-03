package EcommerceApp;

import base.TestBase;

import java.net.MalformedURLException;

public class SignUpSuccessful extends TestBase {

    public static void main (String[] args) throws MalformedURLException {

        driver = Initialize("Emulator");
        driver.findElementById("android:id/text1").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
        driver.findElementByXPath("//android.widget.TextView[@text='Argentina']").click();
        System.out.println("Selected Argentina");
        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Hello");
        driver.hideKeyboard();
        driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
        driver.findElementByClassName("android.widget.Button").click();
        System.out.println("Successfully Registered");


    }

}

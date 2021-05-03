package EcommerceApp;

import base.TestBase;

import java.net.MalformedURLException;

public class SignUpToastMessage extends TestBase {

    public static void main (String[] args) throws MalformedURLException {

        driver = Initialize("Emulator");
        driver.findElementByClassName("android.widget.Button").click();
        String ToastMessage = driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
        System.out.println(ToastMessage);

    }
}

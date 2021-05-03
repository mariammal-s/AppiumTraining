package EcommerceApp;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.util.List;

public class CheckOutAmountCheck extends TestBase {


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
        List<WebElement> productPrice = driver.findElementsById("com.androidsample.generalstore:id/productPrice");
        double totalAmount = 0.0 ;
        for (WebElement e : productPrice) {
            String price = e.getText();
            Double amount = getAmount(price);
            totalAmount += amount;
        }
        String amount = driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
        double actualAmount = getAmount(amount);

        Assert.assertEquals(totalAmount,actualAmount);
        System.out.println("Amount matches");


    }

    //Removes Dollar symbol and returns double value
    public static double getAmount(String amount) {
        String newamount = amount.replaceAll("\\$","");
        double actualAmount = Double.parseDouble(newamount);
        return actualAmount;
    }

}

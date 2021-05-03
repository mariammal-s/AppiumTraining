package WebApp;

import base.TestBaseChrome;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import java.net.MalformedURLException;

public class Browse extends TestBaseChrome {

    public static void main(String[] args) throws MalformedURLException {
        driver = Initialize("Real");
        //driver.get("http://google.com");
        driver.get("http://cricbuzz.com");
        driver.findElementByXPath("//a[@href='#menu']").click();
        driver.findElementByCssSelector("a[title='Cricbuzz Home']").click();
        System.out.println(driver.getCurrentUrl());
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,480)", "");
        Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Top Stories']")).getAttribute("class").contains("header"));

    }


}

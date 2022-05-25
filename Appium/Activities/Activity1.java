package Activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {
    private AndroidDriver<MobileElement> driver;

    @BeforeClass

    public void SetUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName","android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("noReset","true");
        caps.setCapability("appPackage","com.android.calculator2");
        caps.setCapability("appActivity",".Calculator");

        //Instantiate Appium

        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer,caps);
    }

    @Test

    public void Activity(){

        // Find teh objects from emulator
        driver.findElement(By.id("com.android.calculator2:id/digit_5")).click();

        driver.findElementById("op_add").click();

        driver.findElementByXPath("//android.widget.Button[@text='9']").click();

        //Example of usage of Accessibility Id
        //driver.findElementByAccessibilityId("multiply").click();

        // Perform Calculation
        driver.findElementById("eq").click();

        // Display Result
        String result = driver.findElement(MobileBy.id("result")).getText();
        System.out.println(result);

        // Assertion
        Assert.assertEquals(result, "14");
    }

    @AfterClass
    public void tearDown() {
        // Close app
        driver.quit();
    }
}
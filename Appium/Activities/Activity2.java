package Activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity2 {

    private AndroidDriver<MobileElement> driver;

    private WebDriverWait wait;

    @BeforeClass
    public void SetUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "<device name>");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 40);
    }

    @Test
    public void Activity2()
    {
        // Open the browser with the URL
        driver.get("https://www.training-support.net/");

        // Wait for page to load
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.view.View[@id='about-link']")));

        //wait.until(ExpectedConditions.elementToBeClickable((MobileBy.id("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[4]"))));

        // Get heading on page and print it
        String pageHeading = driver.findElementByXPath("//android.view.View[@text='Training Support']").getText();

        System.out.println("Title on Homepage: " + pageHeading);

    // Find About Us button and click it
    MobileElement aboutButton = driver.findElementByXPath("//android.view.View[@content-desc='About Us']");
        aboutButton.click();

    // Wait for new page to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                MobileBy.xpath("//android.widget.TextView[@text='About Us']")
                ));

    // Get heading on About Us page and print it
    String newPageTitle = driver
            .findElementByXPath("//android.widget.TextView[@text='About Us']")
            .getText();
        System.out.println("Title on new page: "+newPageTitle);

    // Assertions
        Assert.assertEquals(pageHeading,"Training Support");
        Assert.assertEquals(newPageTitle,"About Us");
}

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

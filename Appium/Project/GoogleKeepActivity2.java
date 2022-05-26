package ProjectActivity;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GoogleKeepActivity2{
    private AndroidDriver<MobileElement> driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
        wait = new WebDriverWait(driver, 40);
    }

    @Test
    public void GoogleKeepsBonus() throws InterruptedException {

        Thread.sleep(4000);

        driver.findElementById("com.google.android.keep:id/new_note_button").click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.keep:id/browse_note_interior_content")));

        driver.findElementById("com.google.android.keep:id/editable_title").sendKeys("Test Title2");
        driver.findElementById("com.google.android.keep:id/edit_note_text").sendKeys("Test Content");

        // Add reminder to Note
        driver.findElementById("com.google.android.keep:id/menu_switch_to_list_view").click();

        driver.findElementByXPath("//android.widget.TextView[@text='Later today']").click();

        // Back button to verify added note

        driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]").click();
        Thread.sleep(2000);

        MobileElement NoteTitle = driver.findElement(MobileBy.id("com.google.android.keep:id/index_note_title"));
        String Title = NoteTitle.getText();

        Assert.assertEquals(Title, "Test Title2");
        Assert.assertTrue(driver.findElementById("com.google.android.keep:id/reminder_chip_text").isDisplayed());
        //Thread.sleep(300);

    }
    @AfterClass
    public void tearDown() {
        // Close app
        driver.quit();
    }

}
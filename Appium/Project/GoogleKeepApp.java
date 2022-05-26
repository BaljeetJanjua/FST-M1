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
import java.util.List;

public class GoogleKeepApp {
    private AndroidDriver<MobileElement> driver;
    private WebDriverWait wait;

    @BeforeClass

    public void SetUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("noReset", "true");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");

        //Instantiate Appium

        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);

        wait = new WebDriverWait(driver, 40);
    }

    @Test


    public void AddNewNote(){

        driver.findElement(MobileBy.id("com.google.android.keep:id/new_note_button")).click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.keep:id/browse_note_interior_content")));

        // Add Note Title and Desc
        driver.findElement(MobileBy.id("com.google.android.keep:id/editable_title")).sendKeys("Add Note");
        driver.findElement(MobileBy.id("com.google.android.keep:id/edit_note_text")).sendKeys("Added First Note to test");

        //Press the back button to verify added note

        driver.findElementByAccessibilityId("Open navigation drawer").click();

        // Verify added note

        MobileElement NoteTitle = driver.findElement(MobileBy.id("com.google.android.keep:id/index_note_title"));
        String Title = NoteTitle.getText();

        Assert.assertEquals(Title,"Add Note");

    }
    @AfterClass

    public void tearDown() {
        // Close app
        driver.quit();
    }
}

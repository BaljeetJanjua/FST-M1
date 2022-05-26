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

public class GoogleTasksApp {
        private AndroidDriver<MobileElement> driver;
        private WebDriverWait wait;

        @BeforeClass

        public void SetUp() throws MalformedURLException {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName","android");
            caps.setCapability("automationName","UiAutomator2");
            caps.setCapability("noReset","true");
            caps.setCapability("appPackage","com.google.android.apps.tasks");
            caps.setCapability("appActivity",".ui.TaskListsActivity");

            //Instantiate Appium

            URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver<MobileElement>(appServer,caps);

            wait = new WebDriverWait(driver, 40);
        }

        @Test

        public void AddGoogleTask(){

            // Find elements on Google tasks app

            driver.findElement(MobileBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("com.google.android.apps.tasks:id/add_task_change_details")));
            driver.findElement(MobileBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("FirstTask");
            driver.findElement(MobileBy.id("com.google.android.apps.tasks:id/add_task_done")).click();

            //Wait after first task
            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.apps.tasks:id/tasks_fab")));

            // Add second task
            driver.findElement(MobileBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("com.google.android.apps.tasks:id/add_task_change_details")));
            driver.findElement(MobileBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("SecondTask");
            driver.findElement(MobileBy.id("com.google.android.apps.tasks:id/add_task_done")).click();

            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.apps.tasks:id/tasks_fab")));

            // Add third task
            driver.findElement(MobileBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("com.google.android.apps.tasks:id/add_task_change_details")));
            driver.findElement(MobileBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("ThirdTask");
            driver.findElement(MobileBy.id("com.google.android.apps.tasks:id/add_task_done")).click();

        }

        @Test
        public void VerifyTaskList(){

            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.apps.tasks:id/tasks_fab")));
            // Get the added tasks list
            List<MobileElement> numberOfTasks = driver.findElementsByAndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/task_name\")");

            System.out.println("Size of added tasks are" + numberOfTasks.size());

            Assert.assertEquals(numberOfTasks.size(),3);

        }
        @AfterClass

        public void tearDown() {
            // Close app
            driver.quit();
        }
}

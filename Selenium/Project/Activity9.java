package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class Activity9{

    WebDriver driver;
    Actions builder;
    WebDriverWait wait;
    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        //create a new instance of Actions class
        builder = new Actions(driver);
        // Create wait instance
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //Open browser
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
    }

    @Test
    public void LoginAndPublishJob() {

        //Check the title of the page
        String title = driver.getTitle();
        //Print the title of the page
        System.out.println("Page title is: " + title);

        //find username and password and enter values
        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");

        // Click on Login button

        //driver.findElement(By.xpath("//button[contains(text(),'Log In')]")).click();
        driver.findElement(By.id("wp-submit")).click();

        //Print logged in UserName
        String loginUserId = driver.findElement(By.cssSelector("#wp-admin-bar-my-account > a:nth-child(1)")).getText();
        System.out.println("Logged In User: " + loginUserId);

        // Click on Job Listings

        WebElement MenuList = driver.findElement(By.xpath("//*[@id='menu-posts-job_listing']"));
        MenuList.click();

        WebElement AddNew = driver.findElement(By.cssSelector(".page-title-action"));
        AddNew.click();

        // click on the dialog box

        WebElement Dialogbox = driver.findElement(By.xpath("//button[@aria-label='Close dialog']"));
        Dialogbox.click();

        String AddTitle = driver.getTitle();
        System.out.println("Navigated to Add New Page; Title of Page is : " + AddTitle);

        // Enter mandatory data in the box
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"post-title-0\"]")));
        //WebElement elementPosition = driver.findElement(By.xpath("//*[@id='post-title-0']"));
        //builder.click(elementPosition).sendKeys("Tester Job Position - Full Stack Tester").build().perform();

        //It works with below as well
        WebElement elementDesc = driver.findElement(By.id("post-title-0"));
        elementDesc.sendKeys("Tester Job Position - Full Stack Tester");

        //click on Publish button
        //WebElement PublishButton = driver.findElement(By.cssSelector("button.components-button:nth-child(3)"));
        WebElement PublishButton = driver.findElement(By.xpath("//*[@class='components-button editor-post-publish-panel__toggle editor-post-publish-button__button is-primary']"));
        PublishButton.click();

        System.out.println("Job is Published and its available in Job lIst : ");

        // #post-5300 > td:nth-child(2) > div:nth-child(1) > a:nth-child(1)
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}

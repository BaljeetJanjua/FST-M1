package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity7_Solution {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        // Create Firefox instance
        driver = new FirefoxDriver();

        // Create wait instance
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Open the page
        driver.get("https://alchemy.hguy.co/jobs/post-a-job/");
    }

    @Test
    public void postAJobFromFrontEnd() {
        // Find sign in button and click it
        driver.findElement(By.linkText("Sign in")).click();

        // Wait for login page to load
        wait.until(ExpectedConditions.elementToBeClickable(By.id("user_login")));

        // Enter username
        driver.findElement(By.id("user_login")).sendKeys("root");
        // Enter password
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        // Click Log in
        driver.findElement(By.id("wp-submit")).click();

        // Wait for form to load
        wait.until(ExpectedConditions.elementToBeClickable(By.id("job_title")));

        // Fill out the form
        // Job title
        driver.findElement(By.id("job_title")).sendKeys("Full stack tester");
        // Job Description
        driver.switchTo().frame(0);
        driver.findElement(By.tagName("body")).sendKeys("This is job involves testing all types of applications.");
        driver.switchTo().defaultContent();

        // Submit job
        driver.findElement(By.xpath("//input[@value='Preview']")).click();
        // Wait for preview page to load
        wait.until(ExpectedConditions.elementToBeClickable(By.id("job_preview_submit_button")));

        // Assert job title
        String jobTitle = driver.findElement(By.xpath("//div[@class='job_listing_preview single_job_listing']/h1")).getText();
        Assert.assertEquals(jobTitle, "Full stack tester");

        // Submit job listing
        driver.findElement(By.id("job_preview_submit_button")).click();

        // Go to job posting
        driver.findElement(By.linkText("click here")).click();

        // Wait for page to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@itemprop='headline']")));

        // Assertion
        String postedJobTitle = driver.findElement(By.xpath("//h1[@itemprop='headline']")).getText();
        Assert.assertEquals(postedJobTitle, "Full stack tester");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

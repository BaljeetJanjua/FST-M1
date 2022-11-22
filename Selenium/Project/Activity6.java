package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.id;

public class Activity6 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://alchemy.hguy.co/jobs/");
    }

    @Test
    public void TestCase6() throws InterruptedException {
        // Check the title of the page
        String title = driver.getTitle();

        //Print the title of the first page
        System.out.println("First Page title is: " + title);

        //Click on Jobs

        WebElement JobsLink = driver.findElement(By.cssSelector("#menu-item-24 > a:nth-child(1)"));

        JobsLink.click();

        String title2 = driver.getTitle();

        //Print the title of the Second page
        System.out.println("Second Page title is: " + title2);

        //Assertion for second page title
        Assert.assertEquals("Jobs – Alchemy Jobs", title2);

        //Search the jobs

        WebElement SearchJob = driver.findElement(By.id("search_keywords"));
        SearchJob.sendKeys("Banking");

        driver.findElement(By.xpath("//div[@class='search_submit']")).click();

        //wait for list to view
        Thread.sleep(1000);

        // click on first job to apply
        driver.findElement(By.cssSelector(".post-4475 > a:nth-child(1) > div:nth-child(2) > h3:nth-child(1)")).click();
        driver.findElement(By.xpath("//*[@class='application_button button']")).click();

        Thread.sleep(1000);

        //Get the text of email
        String emailText = driver.findElement(By.xpath("//a[@class='job_application_email']")).getText();

        System.out.println("Email Text is : "+emailText);

    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}

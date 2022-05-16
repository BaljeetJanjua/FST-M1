package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.By.id;

public class Activity7 {
    WebDriver driver;
    WebDriverWait wait;
    Actions builder;

    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        //create a new instance of Actions class
        builder = new Actions(driver);

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //Open browser
        driver.get("https://alchemy.hguy.co/jobs/");
        driver.manage().window().fullscreen();
    }

    @Test
    public void TestCase7() throws InterruptedException {
        // Check the title of the page
        String title = driver.getTitle();

        //Print the title of the first page
        System.out.println("First Page title is: " + title);

        //Click on Post on Job

        WebElement PostJobLink = driver.findElement(By.cssSelector("#menu-item-26 > a:nth-child(1)"));

        PostJobLink.click();

        String title2 = driver.getTitle();

        //Print the title of the Second page
        System.out.println("Second Page title is: " + title2);

        //Assertion for second page title
        Assert.assertEquals("Post a Job – Alchemy Jobs", title2);

        //Enter the required information

        WebElement JobEmail = driver.findElement(By.id("create_account_email"));
        JobEmail.sendKeys("test@example2.com");

        WebElement JobTitle = driver.findElement(By.id("job_title"));
        JobTitle.sendKeys("Automation Tester_FST Batch");

        String ExpTitle = JobTitle.getAttribute("value");

        System.out.println("Expected Job Title on Jobs Page is : " + ExpTitle);

        WebElement JobLocation = driver.findElement(By.id("job_location"));
        JobLocation.sendKeys("Haryana");

        //Get the iframe; wait until it appears        // Job Desc is under iframe; so use Actions class to perform type action

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("job_description_ifr")));
        WebElement JobDescFrame = driver.findElement(By.id("job_description_ifr"));
        builder.click(JobDescFrame).sendKeys("Tester is doing assignment for FST training").build().perform();


        // Job Description
       // driver.switchTo().frame(0);
        //driver.findElement(By.tagName("body")).sendKeys("This is job involves testing all types of applications.");
        //driver.switchTo().defaultContent();

        WebElement AppEmail = driver.findElement(By.id("application"));
        AppEmail.click();
        AppEmail.sendKeys("www.ibm.com");


        WebElement JobCompanyName = driver.findElement(By.id("company_name"));
        JobCompanyName.sendKeys("IBM");

        //entering information ends here

        //click on Preview button
        WebElement PreviewButton = driver.findElement(By.xpath("//*[@name='submit_job']"));
        PreviewButton.click();

        //click on Submit Listing button
       // WebElement SubmitButton = driver.findElement(By.xpath("//*[@name='continue']"));

        //System.out.println("Post posted successfully with name as : " + ExpTitle);
    }

    @Test
    public void VerifyJob() throws InterruptedException {

        WebElement JobsLink = driver.findElement(By.cssSelector("#menu-item-24 > a:nth-child(1)"));

        JobsLink.click();

        //Search the entered job
        //Search the jobs

        WebElement SearchJob = driver.findElement(By.id("search_keywords"));
        SearchJob.sendKeys("Automation Tester");

        driver.findElement(By.xpath("//div[@class='search_submit']")).click();

        //wait for list to view
        Thread.sleep(1000);

        // Verify the first job
        //String ActJobTitle = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/div/ul/li[1]/a/div[1]/h3")).getText();
        //cssSelector(".post-4475 > a:nth-child(1) > div:nth-child(2) > h3:nth-child(1)")).getText();


        // Wait for page to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@itemprop='headline']")));

        // Assertion
        String postedJobTitle = driver.findElement(By.xpath("//div[@class='position']/h3")).getText();
        Assert.assertEquals(postedJobTitle, "Automation Tester");

    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.close();
    }
}

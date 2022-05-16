package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity5 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://alchemy.hguy.co/jobs/");
    }

    @Test
    public void TestCase5() {
        // Check the title of the page
        String title = driver.getTitle();

        //Print the title of the first page
        System.out.println("Page title is: " + title);

        //Click on Jobs

        WebElement JobsLink = driver.findElement(By.cssSelector("#menu-item-24 > a:nth-child(1)"));

        JobsLink.click();

        String title2 = driver.getTitle();

        //Print the title of the Second page
        System.out.println("Page title is: " + title2);

        //Assertion for second page title
        Assert.assertEquals("Jobs – Alchemy Jobs", title2);
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
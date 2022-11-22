import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_2 {
    public static void main(String [] args) throws InterruptedException {

        // Create a new instance of the Firefox driver
        WebDriver driver= new FirefoxDriver();
        // Open the browser
        driver.get("https://www.training-support.net/selenium/simple-form");

        //Check the title of the page
        String title = driver.getTitle();
        //Print the title of the page
        System.out.println("Page title is: " + title);

        //WebElement FirstNameLocator =
        driver.findElement(By.xpath("//*[@id ='firstName']")).sendKeys("Baljeet");
        //WebElement LastNameLocator =
        driver.findElement(By.xpath("//*[@id ='lastName']")).sendKeys("Janjua");
        WebElement EmailLocator = driver.findElement(By.xpath("//*[@id ='email']"));
        EmailLocator.sendKeys("test@example.com");
        WebElement PhoneLocator = driver.findElement(By.xpath("//*[@id ='number']"));
        PhoneLocator.sendKeys("1234567890");

        Thread.sleep(1000);

        // Submit the form

        driver.findElement(By.xpath("//*[@value='submit']")).click();
        //driver.findElement(By.xpath("//input[contains(@class, 'green')]")).click();

        // Close the browser
        //driver.quit();
    }
}
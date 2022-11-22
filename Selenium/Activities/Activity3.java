import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String[] args) throws InterruptedException {

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        //Open the browser
        driver.get("https://www.training-support.net/selenium/simple-form");

        //Find the page title and print it
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        //Find the input fields
        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastName = driver.findElement(By.id("lastName"));
        //Enter text
        firstName.sendKeys("Baljeet");
        lastName.sendKeys("Janjua");

        //Enter the email
        driver.findElement(By.id("email")).sendKeys("test@example.com");

        //Enter the contact number
        driver.findElement(By.id("number")).sendKeys("1234567891");

        //Click Submit
        driver.findElement(By.cssSelector("input.green")).click();
        Thread.sleep(1000);
        //Close the browser
        driver.quit();
    }

}

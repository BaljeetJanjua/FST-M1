import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_1 {
    public static void main(String [] args) throws InterruptedException {

        // Create a new instance of the Firefox driver
        WebDriver driver= new FirefoxDriver();
        // Open the browser
        driver.get("https://www.training-support.net/");

        //Check the title of the page
        String title = driver.getTitle();
        //Print the title of the page
        System.out.println("Page title is: " + title);

        WebElement linkXpathLocator = driver.findElement(By.xpath("//a[@id ='about-link']"));

        System.out.println("Text in XpathElement: " + linkXpathLocator.getText());

        linkXpathLocator.click();

        Thread.sleep(1000);

        //Print title of new page
        System.out.println("Heading is: " + driver.getTitle());

        // Close the browser
        driver.quit();
    }
}


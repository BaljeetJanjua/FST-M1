import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
    public static void main(String [] args){

        // Create a new instance of the Firefox driver
        WebDriver driver= new FirefoxDriver();
        // Open the browser
        driver.get("https://www.training-support.net/");

        //Check the title of the page
        String title = driver.getTitle();
        //Print the title of the page
        System.out.println("Page title is: " + title);

        WebElement linkIdLocator = driver.findElement(By.id("about-link"));
        System.out.println("Text in IDelement: " + linkIdLocator.getText());

        WebElement linkClassnamelocator = driver.findElement(By.className("green"));
        System.out.println("Text in ClassNameelement: " + linkClassnamelocator.getText());

        WebElement linkTextLocator = driver.findElement(By.linkText("About Us"));
        System.out.println("Text in Linkelement: " + linkTextLocator.getText());

        WebElement cssLocator = driver.findElement(By.cssSelector("#about-link"));
        System.out.println("Text in Csselement: " + cssLocator.getText());

        // Close the browser
        driver.quit();
    }
}


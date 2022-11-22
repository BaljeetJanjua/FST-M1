import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_3 {
    public static void main(String[] args) throws InterruptedException {

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        // Open the browser
        driver.get("https://www.training-support.net/selenium/target-practice");

        //Check the title of the page
        String title = driver.getTitle();
        //Print the title of the page
        System.out.println("Page title is: " + title);

        WebElement thirdHeader = driver.findElement(By.xpath("//*[@id='third-header']"));
        System.out.println("Third Header Text is " + thirdHeader.getText());

        String Color = driver.findElement(By.xpath("//*[@class='ui green header']")).getCssValue("color");
        //String Color = driver.findElement(By.xpath("//h5")).getCssValue("color");
        System.out.println("Color of Fifth Header is " + Color);

        String VioletButtonClasses= driver.findElement(By.xpath("//button[contains(text(),'Violet')]")).getAttribute("class");
        System.out.println("Class name of Violet button is: " + VioletButtonClasses);

        String GreyBtn = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]")).getText();
        System.out.println("Grey button is " + GreyBtn);

        driver.quit();
    }
}
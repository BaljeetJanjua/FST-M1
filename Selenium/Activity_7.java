import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Activity_7 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        //Open browser
        driver.get("https://training-support.net/selenium/dynamic-attributes");

        //Check the title of the page
        String title = driver.getTitle();
        //Print the title of the page
        System.out.println("Page title is: " + title);

        //find username and password and enter values
        driver.findElement(By.xpath("//input[starts-with(@class,'username')]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[starts-with(@class, 'password')]")).sendKeys("password");

        //// Click on Login button

        driver.findElement(By.xpath("//button[contains(text(), 'Log in')]")).click();

        //Print login message
        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: " + loginMessage);

        //Close browser
        driver.quit();
    }
}
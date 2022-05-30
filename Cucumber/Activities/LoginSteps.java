package StepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginSteps {
    private WebDriver driver;
    private WebDriverWait wait;

    @Given("^User is on Login page$")

    public void UserLaunchesPage() {

        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 20);
        driver.get("https://www.training-support.net/selenium/login-form");

    }

    @When("^User enters username and password$")

    public void UserEnterCredentials(){
        driver.findElement(By.id("username")).sendKeys("admin", Keys.RETURN);
        driver.findElement(By.id("password")).sendKeys("password", Keys.RETURN);
        driver.findElement(By.xpath("//button[contains(text(), 'Log in')]")).click();
    }
    @Then("^Read the page title and confirmation message$")

    public void ReadLoginMsg(){

        String Title = driver.getTitle();
        System.out.println("Title of Page is :"+ Title);

        String LoggedInMsg = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Loggedin Message: " + LoggedInMsg);
    }

    @And("^Close Browser$")

    public void closeBrowser (){
        driver.quit();
    }
}

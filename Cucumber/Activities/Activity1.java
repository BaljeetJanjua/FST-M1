package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity1 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Given("^User is on Google Home Page$")

    public void UserIsOnHomePage(){

        driver= new FirefoxDriver();
        wait = new WebDriverWait(driver, 20);
        driver.get("https://google.com");
    }

    @When("^User types in Cheese and hits ENTER$")

    public void UserTypesSearch(){
            driver.findElement(By.name("q")).sendKeys("Cheese", Keys.RETURN);
    }

    @Then("^Show how many search results were shown$")

    public void SearchResults(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result-stats")));
        String resultStats = driver.findElement(By.id("result-stats")).getText();
        System.out.println("Number of results found: " + resultStats);
    }

    @And("^Close the browser$")
    public void closeTheBrowser() throws Throwable {
        driver.quit();
    }
}

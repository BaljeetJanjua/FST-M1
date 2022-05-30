package TestRunners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"StepDefinitions"},
       //tags = "@Activity1"
        //tags = "@Activity2"
        tags = "@Activity3",
        monochrome = true,
        plugin = {"html:target/cucumber-reports/reports"}
)

public class ActivityRunner {
    //empty
}


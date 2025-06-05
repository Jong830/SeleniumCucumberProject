package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "C:\\Users\\John Ong\\SeleniumCucumberProject\\src\\test\\resources\\features",
    glue = "stepdefs",
    //plugin = {"json:target/cucumber.json"},
    plugin = {"pretty", "html:target/cucumber-report.html"},
    monochrome = true
)
public class RunCucumberTest {}

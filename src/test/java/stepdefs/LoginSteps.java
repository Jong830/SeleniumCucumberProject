package stepdefs;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

// import org.openqa.selenium.interactions.Actions;
// import org.openqa.selenium.Keys;

public class LoginSteps {

    WebDriver driver = null;
    loginPage login;

    @Given("I launch the website")
    public void launchWebsite() {
        System.out.println("Inside Step - browser is open");
        String projectPath = System.getProperty("user.dir");
        System.out.println("Project path is:"+projectPath);

        System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.navigate().to("https://www.saucedemo.com/");
    }

    @When("I login with username (.*) and password (.*)$")
    public void loginWithCredentials(String username, String password) throws InterruptedException {
        // driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
        // driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        // driver.findElement(By.xpath("//input[@id='login-button']")).click();

        login = new loginPage(driver);

        login.enterUsername(username);

        login.enterPassword(password);

        login.clickLogin();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Thread.sleep(2000);
        
        // Actions actions = new Actions(driver);
        // actions.sendKeys(Keys.ENTER).perform();
    }

    @Then("I verify successfully login")
    public void verifyLoginSuccess() {
        login.logout();

        String actualText = driver.findElement(By.className("login_logo")).getText();
        String expectedText = "Swag Labs";

        assertEquals("Text does not match!", expectedText, actualText);

        driver.close();
        driver.quit();
    }
}

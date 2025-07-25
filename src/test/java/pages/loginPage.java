package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By userField = By.id("user-name");
    By passField = By.id("password");
    By loginBtn = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("https://www.saucedemo.com/");
    }

    public void login(String username, String password) {
        driver.findElement(userField).sendKeys(username);
        driver.findElement(passField).sendKeys(password);
        driver.findElement(loginBtn).click();
    }
}

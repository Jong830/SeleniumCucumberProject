package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class loginPage {

    WebDriver driver;

    By inputUserName = By.xpath("//input[@id='user-name']");
    By inputPassword = By.xpath("//input[@id='password']");
    By loginButton = By.xpath("//input[@id='login-button']");
    By burgerMenu = By.xpath("//button[@id='react-burger-menu-btn']");
    By sideBarMenuLogOut = By.xpath("//a[@id='logout_sidebar_link']");
    
    
    public loginPage(WebDriver driver){
        System.out.println("Login Page Displayed");
        this.driver = driver;
    }

    public void enterUsername(String username){
        System.out.println("Username is displayed");
        driver.findElement(inputUserName).sendKeys(username);
    }

    public void enterPassword(String password){
        System.out.println("Password is displayed");
        driver.findElement(inputPassword).sendKeys(password);
    }

    public void clickLogin(){
        System.out.println("Login Button is clicked");
        driver.findElement(loginButton).click();
    }

    public void logout(){
        System.out.println("Logout is initiated");
        driver.findElement(burgerMenu).isDisplayed();
        driver.findElement(burgerMenu).click();
        driver.findElement(sideBarMenuLogOut).isDisplayed();
        driver.findElement(sideBarMenuLogOut).click();
    }
    

}
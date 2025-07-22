package stepdefs;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.*;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class SauceSteps {
    WebDriver driver = hooks.Hooks.driver;
    LoginPage loginPage = new LoginPage(driver);
    InventoryPage inventoryPage = new InventoryPage(driver);
    CartPage cartPage = new CartPage(driver);
    double price;

    @Given("^I am logged in with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void login(String username, String password) {
        loginPage.login(username, password);
    }

    @When("^I add all items priced below ([0-9]+(?:\\.[0-9]+)?) to the cart$")
    public void addItemsBelowPrice(double maxPrice) {
        this.price = maxPrice;
        inventoryPage.addItemsUnderPrice(maxPrice);
    }

    @Then("^I should see all items priced below ([0-9]+(?:\\.[0-9]+)?) in the cart$")
    public void verifyItemsInCart(double maxPrice) {
        inventoryPage.goToCart();
        List<Double> prices = cartPage.getCartPrices();
        for (Double itemPrice : prices) {
            assertTrue(itemPrice < maxPrice, "Item price " + itemPrice + " is not < " + maxPrice);
        }
    }
}

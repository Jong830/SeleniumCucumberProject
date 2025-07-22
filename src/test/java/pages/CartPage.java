package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage {
    WebDriver driver;

    By cartItemPrices = By.className("inventory_item_price");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<Double> getCartPrices() {
        List<WebElement> prices = driver.findElements(cartItemPrices);
        return prices.stream()
                     .map(p -> Double.parseDouble(p.getText().replace("$", "")))
                     .collect(Collectors.toList());
    }
}

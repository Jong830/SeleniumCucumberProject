package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryPage {
    WebDriver driver;

    By itemPrices = By.className("inventory_item_price");
    By addButtons = By.xpath("//button[contains(text(),'Add to cart')]");
    By cartBtn = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addItemsUnderPrice(double priceLimit) {
        List<WebElement> prices = driver.findElements(itemPrices);
        List<WebElement> buttons = driver.findElements(addButtons);

        for (int i = 0; i < prices.size(); i++) {
            String priceText = prices.get(i).getText().replace("$", "");
            double price = Double.parseDouble(priceText);
            if (price < priceLimit) {
                buttons.get(i).click();
            }
        }
    }

    public void goToCart() {
        driver.findElement(cartBtn).click();
    }
}

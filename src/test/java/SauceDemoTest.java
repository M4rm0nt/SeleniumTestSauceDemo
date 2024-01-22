import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SauceDemoTest {

    @Test
    public void testLoginAddToCartAndCheckout() {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        driver.findElement(By.className("shopping_cart_link")).click();

        boolean isProductInCart = driver.findElements(By.className("inventory_item_name")).stream()
                .anyMatch(element -> element.getText().equals("Sauce Labs Backpack"));
        assertTrue(isProductInCart);

        driver.quit();
    }
}

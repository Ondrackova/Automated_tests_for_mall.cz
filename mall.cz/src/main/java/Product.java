import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Product {

    WebDriver browser;
    WebDriverWait browserWait;

    //browser inicialization
    public Product(WebDriver browser) {
        this.browser = browser;
        this.browserWait = new WebDriverWait(browser, Duration.ofSeconds(5));
    }

    //add item to the cart
    void AddToCart () {
        browserWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".info-box__main-btn .add-to-cart-list"))).click();
    }
}

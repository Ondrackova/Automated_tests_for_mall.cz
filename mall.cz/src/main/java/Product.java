import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Product {

    WebDriver browser;

    //browser inicialization
    public Product(WebDriver browser) {
        this.browser = browser;
    }

    //add item to the cart
    void AddToCart () {
        browser.findElement(By.cssSelector(".info-box__main-btn .add-to-cart-list")).click();
    }
}

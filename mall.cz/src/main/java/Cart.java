import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Cart {
    WebDriver browser;
    WebDriverWait browserWait;

    //browser inicialization
    public Cart(WebDriver browser) {
        this.browser = browser;
        this.browserWait = new WebDriverWait(browser, Duration.ofSeconds(5));
    }

    //open page with cart
    void open () {
        browser.get("https://www.mall.cz/kosik");
    }
    // go back to the home page
    void goBack() {
        browserWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".go_back_btn"))).click();
    }
    //checkout
    void goCheckOut () {
        browserWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".cart-layout__fixed-btn .btn .btn--primary"))).click();
    }
    //delete all basket
    void deleteAllCartItem () {
        browserWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".delete-text hidden-mobile"))).click();
    }

    //delete one cart item
    void deleteCartItem(int index) {
        browserWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".cart-overview-item-row__delete .cart__remove-icon"))).click();
    }

   //name of actual products in the cart
    String getProductName (int index) {
        return browserWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("cart-overview-item-row .cart-overview-item"))).getText();
    }

}

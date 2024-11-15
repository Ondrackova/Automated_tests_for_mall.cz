import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart {
    WebDriver browser;

    //browser inicialization
    public Cart(WebDriver browser) {
        this.browser = browser;
    }
    //open page with cart
    void open () {
        browser.get("https://www.mall.cz/kosik");
    }
    // go back to the home page
    void goBack() {
        browser.findElement(By.cssSelector(".go_back_btn")).click();
    }
    //checkout
    void goCheckOut () {
        browser.findElement(By.cssSelector(".cart-layout__fixed-btn .btn .btn--primary")).click();
    }
    //delete all basket
    void deleteAllCartItem () {
        browser.findElement(By.cssSelector(".delete-text hidden-mobile")).click();
    }

    //delete one cart item
    void deleteCartItem(int index) {
        browser.findElements(By.cssSelector(".cart-overview-item-row__delete .cart__remove-icon")).get(index).click();
    }

   //name of actual products in the cart
    String getProductName (int index) {
        return browser.findElements(By.cssSelector("cart-overview-item-row .cart-overview-item")).get(index).getText();
    }

}

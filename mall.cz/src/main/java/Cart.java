import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Cart  extends MallPage{


    public Cart(WebDriver browser) {
        super(browser);
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
    String getProductActualName (int index) {
        //return browserWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("cart-overview-item-row .cart-overview-item"))).getText();
        return browserWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".cart-overview-item-row__title-and-params"))).getText();     //var actualName = browser.findElement(By.cssSelector(".cart-overview-item-row__title-and-params")).getText();
    }
    //name of expected product in the cart
    String getProductExpectedName (int index) {
       return browserWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".detail__title--desktop"))).getText();
    }

}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Cart  extends MallPage{


    public Cart(WebDriver browser) {
        super(browser);
    }

    void open () {
        browser.get("https://www.mall.cz/kosik");
    }

    void goBack() {
        browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.cssSelector(".go_back_btn")))
                .click();
    }

    void goCheckOut () {
        browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.cssSelector(".cart-layout__fixed-btn .btn .btn--primary")))
                .click();
    }

    void deleteAllCartItem () {
        browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.cssSelector(".delete-text hidden-mobile")))
                .click();
    }

    void deleteCartItem(int index) {
        browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.cssSelector(".cart-overview-item-row__delete .cart__remove-icon")))
                .click();
    }

    String getProductActualName (int index) {
        return browserWait.until
                (ExpectedConditions.presenceOfElementLocated
                        (By.cssSelector(".cart-overview-item-row__title-and-params")))
                .getText();
    }

    String getProductExpectedName (int index) {
       return browserWait.until
               (ExpectedConditions.presenceOfElementLocated
                       (By.cssSelector(".detail__title--desktop")))
               .getText();
    }

}

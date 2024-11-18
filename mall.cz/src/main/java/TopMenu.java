import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TopMenu {
    WebDriver browser;
    WebDriverWait browserWait;

    //browser inicialization
    public TopMenu(WebDriver browser) {
        this.browser = browser;
        this.browserWait = new WebDriverWait(browser, Duration.ofSeconds(5));
    }

    //prices and delivery
    void priceDelivery () {
        browserWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".list-item__link__text"))).click();
    }
    //click on everything about shopping
    void everythingAboutShopping () {
        browserWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/vse-nakupu']"))).click();
    }

}

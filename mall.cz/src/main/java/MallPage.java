import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MallPage {
    WebDriver browser;
    WebDriverWait browserWait;

    //browser inicialization
    public MallPage(WebDriver browser) {
        this.browser = browser;
        this.browserWait = new WebDriverWait(browser, Duration.ofSeconds(5));
    }
    void mainLogo () {
        browserWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".basic-link .header__logo .nuxt-link-exact-active .nuxt-link-active .basic-link--primary"))).click();
    }
    void logIn () {
        browserWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".mobile-icons__item__icon"))).click();
    }
    void goToCart() {
        browserWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".mobile-icons__item .mobile-icons__cart"))).click();
    }


}

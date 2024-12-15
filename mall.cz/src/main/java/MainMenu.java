import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainMenu {
    WebDriver browser;
    WebDriverWait browserWait;

    //browser initialization
    public MainMenu(WebDriver browser) {
        this.browser = browser;
        this.browserWait = new WebDriverWait(browser, Duration.ofSeconds(5));
    }

    //click on Appliances
    void mainMenuAppliances() {
        browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.cssSelector(".desktop-menu__item-title")))
                .click();
    }
}

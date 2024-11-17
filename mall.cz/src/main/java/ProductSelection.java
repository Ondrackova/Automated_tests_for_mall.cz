import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductSelection {
    WebDriver browser;
    WebDriverWait browserWait;

    //browser inicialization
    public ProductSelection(WebDriver browser) {
        this.browser = browser;
        this.browserWait = new WebDriverWait(browser, Duration.ofSeconds(5));
    }

    void ShowMoreAboutProduct () {
            browserWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("description-accordion__open"))).click();
        }

        void SelectPopularProduct (int index) {
            browserWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("bs__name"))).click();
        }

        void ShowMorePopularProducts () {
            browserWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("bs__show-more-link"))).click();
        }

    }
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Services{
    WebDriver browser;
    WebDriverWait browserWait;

    //browser inicialization
    public Services(WebDriver browser) {
        this.browser = browser;
        this.browserWait = new WebDriverWait(browser, Duration.ofSeconds(5));
    }
    void checkingDelivery () {
        browserWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".osobni .cnt")));
    }
    //click on Complains
    void complains () {
        browserWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/vraceni-reklamace']"))).click();

    }
    void services () {
        browserWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/reklamace-zbozi']"))).click();
    }
}

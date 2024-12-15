import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SecondMenu {
    WebDriver browser;
    WebDriverWait browserWait;

    //browser initialization
    public SecondMenu(WebDriver browser) {
        this.browser = browser;
        this.browserWait = new WebDriverWait(browser, Duration.ofSeconds(5));
    }
    void menuHairDryers () {
        browserWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/feny']"))).click();

    }
    void menuCoffeeMakers () {
        browser.findElement(By.xpath("//a[@href='/espressa-kavovary']")).click();
    }
}

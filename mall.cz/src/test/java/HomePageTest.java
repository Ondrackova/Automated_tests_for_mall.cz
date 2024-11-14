import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.net.ssl.HttpsURLConnection;
import java.time.Duration;

import static io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver;

public class HomePageTest {

    @Test
    void homePageTest() {
        WebDriver browser = WebDriverManager.firefoxdriver().create();
        browser.get("https://mall.cz");
         //accept cookies
        WebElement cookiesAcceptButton = browser.findElement(By.cssSelector(".legal-consent__button-container"));
        cookiesAcceptButton.click();

        Assertions.assertEquals("MALL.CZ – bílé zboží, elektronika, PC, outdoor, hobby, hračky, kosmetika, chovatelské potřeby", browser.getTitle());
        //later click a button on its index (0,1,2)
       // browser.findElements((By.cssSelector("legal-consent__button-container")).get(2).click());
    }

    @Test
    void HairDryerTest () {
        WebDriver browser = WebDriverManager.firefoxdriver().create();
        WebDriverWait browserWait = new WebDriverWait(browser, Duration.ofSeconds(10));
        browser.get("https://mall.cz");
        //accept cookies
        WebElement cookiesAcceptButton = browser.findElement(By.cssSelector(".legal-consent__button-container"));
        cookiesAcceptButton.click();

        //click on Spotrebice
        browser.findElement(By.cssSelector(".desktop-menu__item-title")).click();

        //click on hair dryers / feny
        browserWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/feny']"))).click();
       // browser.findElement(By.xpath("//a[@href='/feny']")).click();

        //click on fen Philips
        browserWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".bs__title"))).click();
        //browser.findElement(By.cssSelector(".bs__title")).click();

        //check item
        var expectedName = browserWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".detail__title--desktop"))).getText();
        //var expectedName = browser.findElement(By.cssSelector(".detail__title--desktop")).getText();

        //add to cart
        browser.findElement(By.cssSelector(".info-box__main-btn .add-to-cart-list")).click();

        //open cart
        browserWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".cross-sell__button__to-cart__to"))).click();
        //browser.findElement(By.cssSelector(".cross-sell__button__to-cart__to")).click();

        //check item in cart
        var actualName = browserWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".cart-overview-item-row__title-and-params"))).getText();     //var actualName = browser.findElement(By.cssSelector(".cart-overview-item-row__title-and-params")).getText();

        //if in cart is the same item as we want
        Assertions.assertEquals(expectedName, actualName);
    }

    @Test
    void PricesMallTest () {
        WebDriver browser = WebDriverManager.firefoxdriver().create();
        WebDriverWait browserWait = new WebDriverWait(browser, Duration.ofSeconds(10));
        browser.get("https://mall.cz");

        //prices and delivery
        browserWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".list-item__link__text"))).click();
        //browser.findElement(By.cssSelector(".list-item__link__text")).click();

        //check partner delivery
        //WebElement button = browser.findElement(By.cssSelector(".osobni .cnt"));
        WebElement button = browserWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".osobni .cnt")));
        Assertions.assertTrue(button.isDisplayed());
    }
    @Test
    void ComplaintsTest () {
        WebDriver browser = WebDriverManager.firefoxdriver().create();
        WebDriverWait browserWait = new WebDriverWait(browser, Duration.ofSeconds(10));
        browser.get("https://mall.cz");

        //everything about shopping
        browser.findElement(By.cssSelector(".list-item__link__text")).click();
        //Complains
        browser.findElement(By.cssSelector(".lst-guide-item-body .cnt")).click();
        browser.findElement(By.id("servis")).click();
    }
}



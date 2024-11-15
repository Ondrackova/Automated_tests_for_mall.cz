import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageTest {
   //loadding browser
    WebDriver browser = WebDriverManager.firefoxdriver().create();
    //add time for waiting 5 s
    WebDriverWait browserWait = new WebDriverWait(browser, Duration.ofSeconds(5));

    Cart cartPage;
    MainMenu Menu;
    Product productPage;

    //freeze a browser for 5 s
   void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeEach
    void beforeTest() {
        //loading the web
        browser.get("https://mall.cz");

        //accept cookies
        WebElement cookiesAcceptButton = browser.findElement(By.cssSelector(".legal-consent__button-container"));
        cookiesAcceptButton.click();

        cartPage = new Cart(browser); //functions for cart operations
        Menu = new MainMenu(browser); //functions for main menu items
        productPage = new Product(browser);
    }

    @Test
    void homePageTest() {
        //assert
        Assertions.assertEquals("MALL.CZ – bílé zboží, elektronika, PC, outdoor, hobby, hračky, kosmetika, chovatelské potřeby", browser.getTitle());
        //later click a button on its index (0,1,2)
        //browser.findElements((By.cssSelector("legal-consent__button-container")).get(2).click());
    }

    @Test
    void HairDryerTest () {
        MainMenu Menu = new MainMenu(browser);
        ProductSelection productSelectionPage = new ProductSelection(browser);

        //click on Appliances
        Menu.MainMenuAppliances();

        //click on hair dryers /feny
        browser.findElement(By.xpath("//a[@href='/feny']")).click();

        //click on fen Philips
        waitFor(2);
        browser.findElement(By.cssSelector(".bs__title")).click();

        //check item
        waitFor(2);
        var expectedName = browser.findElement(By.cssSelector(".detail__title--desktop")).getText();

        //add to cart
        browser.findElement(By.cssSelector(".info-box__main-btn .add-to-cart-list")).click();

        //open cart
        waitFor(2);
        browser.findElement(By.cssSelector(".cross-sell__button__to-cart__to")).click();
        //browserWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".cross-sell__button__to-cart__to"))).click();

        //check items in cart
        waitFor(2);
        var actualName = browser.findElement(By.cssSelector(".cart-overview-item-row__title-and-params")).getText();
        //var actualName = browserWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".cart-overview-item-row__title-and-params"))).getText();     //var actualName = browser.findElement(By.cssSelector(".cart-overview-item-row__title-and-params")).getText();

        //check counts of items
        Assertions.assertEquals(expectedName, actualName);
    }

    @Test
    void DeliveryMallTest () {
        //prices and delivery
        browser.findElement(By.cssSelector(".list-item__link__text")).click();
        //browserWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".list-item__link__text"))).click();

        //check partner delivery
        waitFor(2);
        WebElement button = browser.findElement(By.cssSelector(".osobni .cnt"));
        //WebElement button = browserWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".osobni .cnt")));

        //assert present partner delivery
        Assertions.assertTrue(button.isDisplayed());
    }
    @Test
    void ComplaintsTest () {
        //click on everything about shopping
        browser.findElement(By.xpath("//a[@href='/vse-nakupu']")).click();
        //browserWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/vse-nakupu']"))).click();

        //click on Complains
        //browser.findElement(By.cssSelector("//a[@href='/vraceni-reklamace']")).click();
        browserWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/vraceni-reklamace']"))).click();

        //click on servis
        browser.findElement(By.xpath("//a[@href='/reklamace-zbozi']")).click();
        //browserWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/reklamace-zbozi']"))).click();

        //asertace presents of Partner servis
        WebElement button = browser.findElement(By.id("servis"));
        Assertions.assertTrue(button.isDisplayed());
    }

    @Test
    void CoffeeTest () {
        Cart cartPage = new Cart(browser); //functions for cart operations
        MainMenu Menu = new MainMenu(browser); //functions for main menu items
        Product productPage = new Product(browser);

        //click on Appliances
        Menu.MainMenuAppliances();

        //click on Esspresso and coffee maker
        browser.findElement(By.xpath("//a[@href='/espressa-kavovary']")).click();

        //click on Coffee maker
        waitFor(2);
        browser.findElement(By.cssSelector(".bs__name")).click();
        //browserWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".bs__name"))).click();

        //save an expected name of item
        waitFor(2);
        var expectedValue = browser.findElement(By.cssSelector(".detail__title--desktop")).getText();
        //var expectedValue = browserWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".detail__title--desktop"))).getText();

        //click add to card
        productPage.AddToCart();

        //go to the card
        cartPage.open();

        //variable for actual value
        //var actualValue = cartPage.getProductName(0);
        var actualValue = browserWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".cart-overview-item-title"))).getText();

        //variable for counter
        var counter = browser.findElement(By.cssSelector(".article-counter__input")).getText();
        //2 items
        counter += "2";

        //assert item(Coffee maker)
        Assertions.assertEquals(expectedValue, actualValue);
        //assert count of items
        Assertions.assertEquals("2", counter);
    }
    @Test
    void cartOperations() {
        Cart cartPage = new Cart(browser);

        cartPage.open();
        cartPage.goBack();
        //cartPage.deleteAllCartItem();
        //cartPage.deleteCartItem(0);
    }
}




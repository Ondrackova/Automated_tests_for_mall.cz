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

public class HomePageTest extends BaseTest{

    //add time for waiting 5 s
    WebDriverWait browserWait = new WebDriverWait(browser, Duration.ofSeconds(5));

    Cart cartPage;
    MainMenu Menu;
    Product productPage;
    ProductSelection productSelection;
    SecondMenu secondMenu;
    TopMenu topMenu;
    Services servicesPage;

    @BeforeEach
    void beforeTest () {
        //loading the web
        browser.get("https://mall.cz");

        //accept cookies
        WebElement cookiesAcceptButton = browser.findElement(By.cssSelector(".legal-consent__button-container"));
        cookiesAcceptButton.click();

        cartPage = new Cart(browser); //functions for cart operations
        Menu = new MainMenu(browser); //functions for main menu items
        productPage = new Product(browser);
        productSelection = new ProductSelection(browser);
        secondMenu = new SecondMenu(browser);
        topMenu = new TopMenu(browser);
        servicesPage = new Services(browser);

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

        //click on Appliances
        Menu.MainMenuAppliances();

        //click on hair dryers /feny
        secondMenu.menuHairDryers();

        //click on fen Philips
        productPage.HairDryer();

        //check item
        var expectedName = cartPage.getProductExpectedName(0);
        //add to cart
        productPage.AddToCart();

        //open cart
        cartPage.open();

        //check items in cart
        var actualName = cartPage.getProductActualName(0);

        //check counts of items
        Assertions.assertEquals(expectedName, actualName);
    }

    @Test
    void DeliveryMallTest () {
        //prices and delivery
        topMenu.priceDelivery();
        //browserWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".list-item__link__text"))).click();

        //check partner delivery
        WebElement button = browserWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".osobni .cnt")));

        //assert present partner delivery
        Assertions.assertTrue(button.isDisplayed());
    }
    @Test
    void ComplaintsTest () {
        //click on everything about shopping
        topMenu.everythingAboutShopping();
        //browserWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/vse-nakupu']"))).click();

        //click on Complains
        servicesPage.complains();
        //browserWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/vraceni-reklamace']"))).click();

        //click on servis
        servicesPage.services();
        //browserWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/reklamace-zbozi']"))).click();

        //asertace presents of Partner servis
        WebElement button = browser.findElement(By.id("servis"));
        Assertions.assertTrue(button.isDisplayed());
    }

    @Test
    void CoffeeTest () {

        //click on Appliances
        Menu.MainMenuAppliances();

        //click on Esspresso and coffee maker
        secondMenu.menuCoffeeMakers();

        //click on Coffee maker
        productPage.coffeeMaker();

        //save an expected name of item
        var expectedName = cartPage.getProductExpectedName(0);
        //click add to card
        productPage.AddToCart();

        //go to the card
        cartPage.open();

        //variable for actual value
        //var actualValue = cartPage.getProductActualName(0);
        var actualName = browserWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".cart-overview-item-title"))).getText();

        //variable for counter
        var counter = browser.findElement(By.cssSelector(".article-counter__input")).getText();
        //2 items
        counter += "2";

        //assert item(Coffee maker)
        Assertions.assertEquals(expectedName, actualName);
        //assert count of items
        Assertions.assertEquals("2", counter);
    }
    @Test
    void cartOperations() {
        Cart cartPage = new Cart(browser);

        cartPage.open();
        cartPage.goBack();

    }
}



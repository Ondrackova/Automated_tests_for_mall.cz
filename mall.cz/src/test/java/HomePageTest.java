import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageTest extends BaseTest{

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

        browser.get("https://mall.cz");

        //accept cookies
        WebElement cookiesAcceptButton = browser.findElement
                (By.cssSelector(".legal-consent__button-container"));

        cookiesAcceptButton.click();

        cartPage = new Cart(browser); //functions for cart operations
        Menu = new MainMenu(browser); //functions for main menu items
        productPage = new Product(browser);
        productSelection = new ProductSelection(browser);
        secondMenu = new SecondMenu(browser);
        topMenu = new TopMenu(browser);
        servicesPage = new Services(browser);
        cartPage = new Cart(browser);
    }

    @Test
    void homePageTest() {

        Assertions.assertEquals("MALL.CZ – bílé zboží, elektronika, PC, outdoor, hobby, hračky, kosmetika, chovatelské potřeby",
                browser.getTitle());
    }

    @Test
    void hairDryerTest () {

        Menu.MainMenuAppliances();

        secondMenu.menuHairDryers();

        productPage.HairDryer();

        //check item
        var expectedName = cartPage.getProductExpectedName(0);

        productPage.AddToCart();

        cartPage.open();

        //check items in cart
        var actualName = cartPage.getProductActualName(0);

        Assertions.assertEquals(expectedName, actualName);
    }

    @Test
    void deliveryMallTest () {

        topMenu.priceDelivery();

        //button for partner delivery
        WebElement button = browserWait.until
                (ExpectedConditions.elementToBeClickable(By.cssSelector(".osobni .cnt")));

        Assertions.assertTrue(button.isDisplayed());
    }
    @Test
    void complaintsTest () {

        topMenu.everythingAboutShopping();

        servicesPage.complains();

        servicesPage.services();

        //button for Partner servis
        WebElement button = browser.findElement(By.id("servis"));

        Assertions.assertTrue(button.isDisplayed());
    }

    @Test
    void coffeeTest () {

        Menu.MainMenuAppliances();

        secondMenu.menuCoffeeMakers();

        productPage.coffeeMaker();

        //variable for expected name of item
        var expectedName = cartPage.getProductExpectedName(0);

        productPage.AddToCart();

        cartPage.open();

        //variable for actual value
        var actualName = browserWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".cart-overview-item-title"))).getText();

        //variable for counter
        var counter = browser.findElement(By.cssSelector(".article-counter__input")).getText();
        //2 items
        counter += "2";

        Assertions.assertEquals(expectedName, actualName);
        Assertions.assertEquals("2", counter);
    }
    @Test
    void cartOperations() {

        cartPage.open();
        cartPage.goBack();
    }
}



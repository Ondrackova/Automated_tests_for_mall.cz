import org.junit.jupiter.api.AfterEach;
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
    MainMenu menu;
    Product productPage;
    ProductSelection productSelection;
    SecondMenu secondMenu;
    TopMenu topMenu;
    Services servicesPage;

    @Override
    @BeforeEach
    void beforeTest () {

        super.beforeTest();

        cartPage = new Cart(browser); //functions for cart operations
        menu = new MainMenu(browser); //functions for main menu items
        productPage = new Product(browser);
        productSelection = new ProductSelection(browser);
        secondMenu = new SecondMenu(browser);
        topMenu = new TopMenu(browser);
        servicesPage = new Services(browser);
        cartPage = new Cart(browser);
    }

    @AfterEach
    void afterTest () {
        browser.close();
    }

    @Test
    void homePageTest() {

        Assertions.assertEquals("MALL.CZ – bílé zboží, elektronika, PC, outdoor, hobby, hračky, kosmetika, chovatelské potřeby",
                browser.getTitle());
    }

    @Test
    void hairDryerTest () {

        menu.mainMenuAppliances();

        secondMenu.menuHairDryers();

        productPage.hairDryer();

        //check item
        var expectedName = cartPage.getProductExpectedName(0);

        productPage.addToCart();

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
                (ExpectedConditions.elementToBeClickable
                        (By.cssSelector(".osobni .cnt")));

        Assertions.assertTrue
                (button.isDisplayed());
    }
    @Test
    void complaintsTest () {

        topMenu.everythingAboutShopping();

        servicesPage.complains();

        servicesPage.services();

        //button for Partner service
        WebElement button = browser.findElement
                (By.id("servis"));

        Assertions.assertTrue
                (button.isDisplayed());
    }

    @Test
    void coffeeTest () {

        menu.mainMenuAppliances();

        secondMenu.menuCoffeeMakers();

        productPage.coffeeMaker();

        //variable for expected name of item
        var expectedName = cartPage.getProductExpectedName(0);

        productPage.addToCart();

        cartPage.open();

        //variable for actual value
        var actualName = browserWait.until
                        (ExpectedConditions.elementToBeClickable
                                (By.cssSelector(".cart-overview-item-title")))
                .getText();

        //variable for counter
        var counter = browser.findElement
                        (By.cssSelector(".article-counter__input"))
                .getText();
        //2 items
        counter += "2";

        Assertions.assertEquals
                (expectedName, actualName);
        Assertions.assertEquals
                ("2", counter);
    }
    @Test
    void cartOperations() {

        cartPage.open();
        cartPage.goBack();
    }
}



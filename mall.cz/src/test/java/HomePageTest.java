import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePageTest extends BaseTest{

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

        //lego advertising
        try {
            WebElement legoAdvertising = browserWait.until
                    (ExpectedConditions.elementToBeClickable(By.id("l-exponea-close")));
            legoAdvertising.click();
        } catch (Exception e) {
            System.out.println("Lego advertising not found");
        }

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
        WebElement buttonPartnerDelivery = browserWait.until
                (ExpectedConditions.elementToBeClickable
                        (By.cssSelector(".osobni .cnt")));

        Assertions.assertTrue
                (buttonPartnerDelivery.isDisplayed());
    }
    @Test
    void complaintsTest () {

        topMenu.everythingAboutShopping();

        servicesPage.complains();

        servicesPage.services();

        //button for Partner service
        WebElement buttonPartnerService = browser.findElement
                (By.id("servis"));

        Assertions.assertTrue
                (buttonPartnerService.isDisplayed());
    }

    @Test
    void coffeeTest () {

        menu.mainMenuAppliances();

        secondMenu.menuCoffeeMakers();

        //lego advertising
        try {
            WebElement legoAdvertising = browserWait.until
                    (ExpectedConditions.elementToBeClickable(By.id("l-exponea-close")));
            legoAdvertising.click();
        } catch (Exception e) {
            System.out.println("Lego advertising not found");
        }

        productPage.coffeeMaker();

        //lego advertising
        try {
            WebElement legoAdvertising = browserWait.until
                    (ExpectedConditions.elementToBeClickable(By.id("l-exponea-close")));
            legoAdvertising.click();
        } catch (Exception e) {
            System.out.println("Lego advertising not found");
        }

        //variable for expected name of item
        var expectedName = cartPage.getProductExpectedName(0);

        productPage.addToCart();

        cartPage.open();

        //variable for actual value
        var actualName = browserWait.until
                        (ExpectedConditions.elementToBeClickable
                                (By.cssSelector(".cart-overview-item-title")))
                .getText();

        //variable for actual price
        var priceOne = browserWait.until
                (ExpectedConditions.presenceOfElementLocated
                        (By.cssSelector(".cart-layout__summary-with-vat.cart-layout__total_price")))
                .getText();
        priceOne = priceOne.replaceAll("\\D", "");

        int priceOneItem = Integer.parseInt(priceOne);


        WebElement counter= browser.findElements(By.cssSelector(".article-counter__input")).get(2);
        counter.click();

        //counter.clear();
        counter.sendKeys("2");

        //variable for actual price
        var priceTwo = browserWait.until
                        (ExpectedConditions.presenceOfElementLocated
                                (By.cssSelector(".cart-layout__summary-with-vat.cart-layout__total_price")))
                .getText();
        priceTwo = priceTwo.replaceAll("\\D", "");
        int priceTwoItem = Integer.parseInt(priceTwo);

        Assertions.assertEquals
                (expectedName, actualName);
        Assertions.assertEquals
                (priceOneItem * 2, priceTwoItem);
    }

    @Test
    void cartOperations() {

        cartPage.open();
        cartPage.goBack();
    }
}



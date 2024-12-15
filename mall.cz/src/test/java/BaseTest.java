import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseTest {
    WebDriver browser = WebDriverManager.firefoxdriver()
            .create();

    @BeforeEach
    void beforeTest() {

        browser.get("https://mall.cz");
        browser.manage().window().fullscreen();

        WebElement cookiesAcceptButton = browser.findElement
                (By.cssSelector(".legal-consent__button-container"));
        cookiesAcceptButton.click();
        }
}

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class MainMenu {
    WebDriver browser;

    //menu inicialization
    public MainMenu(WebDriver browser) {
        this.browser = browser;
    }

    //click on Appliances
    void MainMenuAppliances() {
        browser.findElement(By.cssSelector(".desktop-menu__item-title")).click();
    }
}

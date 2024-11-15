import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

    public class ProductSelection {
        WebDriver browser;

        //browser inicialization
        public ProductSelection(WebDriver browser) {
            this.browser = browser;
        }

        void ShowMoreAboutProduct () {
            browser.findElement(By.cssSelector("description-accordion__open")).click();
        }

        void SelectPopularProduct (int index) {
            browser.findElements(By.cssSelector("bs__name")).get(index).click();
        }

        void ShowMorePopularProducts () {
            browser.findElement(By.cssSelector("bs__show-more-link")).click();
        }

    }
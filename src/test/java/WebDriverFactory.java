import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {

    public static WebDriver createFirefoxWebDriver(String webdriverPath) {

        System.setProperty("webdriver.gecko.driver", webdriverPath);
        FirefoxOptions options = new FirefoxOptions();

        return new FirefoxDriver(options);
    }
}

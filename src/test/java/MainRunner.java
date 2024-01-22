import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainRunner {
    private static final Logger LOGGER = Logger.getLogger(MainRunner.class.getName());

    public static void main(String[] args) {
        Properties properties = ConfigurationManager.loadProperties();
        if (properties == null) {
            LOGGER.log(Level.SEVERE, "Konnte die Konfigurationsdatei nicht laden");
            return;
        }

        String webdriverPath = properties.getProperty("webdriverPath");
        String testUrl = properties.getProperty("testUrl");

        WebDriver driver = WebDriverFactory.createFirefoxWebDriver(webdriverPath);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get(testUrl);

            List<User> users = Arrays.asList(
                    new User(properties.getProperty("username1"), properties.getProperty("password1")),
                    new User(properties.getProperty("username2"), properties.getProperty("password2"))
            );

            FormFiller formFiller = new FormFiller(driver, wait);
            ScreenshotTaker screenshotTaker = new ScreenshotTaker(driver);

            for (User user : users) {
                formFiller.fillForm(user);
                screenshotTaker.takeScreenshot("screenshot_" + user.getUsername() + ".png");
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Ein Fehler ist aufgetreten", e);
        } finally {
            driver.quit();
        }
    }
}
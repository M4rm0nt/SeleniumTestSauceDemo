import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScreenshotTaker {
    private WebDriver driver;

    private static final Logger LOGGER = Logger.getLogger(ScreenshotTaker.class.getName());

    public ScreenshotTaker(WebDriver driver) {
        this.driver = driver;
    }

    public void takeScreenshot(String filename) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(filename));
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Fehler beim Erstellen des Screenshots", e);
        }
    }
}
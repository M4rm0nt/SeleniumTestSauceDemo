import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FormFiller {
    private WebDriver driver;
    private WebDriverWait wait;

    private static final Logger LOGGER = Logger.getLogger(FormFiller.class.getName());

    public FormFiller(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void fillForm(User user) {
        try {
            WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
            WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
            WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']")));

            usernameInput.clear();
            passwordInput.clear();

            usernameInput.sendKeys(user.getUsername());
            passwordInput.sendKeys(user.getPassword());
            submitButton.click();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Fehler beim Ausfüllen des Formulars", e);
        }
    }
}

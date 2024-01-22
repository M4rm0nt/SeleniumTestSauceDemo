import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfigurationManager {

    private static final Logger LOGGER = Logger.getLogger(ConfigurationManager.class.getName());
    public static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream input = ConfigurationManager.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                LOGGER.log(Level.SEVERE, "Konnte die Konfigurationsdatei nicht finden");
                return null;
            }
            properties.load(input);
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Ein Fehler ist aufgetreten", ex);
            return null;
        }
        return properties;
    }
}
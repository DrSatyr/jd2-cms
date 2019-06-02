package by.itacademy.pinchuk.jd2.util;

import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@UtilityClass
@Log4j
public class AppConfig {

    private static final String CONFIG_FILE_NAME = "app.properties";
    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream resourceAsStream = AppConfig.class.getClassLoader().getResourceAsStream(CONFIG_FILE_NAME)) {
                PROPERTIES.load(resourceAsStream);
        } catch (IOException e) {
             log.fatal(e.getMessage(), new IOException(e.getMessage()));
        }
    }

    public String get(String key) {
        return PROPERTIES.getProperty(key);
    }
}

package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesUtil {
    private static final Properties PROPERTIES = new Properties();
    static final Logger logger = LoggerFactory.getLogger("PropertiesUtil");

    static {
        loadProperties();
    }

    private PropertiesUtil() {
    }

    public static String get(String key){
        return  PROPERTIES.getProperty(key);
    }

    private static void loadProperties(){
        try (InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            logger.error("Ошибка при введении логина или пароля, проверьте properties");
            throw new RuntimeException(e);
        }
    }
}

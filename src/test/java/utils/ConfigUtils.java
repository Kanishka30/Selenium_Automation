package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {
    private static Properties properties = new Properties();

    static {
        try (InputStream input = ConfigUtils.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("config.properties file not found in classpath");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties file", e);
        }
    }

    // Generic method to get any property
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    // Specific method to get email
    public static String getEmail() {
        return getProperty("email");
    }

    // Specific method to get password
    public static String getPassword() {
        return getProperty("password");
    }
    public static String geturl(){
        return getProperty("base_url");
    }
}
package de.schlueter.cacher;

import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class Config {
    public static String GetAPIKey() {
        try (InputStream input = Config.class.getClassLoader().getResourceAsStream(
                "config.properties")) {
            Properties prop = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find application.properties");
                return "";
            }
            prop.load(input);
            return prop.getProperty("apiKey");
        } catch (Exception e) {
            log.error("Error while reading the api key from the properties file: " + e.getMessage());
            return "";
        }
    }

}

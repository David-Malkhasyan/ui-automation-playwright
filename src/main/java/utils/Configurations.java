package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configurations {
    static Properties props;
    static FileInputStream inputStream;
    public static String BROWSER;
    public static Boolean HEADLESS;
    public static String URL;

    static {
        try {
            props = new Properties();
            inputStream = new FileInputStream("src/main/resources/configurations.properties");
            props.load(inputStream);
            BROWSER = System.getProperty("browser", props.getProperty("browser"));
            HEADLESS = Boolean.parseBoolean(System.getProperty("headless", props.getProperty("headless")));
            URL = System.getProperty("url", props.getProperty("url"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

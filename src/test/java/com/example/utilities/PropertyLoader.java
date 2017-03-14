package com.example.utilities;

/*Class for getting values from the property file*/

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;


public class PropertyLoader {
    private static Properties props = new Properties();

    static {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try (InputStream resourceStream = loader.getResourceAsStream("environment.properties")) {
            props.load(resourceStream);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvalidPropertiesFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Load property from src/main/resources/environment.properties file.
     *
     * @param propertyName the property name
     * @return the string value
     */
    public static String loadProperty(String propertyName) {
        String property = props.getProperty(propertyName);
        if (property == null) {
            return "";
        } else {
            return property;
        }
    }
}

package by.courses.nattiliana.resource;

import by.courses.nattiliana.constants.ConfigConstants;

import java.util.ResourceBundle;

public class ConfigurationManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle(ConfigConstants.CONFIG_SOURCE);

    // класс извлекает информацию из файла config.properties
    private ConfigurationManager() {
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
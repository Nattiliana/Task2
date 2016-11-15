package by.courses.nattiliana.resource;

import by.courses.nattiliana.constants.ConfigConstants;

import java.util.ResourceBundle;

public class MessageManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle(ConfigConstants.MESSAGES_SOURCE);

    // класс извлекает информацию из файла messages. properties
    private MessageManager() {
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
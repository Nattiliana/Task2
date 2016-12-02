package by.courses.nattiliana.command;

import by.courses.nattiliana.constants.ConfigConstants;
import by.courses.nattiliana.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return ConfigurationManager.getProperty(ConfigConstants.LOGIN_PAGE_PATH);
    }
}
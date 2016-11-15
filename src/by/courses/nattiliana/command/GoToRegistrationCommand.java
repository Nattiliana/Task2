package by.courses.nattiliana.command;

import by.courses.nattiliana.constants.ConfigConstants;
import by.courses.nattiliana.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Nataly on 15.11.2016.
 * ${VERSION}
 */
public class GoToRegistrationCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty(ConfigConstants.REGISTRATION_PAGE_PATH);
        return page;
    }
}

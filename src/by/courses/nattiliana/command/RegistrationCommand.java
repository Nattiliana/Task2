package by.courses.nattiliana.command;

import by.courses.nattiliana.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Nataly on 11.11.2016.
 * ${VERSION}
 */
public class RegistrationCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.registration");
        return page;
    }
}

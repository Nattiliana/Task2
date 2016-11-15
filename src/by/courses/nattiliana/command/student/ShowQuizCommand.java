package by.courses.nattiliana.command.student;

import by.courses.nattiliana.command.ActionCommand;
import by.courses.nattiliana.constants.ConfigConstants;
import by.courses.nattiliana.constants.Parameters;
import by.courses.nattiliana.filter.ClientType;
import by.courses.nattiliana.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Nataly on 15.11.2016.
 * ${VERSION}
 */
public class ShowQuizCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        HttpSession httpSession = request.getSession();
        ClientType clientType = (ClientType)httpSession.getAttribute(Parameters.USERROLE);
        if (clientType == ClientType.USER) {
            page = ConfigurationManager.getProperty(ConfigConstants.QUIZ_PAGE_PATH);
        }
        else {
            page = ConfigurationManager.getProperty(ConfigConstants.LOGIN_PAGE_PATH);
            httpSession.invalidate();
        }
        return page;
    }
}

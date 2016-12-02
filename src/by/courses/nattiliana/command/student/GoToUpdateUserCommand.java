package by.courses.nattiliana.command.student;

import by.courses.nattiliana.command.ActionCommand;
import by.courses.nattiliana.constants.ConfigConstants;
import by.courses.nattiliana.constants.MessageConstants;
import by.courses.nattiliana.constants.Parameters;
import by.courses.nattiliana.dao.UserDAO;
import by.courses.nattiliana.entities.User;
import by.courses.nattiliana.filter.ClientType;
import by.courses.nattiliana.log4j.QuizLogger;
import by.courses.nattiliana.resource.ConfigurationManager;
import by.courses.nattiliana.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * Created by Nataly on 01.12.2016.
 * ${VERSION}
 */
public class GoToUpdateUserCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        HttpSession session = request.getSession();
        ClientType clientType = (ClientType) session.getAttribute(Parameters.USERROLE);
        User user = (User) session.getAttribute(Parameters.USER);
        String login = user.getLogin();
        if (clientType == ClientType.USER) {
            try {
                user = UserDAO.USER_DAO.getUserByLogin(login);
                session.setAttribute(Parameters.USER, user);
                page = ConfigurationManager.getProperty(ConfigConstants.UPDATE_STUDENT);
            } catch (SQLException e) {
                QuizLogger.logError(getClass(), e.getMessage());
                page = ConfigurationManager.getProperty(ConfigConstants.ERROR_PAGE_PATH);
                request.setAttribute(Parameters.ERROR_DATABASE, MessageManager.getProperty(MessageConstants.ERROR_DATABASE));
            }
        } else {
            page = ConfigurationManager.getProperty(ConfigConstants.LOGIN_PAGE_PATH);
            session.invalidate();
        }
        return page;
    }
}

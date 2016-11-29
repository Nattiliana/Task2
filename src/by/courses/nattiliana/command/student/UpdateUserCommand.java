package by.courses.nattiliana.command.student;

import by.courses.nattiliana.command.ActionCommand;
import by.courses.nattiliana.constants.ConfigConstants;
import by.courses.nattiliana.constants.MessageConstants;
import by.courses.nattiliana.constants.Parameters;
import by.courses.nattiliana.dao.UserDAO;
import by.courses.nattiliana.entities.User;
import by.courses.nattiliana.log4j.QuizLogger;
import by.courses.nattiliana.resource.ConfigurationManager;
import by.courses.nattiliana.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * Created by Nataly on 28.11.2016.
 * ${VERSION}
 */
public class UpdateUserCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        String login = request.getParameter(Parameters.LOGIN);
        String password = request.getParameter(Parameters.PASSWORD);
        String name = request.getParameter(Parameters.NAME);
        String surname = request.getParameter(Parameters.SURNAME);
            try {
                if (UserDAO.isAuthorized(login, password)) {
                    UserDAO.updateUser(login, name, surname);
                    HttpSession session = request.getSession(true);
                    User user = UserDAO.getUserByLogin(login);
                    session.setAttribute(Parameters.USER, user);
                    page = ConfigurationManager.getProperty(ConfigConstants.STUDENT_PAGE_PATH);
                    request.setAttribute(Parameters.UPDATE_MESSAGE,
                            MessageManager.getProperty(MessageConstants.SUCCESS_UPDATE));
                }
                else{
                    page = ConfigurationManager.getProperty(ConfigConstants.UPDATE_STUDENT);
                    request.setAttribute(Parameters.ERROR_LOGIN_OR_PASSWORD,
                            MessageManager.getProperty(MessageConstants.WRONG_LOGIN_OR_PASSWORD));
                }
            } catch (SQLException e) {
                QuizLogger.logError(getClass(), e.getMessage());
                page = ConfigurationManager.getProperty(ConfigConstants.ERROR_PAGE_PATH);
                request.setAttribute(Parameters.ERROR_DATABASE, MessageManager.getProperty(MessageConstants.ERROR_DATABASE));
            }
        return page;
    }
}

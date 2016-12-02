package by.courses.nattiliana.command;

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

public class LoginCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        String login = request.getParameter(Parameters.LOGIN);
        String password = request.getParameter(Parameters.PASSWORD);
        try {
            if (UserDAO.USER_DAO.isAuthorized(login, password)) {
                HttpSession session = request.getSession();
                User user = UserDAO.USER_DAO.getUserByLogin(login);
                ClientType clientType = UserDAO.USER_DAO.checkUserRole(login);
                session.setAttribute(Parameters.USERROLE, clientType);
                session.setAttribute(Parameters.USER, user);
                if (ClientType.USER.equals(clientType)) {
                    page = ConfigurationManager.getProperty(ConfigConstants.STUDENT_PAGE_PATH);
                } else {
                    page = ConfigurationManager.getProperty(ConfigConstants.TUTOR_PAGE_PATH);
                }
            } else {
                page = ConfigurationManager.getProperty(ConfigConstants.LOGIN_PAGE_PATH);
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

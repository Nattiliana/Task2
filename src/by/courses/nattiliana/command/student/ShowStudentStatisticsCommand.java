package by.courses.nattiliana.command.student;

import by.courses.nattiliana.command.ActionCommand;
import by.courses.nattiliana.constants.ConfigConstants;
import by.courses.nattiliana.constants.MessageConstants;
import by.courses.nattiliana.constants.Parameters;
import by.courses.nattiliana.dao.RegistrationListDAO;
import by.courses.nattiliana.entities.RegistrationList;
import by.courses.nattiliana.entities.User;
import by.courses.nattiliana.filter.ClientType;
import by.courses.nattiliana.log4j.QuizLogger;
import by.courses.nattiliana.resource.ConfigurationManager;
import by.courses.nattiliana.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * Created by Nataly on 15.11.2016.
 * ${VERSION}
 */
public class ShowStudentStatisticsCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        HttpSession httpSession = request.getSession();
        ClientType clientType = (ClientType) httpSession.getAttribute(Parameters.USERROLE);
        if (clientType == ClientType.USER) {
            User user = (User) httpSession.getAttribute(Parameters.USER);
            String login = user.getLogin();
            try {
                RegistrationList list = RegistrationListDAO.REGISTRATION_LIST_DAO.getListByLogin(login);
                request.setAttribute(Parameters.LOGIN, list.getStudent());
                request.setAttribute(Parameters.ANSWERS, list.getAmountOfRightAnswers());
                page = ConfigurationManager.getProperty(ConfigConstants.STUDENT_STATISTICS_PAGE_PATH);
            } catch (SQLException e) {
                QuizLogger.logError(getClass(), e.getMessage());
                page = ConfigurationManager.getProperty(ConfigConstants.ERROR_PAGE_PATH);
                request.setAttribute(Parameters.ERROR_DATABASE, MessageManager.getProperty(MessageConstants.ERROR_DATABASE));
            }
        } else {
            page = ConfigurationManager.getProperty(ConfigConstants.LOGIN_PAGE_PATH);
            httpSession.invalidate();
        }
        return page;
    }
}

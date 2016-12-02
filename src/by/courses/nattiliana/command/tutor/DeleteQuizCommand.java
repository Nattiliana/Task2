package by.courses.nattiliana.command.tutor;

import by.courses.nattiliana.command.ActionCommand;
import by.courses.nattiliana.constants.ConfigConstants;
import by.courses.nattiliana.constants.MessageConstants;
import by.courses.nattiliana.constants.Parameters;
import by.courses.nattiliana.dao.QuizDAO;
import by.courses.nattiliana.filter.ClientType;
import by.courses.nattiliana.log4j.QuizLogger;
import by.courses.nattiliana.resource.ConfigurationManager;
import by.courses.nattiliana.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Nataly on 15.11.2016.
 * ${VERSION}
 */
public class DeleteQuizCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        HttpSession httpSession = request.getSession();
        ClientType clientType = (ClientType) httpSession.getAttribute(Parameters.USERROLE);
        if (clientType == ClientType.ADMINISTRATOR) {
            try {
                if (request.getParameter(Parameters.DELETE) != null) {
                    String[] ids = request.getParameterValues(Parameters.DELETE);
                        for (int i = 0; i < ids.length; i++) {
                            QuizDAO.deleteQuiz(Integer.parseInt(ids[i]));
                        }
                    request.setAttribute(Parameters.DELETE_MESSAGE, MessageManager.getProperty(MessageConstants.SUCCESS_DELETE));
                    page = ConfigurationManager.getProperty(ConfigConstants.TUTOR_PAGE_PATH);
                    QuizLogger.logInfo(getClass(), MessageManager.getProperty(MessageConstants.SUCCESS_DELETE));
                } else if (!((List) httpSession.getAttribute(Parameters.QUIZ_LIST)).isEmpty()) {
                    request.setAttribute(Parameters.ERROR_EMPTY_CHOICE, MessageManager.getProperty(MessageConstants.EMPTY_CHOICE));
                    page = ConfigurationManager.getProperty(ConfigConstants.DELETE_QUIZ_PAGE_PATH);
                } else {
                    request.setAttribute(Parameters.ERROR_EMPTY_LIST, MessageManager.getProperty(MessageConstants.EMPTY_LIST));
                    page = ConfigurationManager.getProperty(ConfigConstants.DELETE_QUIZ_PAGE_PATH);
                }
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

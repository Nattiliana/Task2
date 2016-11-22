package by.courses.nattiliana.command.tutor;

import by.courses.nattiliana.command.ActionCommand;
import by.courses.nattiliana.constants.ConfigConstants;
import by.courses.nattiliana.constants.MessageConstants;
import by.courses.nattiliana.constants.Parameters;
import by.courses.nattiliana.dao.QuestionDAO;
import by.courses.nattiliana.dao.QuizDAO;
import by.courses.nattiliana.dao.SubjectDAO;
import by.courses.nattiliana.entities.Question;
import by.courses.nattiliana.entities.Quiz;
import by.courses.nattiliana.entities.Subject;
import by.courses.nattiliana.filter.ClientType;
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
            if (request.getParameter("deleteId") != null) {
                int id = Integer.valueOf(request.getParameter("deleteId"));
                try {
                    QuizDAO.deleteQuiz(id);
                    List<Quiz> quizList = QuizDAO.findAll();
                    httpSession.setAttribute(Parameters.QUIZ_LIST, quizList);
                    page = ConfigurationManager.getProperty(ConfigConstants.DELETE_QUIZ_PAGE_PATH);
                } catch (SQLException e) {
                    page = ConfigurationManager.getProperty(ConfigConstants.ERROR_PAGE_PATH);
                    request.setAttribute(Parameters.ERROR_DATABASE, MessageManager.getProperty(MessageConstants.ERROR_DATABASE));
                }
            } else if (!((List) httpSession.getAttribute(Parameters.QUIZ_LIST)).isEmpty()) {
                request.setAttribute(Parameters.ERROR_EMPTY_CHOICE, MessageManager.getProperty(MessageConstants.EMPTY_CHOICE));
                page = ConfigurationManager.getProperty(ConfigConstants.DELETE_QUIZ_PAGE_PATH);
            } else {
                request.setAttribute(Parameters.ERROR_EMPTY_LIST, MessageManager.getProperty(MessageConstants.EMPTY_LIST));
                page = ConfigurationManager.getProperty(ConfigConstants.DELETE_QUIZ_PAGE_PATH);
            }

        } else {
            page = ConfigurationManager.getProperty(ConfigConstants.LOGIN_PAGE_PATH);
            httpSession.invalidate();
        }
        return page;
    }
}

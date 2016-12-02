package by.courses.nattiliana.command.tutor;

import by.courses.nattiliana.command.ActionCommand;
import by.courses.nattiliana.constants.ConfigConstants;
import by.courses.nattiliana.constants.MessageConstants;
import by.courses.nattiliana.constants.Parameters;
import by.courses.nattiliana.dao.QuestionDAO;
import by.courses.nattiliana.dao.QuizDAO;
import by.courses.nattiliana.entities.Quiz;
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
public class CreateQuizCommand implements ActionCommand {

    private static String quizName;
    private static int subjectId;

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        HttpSession httpSession = request.getSession();
        ClientType clientType = (ClientType) httpSession.getAttribute(Parameters.USERROLE);
        if (clientType == ClientType.ADMINISTRATOR) {
            if (request.getParameter(Parameters.SUBJECT) != null) {
                subjectId = Integer.valueOf(request.getParameter(Parameters.SUBJECT));
                quizName = request.getParameter(Parameters.QUIZ_NAME);
                int questionId = Integer.valueOf(request.getParameter(Parameters.QUESTION));
                try {
                    addQuiz();
                    QuestionDAO.QUESTION_DAO.addQuestion(questionId, subjectId);
                    page = ConfigurationManager.getProperty(ConfigConstants.TUTOR_PAGE_PATH);
                    request.setAttribute(Parameters.ADD_MESSAGE,
                            MessageManager.getProperty(MessageConstants.SUCCESS_ADD));
                } catch (SQLException e) {
                    QuizLogger.logError(getClass(), e.getMessage());
                    page = ConfigurationManager.getProperty(ConfigConstants.ERROR_PAGE_PATH);
                    request.setAttribute(Parameters.ERROR_DATABASE, MessageManager.getProperty(MessageConstants.ERROR_DATABASE));
                }
            } else if (!((List) httpSession.getAttribute(Parameters.SUBJECT_LIST)).isEmpty()) {
                request.setAttribute(Parameters.ERROR_EMPTY_CHOICE, MessageManager.getProperty(MessageConstants.EMPTY_CHOICE));
                page = ConfigurationManager.getProperty(ConfigConstants.CREATE_QUIZ_PAGE_PATH);
            } else {
                request.setAttribute(Parameters.ERROR_EMPTY_LIST, MessageManager.getProperty(MessageConstants.EMPTY_LIST));
                page = ConfigurationManager.getProperty(ConfigConstants.CREATE_QUIZ_PAGE_PATH);
            }
        } else {
            page = ConfigurationManager.getProperty(ConfigConstants.LOGIN_PAGE_PATH);
            httpSession.invalidate();
        }
        return page;
    }

    private void addQuiz() throws SQLException {
        Quiz quiz = new Quiz();
        quiz.setQuizName(quizName);
        quiz.setSubjectId(subjectId);
        QuizDAO.QUIZ_DAO.createEntity(quiz);
    }
}

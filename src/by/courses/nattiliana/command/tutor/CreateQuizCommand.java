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
public class CreateQuizCommand implements ActionCommand {

    private static String quizName;

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        quizName = request.getParameter(Parameters.QUIZ_NAME);
        HttpSession httpSession = request.getSession();
        ClientType clientType = (ClientType) httpSession.getAttribute(Parameters.USERROLE);
        if (clientType == ClientType.ADMINISTRATOR) {
            try {
                List<Subject> subjectList = SubjectDAO.findAll();
                httpSession.setAttribute(Parameters.SUBJECT_LIST, subjectList);
                List<Question> questionList = QuestionDAO.findAll();
                httpSession.setAttribute(Parameters.QUESTION_LIST, questionList);
                //addQuiz();
                //if (isNotEmpty()) {
                page = ConfigurationManager.getProperty(ConfigConstants.CREATE_QUIZ_PAGE_PATH);
                request.setAttribute(Parameters.REGISTRATION_MESSAGE,
                        MessageManager.getProperty(MessageConstants.SUCCESS_REGISTRATION));
                //} else {
                //    page = ConfigurationManager.getProperty(ConfigConstants.CREATE_QUIZ_PAGE_PATH);
                //    request.setAttribute(Parameters.ERROR_USER_EXISTS,
                //           MessageManager.getProperty(MessageConstants.USER_EXISTS));
                //}

            } catch (SQLException e) {
                page = ConfigurationManager.getProperty(ConfigConstants.ERROR_PAGE_PATH);
                request.setAttribute(Parameters.ERROR_DATABASE, MessageManager.getProperty(MessageConstants.ERROR_DATABASE));
            }
        } else {
            page = ConfigurationManager.getProperty(ConfigConstants.LOGIN_PAGE_PATH);
            httpSession.invalidate();
        }
        return page;
    }

    private boolean isNotEmpty() {
        boolean isEmpty = false;
        if (!quizName.isEmpty()) {
            isEmpty = true;
        }
        return isEmpty;
    }

    private void addQuiz() throws SQLException {
        Quiz quiz = new Quiz();
        quiz.setQuizName(quizName);
        quiz.setSubjectId(1);
        QuizDAO.createEntity(quiz);
    }
}

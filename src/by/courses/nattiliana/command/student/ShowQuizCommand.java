package by.courses.nattiliana.command.student;

import by.courses.nattiliana.command.ActionCommand;
import by.courses.nattiliana.constants.ConfigConstants;
import by.courses.nattiliana.constants.MessageConstants;
import by.courses.nattiliana.constants.Parameters;
import by.courses.nattiliana.dao.AnswerDAO;
import by.courses.nattiliana.dao.QuestionDAO;
import by.courses.nattiliana.entities.Answer;
import by.courses.nattiliana.entities.Question;
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
public class ShowQuizCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        HttpSession httpSession = request.getSession();
        ClientType clientType = (ClientType) httpSession.getAttribute(Parameters.USERROLE);
        if (clientType == ClientType.USER) {
            try {
                if (request.getParameter(Parameters.QUESTION_IN_QUIZ) != null) {
                    int id = Integer.valueOf(request.getParameter(Parameters.QUESTION_IN_QUIZ));
                    List<Question> questions = QuestionDAO.findAllById(id);
                    httpSession.setAttribute(Parameters.QUESTION_LIST, questions);
                    for (Question item : questions){
                        int questionId = item.getId();
                        List<Answer> answers = AnswerDAO.findAllById(questionId);
                        httpSession.setAttribute(Parameters.ANSWER_LIST, answers);
                    }
                    page = ConfigurationManager.getProperty(ConfigConstants.QUIZ_NEXT_PAGE_PATH);
                } else {
                    request.setAttribute(Parameters.ERROR_EMPTY_CHOICE, MessageManager.getProperty(MessageConstants.EMPTY_CHOICE));
                    page = ConfigurationManager.getProperty(ConfigConstants.QUIZ_PAGE_PATH);
                }
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
}

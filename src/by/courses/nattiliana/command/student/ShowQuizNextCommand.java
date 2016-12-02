package by.courses.nattiliana.command.student;

import by.courses.nattiliana.command.ActionCommand;
import by.courses.nattiliana.constants.ConfigConstants;
import by.courses.nattiliana.constants.MessageConstants;
import by.courses.nattiliana.constants.Parameters;
import by.courses.nattiliana.dao.AnswerDAO;
import by.courses.nattiliana.dao.QuestionDAO;
import by.courses.nattiliana.dao.RegistrationListDAO;
import by.courses.nattiliana.dao.UserDAO;
import by.courses.nattiliana.entities.Answer;
import by.courses.nattiliana.entities.Question;
import by.courses.nattiliana.entities.RegistrationList;
import by.courses.nattiliana.entities.User;
import by.courses.nattiliana.filter.ClientType;
import by.courses.nattiliana.resource.ConfigurationManager;
import by.courses.nattiliana.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Nataly on 25.11.2016.
 * ${VERSION}
 */
public class ShowQuizNextCommand implements ActionCommand {

    private int count;
    private String login;
    int quizId;

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        HttpSession httpSession = request.getSession();
        ClientType clientType = (ClientType) httpSession.getAttribute(Parameters.USERROLE);
        if (clientType == ClientType.USER) {
            User user = (User) httpSession.getAttribute(Parameters.USER);
            login = user.getLogin();
            try {
                if (request.getParameter(Parameters.ANSWER) != null) {
                    int id = Integer.valueOf(request.getParameter(Parameters.ANSWER));
                    if (AnswerDAO.isChecked(id)) {
                        count++;
                    }
                    saveAnswers();
                    request.setAttribute(Parameters.END_QUIZ_MESSAGE, MessageManager.getProperty(MessageConstants.QUIZ_END));
                    page = ConfigurationManager.getProperty(ConfigConstants.STUDENT_PAGE_PATH);
                } else {
                    request.setAttribute(Parameters.ERROR_EMPTY_CHOICE, MessageManager.getProperty(MessageConstants.EMPTY_CHOICE));
                    page = ConfigurationManager.getProperty(ConfigConstants.QUIZ_NEXT_PAGE_PATH);
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

    private void saveAnswers() throws SQLException {
        RegistrationList list = new RegistrationList();
        list.setStudent(login);
        list.setAmountOfRightAnswers(count);
        RegistrationListDAO.createEntity(list);
    }
}

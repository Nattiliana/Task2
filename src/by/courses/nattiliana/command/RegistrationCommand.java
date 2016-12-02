package by.courses.nattiliana.command;

import by.courses.nattiliana.constants.ConfigConstants;
import by.courses.nattiliana.constants.MessageConstants;
import by.courses.nattiliana.constants.Parameters;
import by.courses.nattiliana.dao.UserDAO;
import by.courses.nattiliana.entities.User;
import by.courses.nattiliana.resource.ConfigurationManager;
import by.courses.nattiliana.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by Nataly on 11.11.2016.
 * ${VERSION}
 */
public class RegistrationCommand implements ActionCommand {

    private static String login;
    private static String password;
    private static String name;
    private static String surname;

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        login = request.getParameter(Parameters.LOGIN);
        password = request.getParameter(Parameters.PASSWORD);
        name = request.getParameter(Parameters.NAME);
        surname = request.getParameter(Parameters.SURNAME);
        try {
            if (!(UserDAO.USER_DAO.isExists(login))) {
                registrate();
                page = ConfigurationManager.getProperty(ConfigConstants.REGISTRATION_PAGE_PATH);
                request.setAttribute(Parameters.REGISTRATION_MESSAGE,
                        MessageManager.getProperty(MessageConstants.SUCCESS_REGISTRATION));
            }
            else{
                page = ConfigurationManager.getProperty(ConfigConstants.REGISTRATION_PAGE_PATH);
                request.setAttribute(Parameters.ERROR_USER_EXISTS,
                        MessageManager.getProperty(MessageConstants.USER_EXISTS));
            }
        } catch (SQLException e) {
            page = ConfigurationManager.getProperty(ConfigConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.ERROR_DATABASE, MessageManager.getProperty(MessageConstants.ERROR_DATABASE));
        }
        return page;
    }

    private void registrate() throws SQLException {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setName(name);
        user.setSurname(surname);
        UserDAO.USER_DAO.createEntity(user);
    }
}


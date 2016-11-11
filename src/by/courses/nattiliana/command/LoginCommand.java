package by.courses.nattiliana.command;

import by.courses.nattiliana.filter.ClientType;
import by.courses.nattiliana.logic.LoginLogic;
import by.courses.nattiliana.resource.ConfigurationManager;
import by.courses.nattiliana.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        // извлечение из запроса логина и пароля
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        // проверка логина и пароля
        if (LoginLogic.checkAdminLogin(login, pass)) {
            request.setAttribute("user", login);
            HttpSession session = request.getSession(true);
            session.setAttribute("userType", ClientType.ADMINISTRATOR);
            // определение пути к admin.jsp
            page = ConfigurationManager.getProperty("path.page.admin");
        } else if (LoginLogic.checkUserLogin(login, pass)) {
            request.setAttribute("user", login);
            HttpSession session = request.getSession(true);
            session.setAttribute("userType", ClientType.USER);
            // определение пути к user.jsp
            page = ConfigurationManager.getProperty("path.page.user");
        } else {
            request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
            request.getSession().setAttribute("userType", ClientType.GUEST);
            page = ConfigurationManager.getProperty("path.page.login");
        }
        return page;
    }
}

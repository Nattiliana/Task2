package by.courses.nattiliana.command;

import by.courses.nattiliana.constants.ConfigConstants;
import by.courses.nattiliana.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
 /* в случае ошибки или прямого обращения к контроллеру
  * переадресация на страницу ввода логина */
        String page = ConfigurationManager.getProperty(ConfigConstants.LOGIN_PAGE_PATH);
        return page;
    }
}
package by.courses.nattiliana.command.factory;

import by.courses.nattiliana.command.ActionCommand;
import by.courses.nattiliana.command.EmptyCommand;
import by.courses.nattiliana.command.client.CommandEnum;
import by.courses.nattiliana.constants.MessageConstants;
import by.courses.nattiliana.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
  public ActionCommand defineCommand(HttpServletRequest request) {
    ActionCommand current = new EmptyCommand();
    // извлечение имени команды из запроса
    String action = request.getParameter("command");
    if (action == null || action.isEmpty()) {
      // если команда не задана в текущем запросе
      return current;
    }
    // получение объекта, соответствующего команде
    try {
      CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());

      current = currentEnum.getCurrentCommand();
    } catch (IllegalArgumentException e) {
      request.setAttribute("wrongAction", action + MessageManager.getProperty(MessageConstants.COMMAND_NOT_FOUND));
    }
    return current;
  }
}
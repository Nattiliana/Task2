package by.courses.nattiliana.servlet;

import by.courses.nattiliana.command.ActionCommand;
import by.courses.nattiliana.command.factory.ActionFactory;
import by.courses.nattiliana.constants.ConfigConstants;
import by.courses.nattiliana.constants.MessageConstants;
import by.courses.nattiliana.resource.ConfigurationManager;
import by.courses.nattiliana.resource.MessageManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/controller")
public class Controller extends HttpServlet {
  /*  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);
        page = command.execute(request);
        if (page != null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } else {
            page = ConfigurationManager.getProperty(ConfigConstants.LOGIN_PAGE_PATH);
            request.getSession().setAttribute("nullPage", MessageManager.getProperty(MessageConstants.PAGE_NOT_FOUND));
            response.sendRedirect(request.getContextPath() + page);
        }
    }*/

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;

        ActionFactory actionFactory = new ActionFactory();
        ActionCommand command = actionFactory.defineCommand(request);
        page = command.execute(request);
        if (page != null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } else {
            page = ConfigurationManager.getProperty(ConfigConstants.LOGIN_PAGE_PATH);
            response.sendRedirect(request.getContextPath() + page);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}
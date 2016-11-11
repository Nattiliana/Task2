package by.courses.nattiliana.servlet;

/**
 * Created by Nataly on 05.11.2016.
 * ${VERSION}
 */

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/authentication")
public class Authentication extends HttpServlet {
    private ServletConfig config;

    public void init(ServletConfig config)
            throws ServletException {
        this.config = config;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Connection connection = null;
        ResultSet rs;
        String userName = new String("");
        String password = new String("");
        String connectionURL = "jdbc:mysql://localhost:3306/quizdb";
        response.setContentType("text/html");
        try {
            //Загружаем драйвер БД
            Class.forName("com.mysql.jdbc.Driver");
// Получаем подключение к базе данных
            connection = DriverManager.getConnection(connectionURL, "root", "1111");
            String sql = "select email,password from users";
            Statement s = connection.createStatement();
            s.executeQuery(sql);
            rs = s.getResultSet();
            while (rs.next()) {
                userName = rs.getString("email");
                password = rs.getString("password");
            }
            rs.close();
            s.close();
        } catch (Exception e) {
            System.out.println("Exception is ;" + e);
        }
        if (userName.equals(request.getParameter("email")) &&
                password.equals(request.getParameter("pass"))) {
            out.println("User Authenticated");
        } else {
            out.println("You are not an authentic person");
        }
    }
}

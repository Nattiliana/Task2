/*
package by.courses.nattiliana;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;


*/
/**
 * Created by Nataly on 04.11.2016.
 * ${VERSION}
 *//*


public class Main {

    public static void main(String[] args) {
        try {
            InitialContext initContext = new InitialContext();
            DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/quizdb");
            Connection conn = ds.getConnection();
            conn.createStatement().execute("INSERT INTO users (name, surname, email, password)  VALUES ('Johnny', 'Snow', 'qwerty1@gmail.com', 'password')");
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
*/

package by.courses.nattiliana.connectionPool;

import by.courses.nattiliana.constants.ConfigConstants;

import javax.naming.Context;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Nataly on 10.11.2016.
 * ${VERSION}
 */
public enum ConnectionPool {
    INSTANCE;

    private DataSource dataSource;

    ConnectionPool(){
        try {
            Context initialContext = new InitialContext();
            dataSource = (DataSource) initialContext.lookup(ConfigConstants.DATABASE_SOURCE);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

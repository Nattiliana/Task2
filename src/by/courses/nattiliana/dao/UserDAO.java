package by.courses.nattiliana.dao;

import by.courses.nattiliana.constants.ColumnNames;
import by.courses.nattiliana.constants.SQLRequests;
import by.courses.nattiliana.constants.UserRole;
import by.courses.nattiliana.connectionPool.ConnectionPool;
import by.courses.nattiliana.entities.User;
import by.courses.nattiliana.filter.ClientType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nataly on 14.11.2016.
 * ${VERSION}
 */
public class UserDAO {

    public static List<User> findAll() throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQLRequests.GET_ALL_STUDENTS);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<User> userList = new ArrayList<>();
        while (resultSet.next()){
            User user = new User();
            user.setLogin(resultSet.getString(ColumnNames.USER_LOGIN));
            user.setPassword(resultSet.getString(ColumnNames.USER_PASSWORD));
            user.setName(resultSet.getString(ColumnNames.USER_NAME));
            user.setSurname(resultSet.getString(ColumnNames.USER_SURNAME));
            userList.add(user);
        }
        ConnectionPool.INSTANCE.closeConnection(connection);
        return userList;
    }

    public static boolean isAuthorized(String login, String password) throws SQLException {
        boolean isUser = false;
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQLRequests.CHECK_AUTHORIZATION);
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            isUser = true;
        }
        ConnectionPool.INSTANCE.closeConnection(connection);
        return isUser;
    }

    public static boolean isExists(String login) throws SQLException {
        boolean isExistsUser = false;
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQLRequests.CHECK_LOGIN);
        preparedStatement.setString(1, login);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            isExistsUser = true;
        }
        ConnectionPool.INSTANCE.closeConnection(connection);
        return isExistsUser;
    }

    public static void createEntity(User user) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQLRequests.ADD_STUDENT);
        preparedStatement.setString(1, user.getLogin());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getName());
        preparedStatement.setString(4, user.getSurname());
        preparedStatement.execute();
        ConnectionPool.INSTANCE.closeConnection(connection);
    }

    public static ClientType checkUserRole(String login) throws SQLException {
        ClientType clientType = null;
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQLRequests.CHECK_USER_ROLE);
        preparedStatement.setString(1, login);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            if (UserRole.STUDENT == resultSet.getInt(ColumnNames.USER_ROLE)){
                clientType = ClientType.USER;
            } else {
                clientType = ClientType.ADMINISTRATOR;
            }
        }
        ConnectionPool.INSTANCE.closeConnection(connection);
        return clientType;
    }

    public static User getUserByLogin(String login) throws SQLException{
        User user = null;
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQLRequests.GET_USER_BY_LOGIN);
        preparedStatement.setString(1, login);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            user = new User();
            user.setLogin(resultSet.getString(ColumnNames.USER_LOGIN));
            user.setPassword(resultSet.getString(ColumnNames.USER_PASSWORD));
            user.setName(resultSet.getString(ColumnNames.USER_NAME));
            user.setSurname(resultSet.getString(ColumnNames.USER_SURNAME));
            user.setUserRole(resultSet.getInt(ColumnNames.USER_ROLE));
        }
        ConnectionPool.INSTANCE.closeConnection(connection);
        return user;
    }

    public static void updateUser(String login, String name, String surname) throws SQLException{
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.UPDATE_USER);
        statement.setString(1, name);
        statement.setString(2, surname);
        statement.setString(3, login);
        statement.executeUpdate();
        ConnectionPool.INSTANCE.closeConnection(connection);
    }

    public static void deleteUser(String login) throws SQLException{
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.DELETE_USER);
        statement.setString(1, login);
        statement.executeUpdate();
        ConnectionPool.INSTANCE.closeConnection(connection);
    }
}

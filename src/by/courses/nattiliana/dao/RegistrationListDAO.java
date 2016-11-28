package by.courses.nattiliana.dao;

import by.courses.nattiliana.connectionPool.ConnectionPool;
import by.courses.nattiliana.constants.ColumnNames;
import by.courses.nattiliana.constants.SQLRequests;
import by.courses.nattiliana.entities.RegistrationList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nataly on 25.11.2016.
 * ${VERSION}
 */
public class RegistrationListDAO {

    public static RegistrationList getListByLogin(String login) throws SQLException {
        RegistrationList list = null;
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQLRequests.GET_LIST_BY_LOGIN);
        preparedStatement.setString(1, login);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            list = new RegistrationList();
            list.setId(resultSet.getInt(ColumnNames.RL_ID));
            list.setStudent(resultSet.getString(ColumnNames.RL_STUDENT));
            list.setAmountOfRightAnswers(resultSet.getInt(ColumnNames.RL_ANSWERS));
        }
        ConnectionPool.INSTANCE.closeConnection(connection);
        return list;
    }

    public static List<RegistrationList> findAll() throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQLRequests.GET_ALL_RLISTS);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<RegistrationList> registrationLists = new ArrayList<>();
        while (resultSet.next()){
            RegistrationList list = new RegistrationList();
            list.setId(resultSet.getInt(ColumnNames.RL_ID));
            list.setStudent(resultSet.getString(ColumnNames.RL_STUDENT));
            list.setAmountOfRightAnswers(resultSet.getInt(ColumnNames.RL_ANSWERS));
            registrationLists.add(list);
        }
        ConnectionPool.INSTANCE.closeConnection(connection);
        return registrationLists;
    }
}

package by.courses.nattiliana.dao;

import by.courses.nattiliana.connectionPool.ConnectionPool;
import by.courses.nattiliana.constants.ColumnNames;
import by.courses.nattiliana.constants.SQLRequests;
import by.courses.nattiliana.entities.Answer;

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
public enum  AnswerDAO implements AbstractDAO<Answer> {
    ANSWER_DAO;

    public List<Answer> findAllById(int questionId) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQLRequests.GET_ALL_ANSWERS);
        preparedStatement.setInt(1, questionId);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Answer> list = new ArrayList<>();
        while (resultSet.next()){
            Answer answer = new Answer();
            answer.setId(resultSet.getInt(ColumnNames.ANSWER_ID));
            answer.setQuestionId(resultSet.getInt(ColumnNames.ANSWER_QUESTION_ID));
            answer.setAnswer(resultSet.getString(ColumnNames.ANSWER));
            list.add(answer);
        }
        resultSet.close();
        preparedStatement.close();
        ConnectionPool.INSTANCE.closeConnection(connection);
        return list;
    }

    public static boolean isChecked(int id) throws SQLException {
        boolean isRight = false;
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQLRequests.CHECK_ANSWER);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            if (resultSet.getInt(ColumnNames.IS_RIGHT) == 1) {
                isRight = true;
            }
        }
        resultSet.close();
        preparedStatement.close();
        ConnectionPool.INSTANCE.closeConnection(connection);
        return isRight;
    }

    @Override
    public List<Answer> findAll() throws SQLException {
        return null;
    }

    @Override
    public void createEntity(Answer entity) throws SQLException {

    }
}

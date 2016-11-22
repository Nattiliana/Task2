package by.courses.nattiliana.dao;

import by.courses.nattiliana.connectionPool.ConnectionPool;
import by.courses.nattiliana.constants.ColumnNames;
import by.courses.nattiliana.constants.SQLRequests;
import by.courses.nattiliana.entities.Quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nataly on 18.11.2016.
 * ${VERSION}
 */
public class QuizDAO {

    public static List<Quiz> findAll() throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQLRequests.GET_ALL_QUIZZES);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Quiz> quizList = new ArrayList<>();
        while (resultSet.next()){
            Quiz quiz = new Quiz();
            quiz.setId(resultSet.getInt(ColumnNames.QUIZ_ID));
            quiz.setQuizName(resultSet.getString(ColumnNames.QUIZ_NAME));
            quiz.setSubjectId(resultSet.getInt(ColumnNames.QUIZ_SUBJECT_ID));
            quiz.setStatus(resultSet.getInt(ColumnNames.QUIZ_STATUS));
            quizList.add(quiz);
        }
        ConnectionPool.INSTANCE.closeConnection(connection);
        return quizList;
    }

    public static void createEntity(Quiz quiz) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQLRequests.ADD_QUIZ);
        preparedStatement.setString(1, quiz.getQuizName());
        preparedStatement.setInt(2, quiz.getSubjectId());
        preparedStatement.execute();
        ConnectionPool.INSTANCE.closeConnection(connection);
    }

    public static void deleteQuiz(int id) throws SQLException{
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQLRequests.UPDATE_QUIZ);
        statement.setInt(1, id);
        statement.executeUpdate();
        ConnectionPool.INSTANCE.closeConnection(connection);
    }
}

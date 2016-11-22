package by.courses.nattiliana.dao;

import by.courses.nattiliana.connectionPool.ConnectionPool;
import by.courses.nattiliana.constants.ColumnNames;
import by.courses.nattiliana.constants.SQLRequests;
import by.courses.nattiliana.entities.Question;
import by.courses.nattiliana.entities.Quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nataly on 22.11.2016.
 * ${VERSION}
 */
public class QuestionDAO {

    public static List<Question> findAll() throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQLRequests.GET_ALL_QUESTIONS);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Question> questionList = new ArrayList<>();
        while (resultSet.next()){
            Question question = new Question();
            question.setId(resultSet.getInt(ColumnNames.QUESTION_ID));
            question.setQuestion(resultSet.getString(ColumnNames.QUESTION));
            question.setQuizId(resultSet.getInt(ColumnNames.QUESTION_QUIZ_ID));
            question.setQuestionNumber(resultSet.getInt(ColumnNames.QUESTION_NUMBER));
            questionList.add(question);
        }
        ConnectionPool.INSTANCE.closeConnection(connection);
        return questionList;
    }
}

package by.courses.nattiliana.dao;

import by.courses.nattiliana.connectionPool.ConnectionPool;
import by.courses.nattiliana.constants.ColumnNames;
import by.courses.nattiliana.constants.SQLRequests;
import by.courses.nattiliana.entities.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nataly on 15.11.2016.
 * ${VERSION}
 */
public class  SubjectDAO {

    public static List<Subject> findAll() throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQLRequests.GET_ALL_SUBJECTS);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Subject> subjectList = new ArrayList<>();
        while (resultSet.next()){
            Subject subject = new Subject();
            subject.setId(resultSet.getInt(ColumnNames.SUBJECT_ID));
            subject.setSubjectName(resultSet.getString(ColumnNames.SUBJECT_NAME));
            subjectList.add(subject);
        }
        ConnectionPool.INSTANCE.closeConnection(connection);
        return subjectList;
    }
}

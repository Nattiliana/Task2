package by.courses.nattiliana.constants;

/**
 * Created by Nataly on 14.11.2016.
 * ${VERSION}
 */
public class SQLRequests {

    public static final String GET_ALL_STUDENTS = "SELECT name, surname FROM users WHERE userRole = 0 ORDER BY name";
    public static final String GET_ALL_SUBJECTS = "SELECT name FROM subjects";
    public static final String GET_ALL_QUIZZES = "SELECT * FROM quizzes";
    public static final String GET_ALL_QUESTIONS = "SELECT id, question, quizId, questionNumber FROM questions";
    public static final String ADD_STUDENT = "INSERT INTO users(login, password, name, surname) VALUES (?, ?, ?, ?)";
    public static final String ADD_QUIZ = "INSERT INTO quizzes(name, subjectId) VALUES (?, ?)";
    public static final String CHECK_LOGIN = "SELECT login FROM users WHERE login = ?";
    public static final String CHECK_AUTHORIZATION = "SELECT login, password FROM users WHERE login = ? AND password = ?";
    public static final String CHECK_USER_ROLE = "SELECT userRole FROM users WHERE login = ?";
    public static final String GET_USER_BY_LOGIN = "SELECT * FROM users WHERE login = ?";
    public static final String GET_SUBJECT_ID = "SELECT id FROM subjects WHERE name = ?";
    public static final String UPDATE_QUIZ = "UPDATE quizzes SET status = 1 WHERE id = ?";

    private SQLRequests() {}
}

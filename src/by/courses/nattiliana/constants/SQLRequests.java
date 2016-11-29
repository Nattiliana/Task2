package by.courses.nattiliana.constants;

/**
 * Created by Nataly on 14.11.2016.
 * ${VERSION}
 */
public class SQLRequests {

    public static final String GET_ALL_STUDENTS = "SELECT * FROM users WHERE userRole = 0 AND userStatus = 0 ORDER BY name";
    public static final String GET_ALL_SUBJECTS = "SELECT * FROM subjects";
    public static final String GET_ALL_QUIZZES = "SELECT * FROM quizzes";
    public static final String GET_ALL_RLISTS = "SELECT * FROM registrationlist";
    public static final String GET_ALL_AVAILABLE_QUIZZES = "SELECT * FROM quizzes, subjects WHERE quizzes.subjectId = subjects.id AND status = 0";
    public static final String GET_ALL_QUESTIONS_BY_ID = "SELECT * FROM questions WHERE quizId = ?";
    public static final String GET_ALL_QUESTIONS = "SELECT * FROM questions";
    public static final String GET_ALL_ANSWERS = "SELECT * FROM answers WHERE questionId = ?";
    public static final String ADD_STUDENT = "INSERT INTO users(login, password, name, surname) VALUES (?, ?, ?, ?)";
    public static final String ADD_QUIZ = "INSERT INTO quizzes(name, subjectId, status) VALUES (?, ?, 0)";
    public static final String ADD_QUESTION = "UPDATE questions SET quizId = ? WHERE id = ?";
    public static final String CHECK_LOGIN = "SELECT login FROM users WHERE login = ?";
    public static final String CHECK_QUIZ_NAME = "SELECT name FROM quizzes WHERE name = ?";
    public static final String CHECK_AUTHORIZATION = "SELECT login, password FROM users WHERE login = ? AND password = ?";
    public static final String CHECK_USER_ROLE = "SELECT userRole FROM users WHERE login = ?";
    public static final String GET_USER_BY_LOGIN = "SELECT * FROM users WHERE login = ?";
    public static final String GET_LIST_BY_LOGIN = "SELECT * FROM registrationlist WHERE student = ?";
    public static final String GET_SUBJECT_ID = "SELECT id FROM subjects WHERE name = ?";
    public static final String UPDATE_QUIZ = "UPDATE quizzes SET status = 1 WHERE id = ?";
    public static final String UPDATE_USER = "UPDATE users SET name = ?, surname = ? WHERE login = ?";
    public static final String DELETE_USER = "UPDATE users SET userStatus = 1 WHERE login = ?";

    private SQLRequests() {}
}

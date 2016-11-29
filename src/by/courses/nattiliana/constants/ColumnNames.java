package by.courses.nattiliana.constants;

/**
 * Created by Nataly on 15.11.2016.
 * ${VERSION}
 */
public class ColumnNames {

    public static final String USER_NAME = "name";
    public static final String USER_SURNAME = "surname";
    public static final String USER_LOGIN = "login";
    public static final String USER_PASSWORD = "password";
    public static final String USER_ROLE = "userRole";

    public static final String SUBJECT_ID = "id";
    public static final String SUBJECT_NAME = "name";

    public static final String QUIZ_ID = "id";
    public static final String QUIZ_NAME = "name";
    public static final String QUIZ_SUBJECT_ID = "subjectId";
    public static final String QUIZ_STATUS = "status";

    public static final String QUESTION_ID = "id";
    public static final String QUESTION = "question";
    public static final String QUESTION_ANSWER = "rightAnswerNumber";
    public static final String QUESTION_QUIZ_ID = "quizId";
    public static final String QUESTION_NUMBER = "questionNumber";

    public static final String RL_ID = "id";
    public static final String RL_STUDENT = "student";
    public static final String RL_ANSWERS = "amountOfRightAnswers";

    public static final String ANSWER_ID = "id";
    public static final String ANSWER_QUESTION_ID = "questionId";
    public static final String ANSWER = "answer";

    private ColumnNames(){}
}

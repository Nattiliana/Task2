package by.courses.nattiliana.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Quiz {

    private String quizName;
    private Subject subject;
    private List<Question> questionsList = new ArrayList<>();
    private Date dateOfCreate;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof Quiz)) {
            Quiz otherQuiz = (Quiz) obj;
            if (otherQuiz.quizName.equals(quizName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 31 + ((quizName == null) ? 0 : quizName.hashCode());
    }

    @Override
    public String toString() {
        return "\nQuiz name: " + quizName + " Questions list: " + questionsList + "\nDate: " + dateOfCreate;
    }

    public String getQuizName() {
        return "\nQuiz name: " + quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public List<Question> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(List<Question> questionsList) {
        this.questionsList = questionsList;
    }

    public Date getDateOfCreate() {
        return dateOfCreate;
    }

    public void setDateOfCreate(Date dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }
}

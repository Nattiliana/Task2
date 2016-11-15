package by.courses.nattiliana.entities;

import java.util.Map;
import java.util.TreeMap;

public class Question {

    private int questionNumber;
    private String question;
    private Map<Integer, String> answerMap = new TreeMap<>();
    private int rightAnswer;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Question)) {
            return false;
        }
        Question other = (Question) obj;
        if (question == null) {
            if (other.question != null) {
                return false;
            } else if (!question.equals(other.question)) {
                return false;
            }
        }
        return questionNumber == other.questionNumber;
    }

    @Override
    public int hashCode() {
        return 31 * questionNumber + ((question == null) ? 0 : question.hashCode());
    }

    @Override
    public String toString() {
        return "\nQuestion number: " + questionNumber + " Question: " + question
                + " Answers: " + answerMap + " Right answer: " + rightAnswer;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Map<Integer, String> getAnswerMap() {
        return answerMap;
    }

    public void setAnswerMap(Map<Integer, String> answerMap) {
        this.answerMap = answerMap;
    }

    public int getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(int rightAnswer) {
        this.rightAnswer = rightAnswer;
    }
}

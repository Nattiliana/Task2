package by.courses.nattiliana.entities;

/**
 * Created by Nataly on 25.11.2016.
 * ${VERSION}
 */
public class Answer extends Entity {

    private int id;
    private int questionId;
    private String answer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer1 = (Answer) o;

        return id == answer1.id && questionId == answer1.questionId && answer.equals(answer1.answer);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + questionId;
        result = 31 * result + answer.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", questionId=" + questionId +
                ", answer='" + answer + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}

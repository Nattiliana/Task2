package by.courses.nattiliana.entities;


public class Question {

    private int id;
    private String question;
    private int rightAnswer;
    private int quizId;
    private int questionNumber;


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
            if (other.question != null) return false;
            else if (!question.equals(null)) {
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
        return "Question number: " + questionNumber + " Question: " + question
                + " Right answer: " + rightAnswer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(int rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }
}

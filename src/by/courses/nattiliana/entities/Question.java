package by.courses.nattiliana.entities;


public class Question {

    private int id;
    private String question;
    private int rightAnswer;
    private int quizId;
    private int questionNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question1 = (Question) o;

        if (id != question1.id) return false;
        if (rightAnswer != question1.rightAnswer) return false;
        if (quizId != question1.quizId) return false;
        return questionNumber == question1.questionNumber && question.equals(question1.question);

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

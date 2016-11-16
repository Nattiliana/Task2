package by.courses.nattiliana.entities;

public class Quiz {

    private int id;
    private String quizName;
    private int subjectId;

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
        return "Quiz [Quiz name: " + quizName + " Subject id: " + subjectId + "id: " + id;
    }

    public String getQuizName() {
        return quizName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

}

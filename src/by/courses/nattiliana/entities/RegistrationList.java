package by.courses.nattiliana.entities;

/**
 * Created by Nataly on 18.10.2016.
 */

public class RegistrationList {

    private int id;
    private String student;
    private int amountOfRightAnswers;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof RegistrationList)) {
            RegistrationList other = (RegistrationList) obj;
            if (other.student.equals(student)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 31 + ((student == null) ? 0 : student.hashCode());
    }

    @Override
    public String toString() {
        return "Student login: " + student + " Amount of right answers: " + amountOfRightAnswers;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public int getAmountOfRightAnswers() {
        return amountOfRightAnswers;
    }

    public void setAmountOfRightAnswers(int amountOfRightAnswers) {
        this.amountOfRightAnswers = amountOfRightAnswers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


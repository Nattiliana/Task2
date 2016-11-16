package by.courses.nattiliana.entities;

/**
 * Created by Nataly on 18.10.2016.
 */

public class RegistrationList {

    private int id;
    private String login;
    private int amountOfRightAnswers;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof RegistrationList)) {
            RegistrationList other = (RegistrationList) obj;
            if (other.login.equals(login)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 31 + ((login == null) ? 0 : login.hashCode());
    }

    @Override
    public String toString() {
        return "Student login: " + login + " Amount of right answers: " + amountOfRightAnswers;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getAmountOfRightAnswers() {
        return amountOfRightAnswers;
    }

    public void setAmountOfRightAnswers(int amountOfRightAnswers) {
        this.amountOfRightAnswers = amountOfRightAnswers;
    }
}


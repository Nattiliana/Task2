package by.courses.nattiliana.entities;

public class User extends Entity {

    private String login;
    private String password;
    private String name;
    private String surname;
    private int userRole;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof User)) {
            User otherUser = (User) obj;
            if (otherUser.login.equals(login)) {
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
        return "User [Login: " + login + ", Password: " + password + ", Name: " + name + ", Surname: " + surname + ", User role:" + userRole + "]";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }
}


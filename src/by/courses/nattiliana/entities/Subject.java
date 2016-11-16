package by.courses.nattiliana.entities;

public class Subject {

    private int id;
    private String subjectName;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof Subject)) {
            Subject otherSubject = (Subject) obj;
            if (otherSubject.subjectName.equals(subjectName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 31 + ((subjectName == null) ? 0 : subjectName.hashCode());
    }

    @Override
    public String toString() {
        return "Subject [Subject name: " + subjectName + "]";
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

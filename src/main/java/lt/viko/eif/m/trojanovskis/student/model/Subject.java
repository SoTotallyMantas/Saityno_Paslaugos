package lt.viko.eif.m.trojanovskis.student.model;

public class Subject
{
    private String subjectName;
    private int credits;

    @Override
    public String toString() {
        return String.format("\t\tSubject: \n" +
                        "\t\t\tsubjectName: %s \n" +
                        "\t\t\tcredits: %s \n" ,
                this.getSubjectName(),this.getCredits());
    }
    public Subject(String subjectName, int credits) {
        this.subjectName = subjectName;
        this.credits = credits;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}

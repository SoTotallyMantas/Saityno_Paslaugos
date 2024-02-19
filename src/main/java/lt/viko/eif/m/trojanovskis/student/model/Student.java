package lt.viko.eif.m.trojanovskis.student.model;

import java.util.ArrayList;
import java.util.List;

public class Student
{
    private String firstName;
    private String lastName;
    private String code;

    private Account account;
    private List<Subject> subject  = new ArrayList<>();

    @Override
    public String toString() {
        return String.format("student: \n" +
                "\tFirst Name: %s \n" +
                "\tLast Name: %s \n" +
                "\tCode: %s  \n" +
                "\t%s " +
                "\t Subjects: \n"+
                "\t\t%s \n",
                this.firstName,this.lastName,this.code,this.account,this.FormatList());
    }
    private String FormatList()
    {
        String result = " ";

          result += subject.toString().replace(","," ").replace("["," ").replace("]"," ").trim();




        return result;
    }

    public Student(String firstName, String lastName, String code)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.code = code;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }


    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Subject> getSubject() {
        return subject;
    }


    public void setSubject(List<Subject> subject) {
        this.subject = subject;
    }
}

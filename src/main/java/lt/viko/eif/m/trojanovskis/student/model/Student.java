package lt.viko.eif.m.trojanovskis.student.model;

import javax.persistence.*;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "student")
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    private String firstName;
    private String lastName;
    private String code;


    @OneToOne(targetEntity = Account.class,cascade = CascadeType.ALL)
    private Account account;
    @OneToMany(targetEntity = Subject.class,cascade = CascadeType.ALL)
    private List<Subject> subject  = new ArrayList<>();

    @Override
    public String toString() {
        return String.format("student: \n" +
                "\tFirst Name: %s \n" +
                "\tLast Name: %s \n" +
                "\tCode: %s  \n" +
                "\t%s " +
                "\t Subjects: \n"+
                "%s \n",
                this.firstName,this.lastName,this.code,this.account,this.FormatList());
    }
    private String FormatList()
    {

        StringBuilder builder = new StringBuilder();
        for(Subject value:subject)
            {
                builder.append(value);
            }

//          result += subject.toString()
//                  .replace(","," ")
//                  .replace("["," ")
//                  .replace("]"," ")
//                  .trim();
        return builder.toString();
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

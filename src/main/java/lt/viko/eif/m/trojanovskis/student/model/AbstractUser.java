package lt.viko.eif.m.trojanovskis.student.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractUser
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id")
    public int id;
    public String firstname;
    public String lastname;
    public AbstractUser()
    {

    }


    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

package lt.viko.eif.m.trojanovskis.taksi.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;


/**
 * Abstract User Model class
 */
@XmlTransient
@XmlSeeAlso({Client.class, Dispatch.class, Driver.class})

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int id;
    private String firstName;
    private String lastName;


    @XmlElement
    public void setId(int id) {
        this.id = id;
    }

    @XmlElement(name = "FirstName")
    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }

    @XmlElement(name = "Lastname")
    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

    public String getFirstname() {
        return firstName;
    }

    public String getLastname() {
        return lastName;
    }

    public int getId() {
        return id;
    }


}

package lt.viko.eif.m.trojanovskis.student.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;


@XmlTransient
@XmlSeeAlso({Klientas.class, Despecerine.class, Vairuotojas.class})

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractUser
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id")
    public int id;
    private String firstName;
   private String lastName;




    @XmlElement
    public void setId(int id) {
        this.id = id;
    }
    @XmlElement(name="FirstName")
    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }
    @XmlElement(name="Lastname")
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

package lt.viko.eif.m.trojanovskis.student.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.OrderBy;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="Client")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder={"id","firstname","lastname","telefononumeris"})
@Entity
@DiscriminatorColumn(name = "klientas")
public class Klientas extends AbstractUser
{


    private String telefonoNumeris;
    public Klientas(String firstname,String lastname,String telefononumeris)
    {
        setFirstname(firstname);
        setLastname(lastname);
        this.telefonoNumeris = telefononumeris;
    }


    public Klientas() {

    }
    @Override
    public String toString() {
        return String.format("\t\tClient: \n" +
                        "\t\t\tFirst Name:   %s \n" +
                        "\t\t\tLast Name:    %s \n" +
                        "\t\t\tPhone Number: %s  \n",
                getFirstname(),getLastname(),this.telefonoNumeris);
    }


    public String getTelefononumeris() {
        return telefonoNumeris;
    }

     @XmlElement(name="Phone_Number")
    public void setTelefononumeris(String telefononumeris) {
        this.telefonoNumeris = telefononumeris;
    }
}

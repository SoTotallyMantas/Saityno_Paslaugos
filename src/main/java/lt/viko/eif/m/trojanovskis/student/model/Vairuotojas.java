package lt.viko.eif.m.trojanovskis.student.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="Driver")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder={"id","firstname","lastname","telefononumeris","automobiliomodelis"})
@Entity
@DiscriminatorColumn(name = "vairuotojas")
public class Vairuotojas extends AbstractUser
{


    private String telefonoNumeris;
    private String automobilioModelis;
    public Vairuotojas(String firstname, String lastname, String telefononumeris,String automobiliomodelis)
    {
        setFirstname(firstname);
        setLastname(lastname);
        this.telefonoNumeris = telefononumeris;
        this.automobilioModelis = automobiliomodelis;
    }



    public Vairuotojas() {

    }
    @Override
    public String toString() {
        return String.format("\t\tDriver: \n" +
                        "\t\t\tFirst Name:   %s \n" +
                        "\t\t\tLast Name:    %s \n" +
                        "\t\t\tPhone Number: %s  \n" +
                        "\t\t\tLicense Plate:    %s \n",
                getFirstname(),getLastname(),this.telefonoNumeris,this.automobilioModelis);
    }


    public String getTelefononumeris() {
        return telefonoNumeris;
    }
    @XmlElement(name="Phone_Number")
    public void setTelefononumeris(String telefononumeris) {
        this.telefonoNumeris = telefononumeris;
    }

    public String getAutomobiliomodelis() {
        return automobilioModelis;
    }
    @XmlElement(name="Car_Model")
    public void setAutomobiliomodelis(String automobiliomodelis) {
        this.automobilioModelis = automobiliomodelis;
    }
}

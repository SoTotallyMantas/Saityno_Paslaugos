package lt.viko.eif.m.trojanovskis.student.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="Dispatch")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder={"id","firstname","lastname","telefononumeris","darbotelefonas"})
@Entity
@DiscriminatorColumn(name = "despecerine")
public class Despecerine extends AbstractUser
{


    private String telefonoNumeris;
    private String darboTelefonas;
    public Despecerine(String firstname, String lastname, String telefononumeris, String darbotelefonas)
    {
        setFirstname(firstname);
        setLastname(lastname);
        this.telefonoNumeris = telefononumeris;
        this.darboTelefonas = darbotelefonas;
    }


    public Despecerine() {

    }
    @Override
    public String toString() {
        return String.format("\t\tDispatch: \n" +
                        "\t\t\tFirst Name:   %s \n" +
                        "\t\t\tLast Name:    %s \n" +
                        "\t\t\tPhone Number: %s \n" +
                        "\t\t\tWork Number:  %s \n",
                getFirstname(),getLastname(),this.telefonoNumeris,this.darboTelefonas);
    }

    public String getTelefononumeris() {
        return telefonoNumeris;
    }

    @XmlElement(name="Phone_Number")
    public void setTelefononumeris(String telefononumeris) {
        this.telefonoNumeris = telefononumeris;
    }



    public String getDarbotelefonas() {
        return darboTelefonas;
    }
    @XmlElement(name="Work_Phone_Number")
    public void setDarbotelefonas(String darbotelefonas) {
        this.darboTelefonas = darbotelefonas;
    }
}

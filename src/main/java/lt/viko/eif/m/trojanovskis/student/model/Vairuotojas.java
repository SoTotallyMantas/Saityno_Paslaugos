package lt.viko.eif.m.trojanovskis.student.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Entity
@DiscriminatorColumn(name = "vairuotojas")
public class Vairuotojas extends AbstractUser
{

    private String firstName;
    private String lastName;
    private String telefonoNumeris;
    private String automobilioModelis;
    public Vairuotojas(String firstname, String lastname, String telefononumeris,String automobiliomodelis)
    {
        this.firstName = firstname;
        this.lastName = lastname;
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
                        "\t\t\tCar Model:    %s \n",
                this.firstName,this.lastName,this.telefonoNumeris,this.automobilioModelis);
    }


    public String getTelefononumeris() {
        return telefonoNumeris;
    }

    public void setTelefononumeris(String telefononumeris) {
        this.telefonoNumeris = telefononumeris;
    }

    public String getAutomobiliomodelis() {
        return automobilioModelis;
    }

    public void setAutomobiliomodelis(String automobiliomodelis) {
        this.automobilioModelis = automobiliomodelis;
    }
}

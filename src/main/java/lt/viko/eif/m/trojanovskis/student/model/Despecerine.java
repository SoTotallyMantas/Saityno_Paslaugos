package lt.viko.eif.m.trojanovskis.student.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Entity
@DiscriminatorColumn(name = "despecerine")
public class Despecerine extends AbstractUser
{

    private String firstName;
    private String lastName;
    private String telefonoNumeris;
    private String darboTelefonas;
    public Despecerine(String firstname, String lastname, String telefononumeris, String darbotelefonas)
    {
        this.firstName = firstname;
        this.lastName = lastname;
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
                this.firstName,this.lastName,this.telefonoNumeris,this.darboTelefonas);
    }

    public String getTelefononumeris() {
        return telefonoNumeris;
    }

    public void setTelefononumeris(String telefononumeris) {
        this.telefonoNumeris = telefononumeris;
    }



    public String getDarbotelefonas() {
        return darboTelefonas;
    }

    public void setDarbotelefonas(String darbotelefonas) {
        this.darboTelefonas = darbotelefonas;
    }
}

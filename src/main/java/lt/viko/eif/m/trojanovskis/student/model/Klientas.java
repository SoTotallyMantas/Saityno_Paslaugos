package lt.viko.eif.m.trojanovskis.student.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Entity
@DiscriminatorColumn(name = "klientas")
public class Klientas extends AbstractUser
{

    private String firstName;
    private String lastName;
    private String telefonoNumeris;
    public Klientas(String firstname,String lastname,String telefononumeris)
    {
        this.firstName = firstname;
        this.lastName = lastname;
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
                this.firstName,this.lastName,this.telefonoNumeris);
    }


    public String getTelefononumeris() {
        return telefonoNumeris;
    }

    public void setTelefononumeris(String telefononumeris) {
        this.telefonoNumeris = telefononumeris;
    }
}

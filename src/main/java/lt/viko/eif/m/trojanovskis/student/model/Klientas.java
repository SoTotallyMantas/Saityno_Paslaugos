package lt.viko.eif.m.trojanovskis.student.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Entity
@DiscriminatorColumn(name = "klientas")
public class Klientas extends AbstractUser
{

    private String firstname;
    private String lastname;
    private String telefononumeris;
    public Klientas(String firstname,String lastname,String telefononumeris)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.telefononumeris = telefononumeris;
    }


    public Klientas() {

    }


    public String getTelefononumeris() {
        return telefononumeris;
    }

    public void setTelefononumeris(String telefononumeris) {
        this.telefononumeris = telefononumeris;
    }
}

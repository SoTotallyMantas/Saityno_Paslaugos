package lt.viko.eif.m.trojanovskis.student.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Entity
@DiscriminatorColumn(name = "despecerine")
public class Despecerine extends AbstractUser
{

    private String firstname;
    private String lastname;
    private String telefononumeris;
    private String darbotelefonas;
    public Despecerine(String firstname, String lastname, String telefononumeris, String darbotelefonas)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.telefononumeris = telefononumeris;
        this.darbotelefonas = darbotelefonas;
    }


    public Despecerine() {

    }


    public String getTelefononumeris() {
        return telefononumeris;
    }

    public void setTelefononumeris(String telefononumeris) {
        this.telefononumeris = telefononumeris;
    }



    public String getDarbotelefonas() {
        return darbotelefonas;
    }

    public void setDarbotelefonas(String darbotelefonas) {
        this.darbotelefonas = darbotelefonas;
    }
}

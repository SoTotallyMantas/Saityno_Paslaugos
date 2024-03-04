package lt.viko.eif.m.trojanovskis.student.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Entity
@DiscriminatorColumn(name = "vairuotojas")
public class Vairuotojas extends AbstractUser
{

    private String firstname;
    private String lastname;
    private String telefononumeris;
    private String automobiliomodelis;
    public Vairuotojas(String firstname, String lastname, String telefononumeris,String automobiliomodelis)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.telefononumeris = telefononumeris;
        this.automobiliomodelis = automobiliomodelis;
    }


    public Vairuotojas() {

    }


    public String getTelefononumeris() {
        return telefononumeris;
    }

    public void setTelefononumeris(String telefononumeris) {
        this.telefononumeris = telefononumeris;
    }

    public String getAutomobiliomodelis() {
        return automobiliomodelis;
    }

    public void setAutomobiliomodelis(String automobiliomodelis) {
        this.automobiliomodelis = automobiliomodelis;
    }
}

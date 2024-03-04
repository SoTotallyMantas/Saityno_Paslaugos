package lt.viko.eif.m.trojanovskis.student.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Entity
@DiscriminatorColumn(name = "TempUser")
public class TempUser extends AbstractUser
{

    private String firstname;
    private String lastname;
    public TempUser(String Firstname,String Lastname)
    {
        this.firstname = Firstname;
        this.lastname = Lastname;
    }


    public TempUser() {

    }


}

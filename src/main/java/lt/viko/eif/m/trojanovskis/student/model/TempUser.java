package lt.viko.eif.m.trojanovskis.student.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Entity
@DiscriminatorColumn(name = "TempUser")
public class TempUser extends AbstractUser
{


    public TempUser(String firstname,String Lastname)
    {
        this.firstname = firstname;
        this.lastname = Lastname;
    }


}

package lt.viko.eif.m.trojanovskis.student.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.xml.bind.annotation.*;

/**
 * Public Driver model class
 */
@XmlRootElement(name = "Driver")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"id", "firstname", "lastname", "phonenumber", "licenseplate"})
@Entity
@DiscriminatorColumn(name = "driver")
public class Driver extends AbstractUser {


    private String phoneNumber;
    private String licensePlate;

    public Driver(String firstname, String lastname, String phoneNumber, String licensePlate) {
        setFirstname(firstname);
        setLastname(lastname);
        this.phoneNumber = phoneNumber;
        this.licensePlate = licensePlate;
    }


    public Driver() {

    }

    @Override
    public String toString() {
        return String.format("\t\tDriver: \n" +
                        "\t\t\tFirst Name:   %s \n" +
                        "\t\t\tLast Name:    %s \n" +
                        "\t\t\tPhone Number: %s  \n" +
                        "\t\t\tLicense Plate:    %s \n",
                getFirstname(), getLastname(), this.phoneNumber, this.licensePlate);
    }


    public String getPhonenumber() {
        return phoneNumber;
    }

    @XmlElement(name = "Phone_Number")
    public void setPhonenumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLicenseplate() {
        return licensePlate;
    }

    @XmlElement(name = "License_Plate")
    public void setLicenseplate(String licenseplate) {
        this.licensePlate = licenseplate;
    }
}

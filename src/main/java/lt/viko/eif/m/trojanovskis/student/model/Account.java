package lt.viko.eif.m.trojanovskis.student.model;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String username;
    private String password;

    public Account() {

    }


    @Override
    public String toString() {
        return String.format("Account: \n" +
                        "\t\tusername: %s \n" +
                        "\t\tpassword: %s \n" +
                        "\t\tID: %s  \n",
                this.username,this.password,this.id);
    }
    public Account(String username, String password)
    {
        this.username = username;
        this.password = password;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

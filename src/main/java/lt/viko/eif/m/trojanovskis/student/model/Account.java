package lt.viko.eif.m.trojanovskis.student.model;

public class Account
{
    private String username;
    private String password;
    private String id;

    @Override
    public String toString() {
        return String.format("Account: \n" +
                        "\t\tusername: %s \n" +
                        "\t\tpassword: %s \n" +
                        "\t\tID: %s  \n",
                this.username,this.password,this.id);
    }
    public Account(String username, String password , String id)
    {
        this.username = username;
        this.password = password;
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

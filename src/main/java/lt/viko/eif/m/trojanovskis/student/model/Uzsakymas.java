package lt.viko.eif.m.trojanovskis.student.model;

import javax.persistence.*;

@Entity
@Table(name = "uzsakymas")
public class Uzsakymas
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String adresas;
    @OneToOne(targetEntity = Klientas.class,cascade = CascadeType.ALL)
    private Klientas klientas;
    @OneToOne(targetEntity = Vairuotojas.class,cascade = CascadeType.ALL)
    private Vairuotojas vairuotojas;
    @OneToOne(targetEntity = Despecerine.class,cascade = CascadeType.ALL)
    private Despecerine despecerine;
    public Uzsakymas()
    {

    }
    @Override
    public String toString() {
        return String.format("Order: \n" +
                        "\tAdress: %s \n" +
                        "%s " +
                        "%s " +
                        "%s ",
                this.adresas,this.klientas,this.vairuotojas,this.despecerine);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Klientas getKlientas() {
        return klientas;
    }

    public void setKlientas(Klientas klientas) {
        this.klientas = klientas;
    }

    public Vairuotojas getVairuotojas() {
        return vairuotojas;
    }

    public void setVairuotojas(Vairuotojas vairuotojas) {
        this.vairuotojas = vairuotojas;
    }

    public Despecerine getDespecerine() {
        return despecerine;
    }

    public void setDespecerine(Despecerine despecerine) {
        this.despecerine = despecerine;
    }

    public String getAdresas() {
        return adresas;
    }

    public void setAdresas(String adresas) {
        this.adresas = adresas;
    }
}

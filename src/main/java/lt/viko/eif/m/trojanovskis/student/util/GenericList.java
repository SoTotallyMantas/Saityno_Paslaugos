package lt.viko.eif.m.trojanovskis.student.util;

import lt.viko.eif.m.trojanovskis.student.model.Despecerine;
import lt.viko.eif.m.trojanovskis.student.model.Klientas;
import lt.viko.eif.m.trojanovskis.student.model.Uzsakymas;
import lt.viko.eif.m.trojanovskis.student.model.Vairuotojas;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;
import java.util.List;
@XmlRootElement(name="List")
@XmlSeeAlso({Uzsakymas.class, Vairuotojas.class, Klientas.class, Despecerine.class})
public class GenericList<T>
{
    private List<T> Data;
    public GenericList(){}

    @XmlAnyElement(lax=true)
    public List<T> getData()
    {
        return Data;
    }

    public void setData(List<T> Data)

    {
        this.Data = Data;
    }





}

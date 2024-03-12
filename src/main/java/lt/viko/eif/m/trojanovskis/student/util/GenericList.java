package lt.viko.eif.m.trojanovskis.student.util;

import lt.viko.eif.m.trojanovskis.student.model.Dispatch;
import lt.viko.eif.m.trojanovskis.student.model.Client;
import lt.viko.eif.m.trojanovskis.student.model.Order;
import lt.viko.eif.m.trojanovskis.student.model.Driver;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.List;
@XmlRootElement(name="List")
@XmlSeeAlso({Order.class, Driver.class, Client.class, Dispatch.class})
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

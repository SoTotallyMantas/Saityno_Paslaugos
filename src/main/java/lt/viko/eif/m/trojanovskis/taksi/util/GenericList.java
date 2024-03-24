package lt.viko.eif.m.trojanovskis.taksi.util;

import lt.viko.eif.m.trojanovskis.taksi.model.Client;
import lt.viko.eif.m.trojanovskis.taksi.model.Dispatch;
import lt.viko.eif.m.trojanovskis.taksi.model.Driver;
import lt.viko.eif.m.trojanovskis.taksi.model.Order;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.List;

/**
 * Generic model class wrapper for marshalling
 */
@XmlRootElement(name = "OrderList")
@XmlSeeAlso({Order.class, Driver.class, Client.class, Dispatch.class})
public class GenericList<T> {
    private List<T> Data;

    public GenericList() {
    }

    @XmlAnyElement(lax = true)
    public List<T> getData() {
        return Data;
    }

    public void setData(List<T> Data) {
        this.Data = Data;
    }


}

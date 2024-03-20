
package lt.viko.eif.m.trojanovskis.student.xsdtest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for anonymous complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{}address"/&amp;gt;
 *         &amp;lt;element ref="{}client"/&amp;gt;
 *         &amp;lt;element ref="{}driver"/&amp;gt;
 *         &amp;lt;element ref="{}dispatch"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *       &amp;lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "address",
    "client",
    "driver",
    "dispatch"
})
@XmlRootElement(name = "Order")
public class Order {

    @XmlElement(required = true)
    protected String address;
    @XmlElement(required = true)
    protected Client client;
    @XmlElement(required = true)
    protected Driver driver;
    @XmlElement(required = true)
    protected Dispatch dispatch;
    @XmlAttribute(name = "id")
    protected String id;
    @Override
    public String toString() {
        return String.format("Order: \n" +
                        "\tID: %s \n" +
                        "\tAdress: %s \n" +
                        "%s " +
                        "%s " +
                        "%s ",
                this.id,this.address, this.client, this.driver, this.dispatch);
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the client property.
     * 
     * @return
     *     possible object is
     *     {@link Client }
     *     
     */
    public Client getClient() {
        return client;
    }

    /**
     * Sets the value of the client property.
     * 
     * @param value
     *     allowed object is
     *     {@link Client }
     *     
     */
    public void setClient(Client value) {
        this.client = value;
    }

    /**
     * Gets the value of the driver property.
     * 
     * @return
     *     possible object is
     *     {@link Driver }
     *     
     */
    public Driver getDriver() {
        return driver;
    }

    /**
     * Sets the value of the driver property.
     * 
     * @param value
     *     allowed object is
     *     {@link Driver }
     *     
     */
    public void setDriver(Driver value) {
        this.driver = value;
    }

    /**
     * Gets the value of the dispatch property.
     * 
     * @return
     *     possible object is
     *     {@link Dispatch }
     *     
     */
    public Dispatch getDispatch() {
        return dispatch;
    }

    /**
     * Sets the value of the dispatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link Dispatch }
     *     
     */
    public void setDispatch(Dispatch value) {
        this.dispatch = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}

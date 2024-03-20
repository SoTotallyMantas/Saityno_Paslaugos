
package lt.viko.eif.m.trojanovskis.student.xsdtest;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the lt.viko.eif.m.trojanovskis.student.xsdtest package. 
 * &lt;p&gt;An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Id_QNAME = new QName("", "id");
    private final static QName _FirstName_QNAME = new QName("", "FirstName");
    private final static QName _Lastname_QNAME = new QName("", "Lastname");
    private final static QName _PhoneNumber_QNAME = new QName("", "Phone_Number");
    private final static QName _LicensePlate_QNAME = new QName("", "License_Plate");
    private final static QName _WorkNumber_QNAME = new QName("", "Work_Number");
    private final static QName _Address_QNAME = new QName("", "address");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: lt.viko.eif.m.trojanovskis.student.xsdtest
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Client }
     * 
     */
    public Client createClient() {
        return new Client();
    }

    /**
     * Create an instance of {@link Driver }
     * 
     */
    public Driver createDriver() {
        return new Driver();
    }

    /**
     * Create an instance of {@link Dispatch }
     * 
     */
    public Dispatch createDispatch() {
        return new Dispatch();
    }

    /**
     * Create an instance of {@link Order }
     * 
     */
    public Order createOrder() {
        return new Order();
    }

    /**
     * Create an instance of {@link OrderList }
     * 
     */
    public OrderList createOrderList() {
        return new OrderList();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "id")
    public JAXBElement<String> createId(String value) {
        return new JAXBElement<String>(_Id_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "FirstName")
    public JAXBElement<String> createFirstName(String value) {
        return new JAXBElement<String>(_FirstName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Lastname")
    public JAXBElement<String> createLastname(String value) {
        return new JAXBElement<String>(_Lastname_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Phone_Number")
    public JAXBElement<String> createPhoneNumber(String value) {
        return new JAXBElement<String>(_PhoneNumber_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "License_Plate")
    public JAXBElement<String> createLicensePlate(String value) {
        return new JAXBElement<String>(_LicensePlate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Work_Number")
    public JAXBElement<String> createWorkNumber(String value) {
        return new JAXBElement<String>(_WorkNumber_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "address")
    public JAXBElement<String> createAddress(String value) {
        return new JAXBElement<String>(_Address_QNAME, String.class, null, value);
    }

}

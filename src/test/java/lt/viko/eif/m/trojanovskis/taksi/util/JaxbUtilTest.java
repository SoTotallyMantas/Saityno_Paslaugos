package lt.viko.eif.m.trojanovskis.taksi.util;

import lt.viko.eif.m.trojanovskis.taksi.model.Client;
import lt.viko.eif.m.trojanovskis.taksi.model.Dispatch;
import lt.viko.eif.m.trojanovskis.taksi.model.Driver;
import lt.viko.eif.m.trojanovskis.taksi.model.Order;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JaxbUtilTest {

    Order order = new Order();

    Client client = new Client("Tadas", "T", "123");
    Driver driver = new Driver("Tadas", "T", "123", "STD:123");
    Dispatch dispatch = new Dispatch("Tadas", "T", "123", "+123");
    String address = "Address";
    GenericList<Order> myGenericlist = new GenericList<Order>();

    @Test
    void transformToXML() {
        order.setAddress(address);
        order.setDispatch(dispatch);
        order.setClient(client);
        order.setDriver(driver);
        List<Order> orders = new ArrayList<>();
        orders.add(order);
        JaxbUtil.transformToXML(orders, new File("JAXBJUnitTest.xml"), new File("JAXBObject.xsd"));
        GenericList<Order> orderGenericList = JaxbUtil.transformToPOJO(Order.class, new File("JAXBJUnitTest.xml"), new File("JAXBObject.xsd"));
        JaxbUtil.transformToXML(orders, new File("JAXBJUnitTest.xml"), new File("JAXBObject.xsd"));
        GenericList<Order> orderGenericListTest = JaxbUtil.transformToPOJO(Order.class, new File("JAXBJUnitTest.xml"), new File("JAXBObject.xsd"));
        assertEquals(orderGenericList.getData().toString().trim(), orderGenericListTest.getData().toString().trim());
    }

    @Test
    void transformToPOJO() {
        order.setAddress(address);
        order.setDispatch(dispatch);
        order.setClient(client);
        order.setDriver(driver);
        List<Order> orders = new ArrayList<>();
        orders.add(order);
        JaxbUtil.transformToXML(orders, new File("JAXBJUnitTest.xml"), new File("JAXBObject.xsd"));
        GenericList<Order> orderGenericList = JaxbUtil.transformToPOJO(Order.class, new File("JAXBJUnitTest.xml"), new File("JAXBObject.xsd"));
        JaxbUtil.transformToXML(orders, new File("JAXBJUnitTest.xml"), new File("JAXBObject.xsd"));
        GenericList<Order> orderGenericListTest = JaxbUtil.transformToPOJO(Order.class, new File("JAXBJUnitTest.xml"), new File("JAXBObject.xsd"));
        assertEquals(orderGenericList.getData().toString().trim(), orderGenericListTest.getData().toString().trim());

    }
}
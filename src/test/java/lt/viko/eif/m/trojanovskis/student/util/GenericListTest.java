package lt.viko.eif.m.trojanovskis.student.util;

import lt.viko.eif.m.trojanovskis.student.model.Client;
import lt.viko.eif.m.trojanovskis.student.model.Dispatch;
import lt.viko.eif.m.trojanovskis.student.model.Driver;
import lt.viko.eif.m.trojanovskis.student.model.Order;
import net.bytebuddy.description.type.TypeList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenericListTest {

    Order order = new Order();

    Client client = new Client("Tadas","T","123");
    Driver driver = new Driver("Tadas","T","123","STD:123");
    Dispatch dispatch = new Dispatch("Tadas","T","123","+123");
    String address = "Address";
    GenericList<Order> myGenericlist = new GenericList<Order>();
    @Test
    void getData() {
        order.setAddress(address);
        order.setDispatch(dispatch);
        order.setClient(client);
        order.setDriver(driver);
        Order orderTest = new Order();
        List<Order> orderList = new ArrayList<>();
        orderList.add(orderTest);
        myGenericlist.setData(orderList);
        orderTest.setAddress(address);
        orderTest.setDispatch(dispatch);
        orderTest.setClient(client);
        orderTest.setDriver(driver);
        GenericList<Order> genericListTest = new GenericList<Order>();
        List<Order> orderListtest = new ArrayList<>();
        orderListtest.add(orderTest);
        genericListTest.setData(orderListtest);
        assertEquals(myGenericlist.getData(),genericListTest.getData());

    }

    @Test
    void setData() {
        order.setAddress(address);
        order.setDispatch(dispatch);
        order.setClient(client);
        order.setDriver(driver);
        Order orderTest = new Order();
        List<Order> orderList = new ArrayList<>();
        orderList.add(orderTest);
        myGenericlist.setData(orderList);
        orderTest.setAddress(address);
        orderTest.setDispatch(dispatch);
        orderTest.setClient(client);
        orderTest.setDriver(driver);
        GenericList<Order> genericListTest = new GenericList<Order>();
        List<Order> orderListtest = new ArrayList<>();
        orderListtest.add(orderTest);
        genericListTest.setData(orderListtest);
        assertEquals(myGenericlist.getData(),genericListTest.getData());
    }
}
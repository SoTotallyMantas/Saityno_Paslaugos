package lt.viko.eif.m.trojanovskis.student.util;

import lt.viko.eif.m.trojanovskis.student.model.Client;
import lt.viko.eif.m.trojanovskis.student.model.Dispatch;
import lt.viko.eif.m.trojanovskis.student.model.Driver;
import lt.viko.eif.m.trojanovskis.student.model.Order;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenericListTest {

    static Order order = new Order();

    static Client client = new Client("Tadas", "T", "123");
    static Driver driver = new Driver("Tadas", "T", "123", "STD:123");
    static Dispatch dispatch = new Dispatch("Tadas", "T", "123", "+123");
    static String address = "Address";
    GenericList<Order> myGenericlist = new GenericList<Order>();

    @BeforeAll
    public static void init() {
        order.setAddress(address);
        order.setDispatch(dispatch);
        order.setClient(client);
        order.setDriver(driver);
    }

    @Test
    void getData() {

        Order orderTest = order;
        List<Order> orderList = new ArrayList<>();
        orderList.add(orderTest);
        myGenericlist.setData(orderList);
        GenericList<Order> genericListTest = new GenericList<Order>();
        List<Order> orderListtest = new ArrayList<>();
        orderListtest.add(orderTest);
        genericListTest.setData(orderListtest);
        assertEquals(myGenericlist.getData(), genericListTest.getData());

    }

    @Test
    void setData() {

        Order orderTest = order;
        List<Order> orderList = new ArrayList<>();
        orderList.add(orderTest);
        myGenericlist.setData(orderList);
        GenericList<Order> genericListTest = new GenericList<Order>();
        List<Order> orderListtest = new ArrayList<>();
        orderListtest.add(orderTest);
        genericListTest.setData(orderListtest);
        assertEquals(myGenericlist.getData(), genericListTest.getData());
    }
}
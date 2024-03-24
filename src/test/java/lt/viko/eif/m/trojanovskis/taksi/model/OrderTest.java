package lt.viko.eif.m.trojanovskis.taksi.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {
    Order order = new Order();

    Client client = new Client("Tadas", "T", "123");
    Driver driver = new Driver("Tadas", "T", "123", "STD:123");
    Dispatch dispatch = new Dispatch("Tadas", "T", "123", "+123");

    @Test
    void getClient() {
        order.setClient(client);
        Client test = order.getClient();
        Client clientTest = new Client("Tadas", "T", "123");
        assertEquals(clientTest.toString().trim(), test.toString().trim());
    }

    @Test
    void setClient() {
        order.setClient(client);
        Client test = order.getClient();
        Client clientTest = new Client("Tadas", "T", "123");
        assertEquals(clientTest.toString().trim(), test.toString().trim());

    }

    @Test
    void getDriver() {
        order.setDriver(driver);
        Driver test = order.getDriver();
        Driver driverTest = new Driver("Tadas", "T", "123", "STD:123");
        assertEquals(driverTest.toString().trim(), test.toString().trim());
    }

    @Test
    void setDriver() {
        order.setDriver(driver);
        Driver test = order.getDriver();
        Driver driverTest = new Driver("Tadas", "T", "123", "STD:123");
        assertEquals(driverTest.toString().trim(), test.toString().trim());
    }

    @Test
    void getDispatch() {
        order.setDispatch(dispatch);
        Dispatch test = order.getDispatch();
        Dispatch dispatchTest = new Dispatch("Tadas", "T", "123", "+123");
        assertEquals(dispatchTest.toString().trim(), test.toString().trim());


    }

    @Test
    void setDispatch() {
        order.setDispatch(dispatch);
        Dispatch test = order.getDispatch();
        Dispatch dispatchTest = new Dispatch("Tadas", "T", "123", "+123");
        assertEquals(dispatchTest.toString().trim(), test.toString().trim());
    }

    @Test
    void getAddress() {
        order.setAddress("Address");
        String test = order.getAddress();
        assertEquals("Address", test);
    }

    @Test
    void setAddress() {
        order.setAddress("Address");
        String test = order.getAddress();
        assertEquals("Address", test);
    }
}
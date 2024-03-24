package lt.viko.eif.m.trojanovskis.taksi.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientTest {
    Client client = new Client("Tadas", "T", "123");

    @Test
    void getPhonenumber() {
        String testPhone = client.getPhonenumber();
        assertEquals("123", testPhone);
    }

    @Test
    void setPhonenumber() {
        client.setPhonenumber("321");
        String testPhone = client.getPhonenumber();
        assertEquals("321", testPhone);
    }
}
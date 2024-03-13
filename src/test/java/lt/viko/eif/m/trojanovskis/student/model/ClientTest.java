package lt.viko.eif.m.trojanovskis.student.model;

import org.junit.jupiter.api.Test;

import static lt.viko.eif.m.trojanovskis.student.model.Client.*;
import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {
    Client client = new Client("Tadas","T","123");
    @Test
    void getPhonenumber()
    {
       String testPhone = client.getPhonenumber();
       assertEquals("123",testPhone);
    }

    @Test
    void setPhonenumber()
    {
        client.setPhonenumber("321");
        String testPhone = client.getPhonenumber();
        assertEquals("321",testPhone);
    }
}
package lt.viko.eif.m.trojanovskis.taksi.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DispatchTest {

    Dispatch dispatch = new Dispatch("Tadas", "T", "123", "+123");

    @Test
    void getPhonenumber() {
        String testPhone = dispatch.getPhonenumber();
        assertEquals("123", testPhone);
    }

    @Test
    void setPhonenumber() {
        dispatch.setPhonenumber("321");
        String testPhone = dispatch.getPhonenumber();
        assertEquals("321", testPhone);
    }

    @Test
    void getWorknumber() {
        String testWorkphone = dispatch.getWorknumber();
        assertEquals("+123", testWorkphone);
    }

    @Test
    void setWorknumber() {
        dispatch.setWorknumber("+321");
        String testWorkphone = dispatch.getWorknumber();
        assertEquals("+321", testWorkphone);
    }
}
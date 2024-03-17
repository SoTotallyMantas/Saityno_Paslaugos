package lt.viko.eif.m.trojanovskis.student.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DriverTest {
    Driver driver = new Driver("Tadas", "T", "123", "STD:123");

    @Test
    void getPhonenumber() {
        String testPhone = driver.getPhonenumber();
        assertEquals("123", testPhone);
    }

    @Test
    void setPhonenumber() {
        driver.setPhonenumber("321");
        String testPhone = driver.getPhonenumber();
        assertEquals("321", testPhone);
    }

    @Test
    void getLicenseplate() {
        String testLicenseplate = driver.getLicenseplate();
        assertEquals("STD:123", testLicenseplate);
    }

    @Test
    void setLicenseplate() {
        driver.setLicenseplate("STD:321");
        String testLicenseplate = driver.getLicenseplate();
        assertEquals("STD:321", testLicenseplate);
    }
}
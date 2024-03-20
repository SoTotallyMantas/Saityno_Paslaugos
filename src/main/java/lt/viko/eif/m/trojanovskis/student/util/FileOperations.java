package lt.viko.eif.m.trojanovskis.student.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * File Operation class
 */
public class FileOperations {
    /**
     *
     * Write data to file
     * @param path File path
     * @param string String to write
     */
    public static void writeToFile(String path, String string) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("XMLObjectReceived.xml"));

            writer.write(string);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

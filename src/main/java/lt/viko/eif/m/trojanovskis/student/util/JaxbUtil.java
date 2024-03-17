package lt.viko.eif.m.trojanovskis.student.util;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.StringWriter;
import java.util.List;

/**
 * Java Marshalling JAXB Utility class
 */
public final class JaxbUtil {
    private JaxbUtil() {
    }

    public static Schema SchemaValidate(File pathXsd) {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(pathXsd);
            return schema;
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param data    Data object to Marshall into XML
     * @param path    Path to output XML file
     * @param pathXsd Path file to xml XSD schema
     */
    public static <T> String transformToXML(T data, File path, File pathXsd) {
        try {
            StringWriter returnableString = new StringWriter();
            GenericList<T> Data = new GenericList<T>();
            Data.setData((List<T>) data);
            JAXBContext jaxbContext = JAXBContext.newInstance(new Class[]{data.getClass(), Data.getClass()});
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.setSchema(SchemaValidate(pathXsd));
            jaxbMarshaller.marshal(Data, path);
            jaxbMarshaller.marshal(Data, returnableString);

            return returnableString.toString();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * @param clazz   UnMarshalling class Type
     * @param path    UnMarshalling File path
     * @param pathXsd UnMarshalling XML XSD schema File Path
     * @return returns XML object as GenericList<T>
     */
    public static <T> GenericList<T> transformToPOJO(Class<T> clazz, File path, File pathXsd) {
        try {

            GenericList<T> Data = new GenericList<>();

            JAXBContext jaxbContext = JAXBContext.newInstance(new Class[]{clazz.getClass(), Data.getClass()});

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            jaxbUnmarshaller.setSchema(SchemaValidate(pathXsd));
            Data = (GenericList<T>) jaxbUnmarshaller.unmarshal(path);

            return Data;

        } catch (JAXBException e) {
            throw new RuntimeException(e);

        }
    }
}

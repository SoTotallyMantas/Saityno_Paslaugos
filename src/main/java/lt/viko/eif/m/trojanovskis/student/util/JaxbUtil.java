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
import java.util.List;

public final class JaxbUtil {
    private JaxbUtil(){}

    private static Schema SchemaValidate(File pathXsd)
    {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(pathXsd);
            return schema;
        }
        catch (SAXException e)
        {
            throw new RuntimeException(e);
        }
    }
        public static <T > void transformToXML(T data, File path, File pathXsd)
        {
            try {

                GenericList<T> Data = new GenericList<T>();
                Data.setData((List<T>) data);
                JAXBContext jaxbContext = JAXBContext.newInstance(new Class[]{data.getClass(), Data.getClass()});
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                jaxbMarshaller.setSchema(SchemaValidate(pathXsd));
                jaxbMarshaller.marshal(Data, path);
                jaxbMarshaller.marshal(Data, System.out);


            } catch (JAXBException e) {
                throw new RuntimeException(e);
            }

        }
        public static <T > void transformToPOJO(Class<T> clazz, File path, File pathXsd)
        {
            try {

                GenericList<T> Data = new GenericList<T>();

                JAXBContext jaxbContext = JAXBContext.newInstance(new Class[]{clazz.getClass(), Data.getClass()});

                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

                jaxbUnmarshaller.setSchema(SchemaValidate(pathXsd));
                Data = (GenericList<T>) jaxbUnmarshaller.unmarshal(path);
                Data.getData().forEach(data -> System.out.println(data));


            } catch (JAXBException e)
            {
                throw new RuntimeException(e);

            }
        }
    }

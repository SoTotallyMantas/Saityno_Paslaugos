package lt.viko.eif.m.trojanovskis.student.util;

import org.jboss.jandex.ClassType;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.crypto.Data;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JaxbUtil
{
    public <T> Object  ConvertToXML( T[] object)
    {
        try
        {

            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal( object, new File( "JAXBObject.xml" ) );
            jaxbMarshaller.marshal( object, System.out );


        }
        catch (JAXBException e)
        {
            throw new RuntimeException(e);
        }
        return object;
    }
    public <T> void ConvertToXML( T data)
    {
        try
        {

            GenericList<T> Data = new GenericList<T>();
            Data.setData((List<T>) data);
            JAXBContext jaxbContext = JAXBContext.newInstance(new Class[]{data.getClass(),Data.getClass()});
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File("JAXBObject.xsd"));
            jaxbMarshaller.setSchema(schema);
            jaxbMarshaller.marshal( Data, new File( "JAXBObject.xml" ) );
            jaxbMarshaller.marshal( Data, System.out );


        }
        catch (JAXBException e)
        {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

    }
    public <T> void ConvertToObject( Class<T> clazz)
    {
        try
        {

            GenericList<T> Data = new GenericList<T>();
            File file = new File( "JAXBObject.xml" );
            JAXBContext jaxbContext = JAXBContext.newInstance(new Class[]{clazz.getClass(),Data.getClass()});
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File("JAXBObject.xsd"));
             jaxbUnmarshaller.setSchema(schema);
            Data = (GenericList<T>) jaxbUnmarshaller.unmarshal( file );
            Data.getData().forEach(data->System.out.println(data));



        }
        catch (JAXBException e)
        {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

    }
}
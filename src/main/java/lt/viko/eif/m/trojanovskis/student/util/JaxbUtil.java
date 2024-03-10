package lt.viko.eif.m.trojanovskis.student.util;

import org.jboss.jandex.ClassType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.crypto.Data;
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
            jaxbMarshaller.marshal( Data, new File( "JAXBObject.xml" ) );
            jaxbMarshaller.marshal( Data, System.out );


        }
        catch (JAXBException e)
        {
            throw new RuntimeException(e);
        }

    }
    public <T> T xmlobject(String path, Class<T> clazz)
    {
        try {
            File file = new File(path);
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            T obj = clazz.cast(jaxbUnmarshaller.unmarshal(file));
            return obj;
        }
        catch (JAXBException e)
        {
            throw new RuntimeException(e);
        }

    }
}
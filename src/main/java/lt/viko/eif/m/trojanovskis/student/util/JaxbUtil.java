package lt.viko.eif.m.trojanovskis.student.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

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
}
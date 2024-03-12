package lt.viko.eif.m.trojanovskis.student.db;

import lt.viko.eif.m.trojanovskis.student.model.*;
import lt.viko.eif.m.trojanovskis.student.util.HibernateUtil;
import lt.viko.eif.m.trojanovskis.student.util.JaxbUtil;
import old_test.Old_Model.Student;
import org.h2.tools.Server;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DBLoader
{

  public static void SetupDB()
  {
//      Student student = new Student("Name1" , "LastName1" , "Code1");
//      Account account1 = new Account("User1","Pass1");
//      Subject test = new Subject("Test",10);
//      Subject test2 = new Subject("Test2",15);
//      Subject test3 = new Subject("Test3",20);
//      student.setAccount(account1);
//      student.getSubject().add(test);
//      student.getSubject().add(test2);
//      student.getSubject().add(test3);
      List<Uzsakymas> uzsakymasList = new ArrayList<>();
      List<String> firstNames = Arrays.asList("Jonas","Andrius","Tomas","Marius","Vytautas","Domantas","Lukas","Matas","Dovydas","Rokas");
      List<String> lastNames = Arrays.asList("Petrauskas","Jonaitis","Kazlauskas","Burokas","Simkus","Vasiliauskas","Kavaliauskas","Zuvoskis","Lapinaitis","Kazinec");
      List<String> numbers = Arrays.asList("+37012345678", "+37087654321", "+37098765432", "+37012345679", "+37087654320", "+37098765431", "+37012345680", "+37087654322", "+37098765433", "+37012345681");
      List<String> licensePlate = Arrays.asList("T2052","T1052","T1252","T2452","T3236","T5421","T1725","T4362","T6457","T6256");
      List<String> adresses = Arrays.asList("Erfurto 90","A.Kojalaviciaus 23","Mindaugo g 41","Liubarto g 30","Seliu g 50","T.Narburto g 42","Tuskulenu g 2","Rygos g 5","Ozo g 53","Kestucio g 9");
      int randomLastNames;
      int randomFirstNames;
      int randomNumbers;
      int randomPlate;
      int randomAdress;
      for(int i = 0; i <10;i++)
      {
          randomLastNames = new Random().nextInt(0,9);
          randomFirstNames = new Random().nextInt(0,9);
          randomNumbers = new Random().nextInt(0,9);
          Klientas klientas = new Klientas(firstNames.get(randomFirstNames),lastNames.get(randomLastNames), numbers.get(randomNumbers));
          randomLastNames = new Random().nextInt(0,9);
          randomFirstNames = new Random().nextInt(0,9);
          randomNumbers = new Random().nextInt(0,9);
          randomPlate = new Random().nextInt(0,9);
          Vairuotojas vairuotojas = new Vairuotojas(firstNames.get(randomFirstNames),lastNames.get(randomLastNames), numbers.get(randomNumbers), licensePlate.get(randomPlate));
          randomLastNames = new Random().nextInt(0,9);
          randomFirstNames = new Random().nextInt(0,9);
          randomNumbers = new Random().nextInt(0,9);
          Despecerine despecerine = new Despecerine(firstNames.get(randomFirstNames),lastNames.get(randomLastNames), numbers.get(randomNumbers),numbers.get(randomFirstNames));
          Uzsakymas uzsakymas = new Uzsakymas();
          uzsakymas.setDespecerine(despecerine);
          uzsakymas.setKlientas(klientas);
          uzsakymas.setVairuotojas(vairuotojas);
          randomAdress = new Random().nextInt(0,9);
          uzsakymas.setAdresas(adresses.get(randomAdress));
          uzsakymasList.add(uzsakymas);
      }







      org.h2.tools.Server server = null;
      Transaction transaction = null;
      try(Session session = HibernateUtil.getSessionFactory().openSession())
      {
          server = Server.createTcpServer("-tcpPort", "9093").start();
          transaction = session.beginTransaction();
          //session.save(student);
          uzsakymasList.forEach(uzsakymas -> session.save(uzsakymas));

          transaction.commit();
      }
      catch (SQLException e)
      {
          if(transaction!=null)
          {
              transaction.rollback();
          }
      }
      finally
      {

          if (server != null) {
              server.shutdown();
          }
      }
  }
    public static void ListStudents()
    {
        try(Session session=HibernateUtil.getSessionFactory().openSession())
        {
            List<Student> students = session.createQuery("from Student",Student.class).list();
            students.forEach(stud->System.out.println(stud));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void ListUzsakymas()
    {
        try(Session session=HibernateUtil.getSessionFactory().openSession())
        {
            List<Uzsakymas> orders = session.createQuery("from Uzsakymas",Uzsakymas.class).list();
            orders.forEach(ord->System.out.println(ord));

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void ListKlientas()
    {
        try(Session session=HibernateUtil.getSessionFactory().openSession())
        {
            List<Klientas> clients = session.createQuery("from Klientas",Klientas.class).list();
            clients.forEach(cln->System.out.println(cln));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void ListVairuotojas()
    {
        try(Session session=HibernateUtil.getSessionFactory().openSession())
        {
            List<Vairuotojas> drivers = session.createQuery("from Vairuotojas ",Vairuotojas.class).list();
             drivers.forEach(driv->System.out.println(driv));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void ListDespecerine()
    {
        try(Session session=HibernateUtil.getSessionFactory().openSession())
        {
            List<Despecerine> dispatcher = session.createQuery("from Despecerine ",Despecerine.class).list();
            dispatcher.forEach(disp->System.out.println(disp));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void ListOrderXML()
    {
        try(Session session=HibernateUtil.getSessionFactory().openSession())
        {

            List<Uzsakymas> orders = session.createQuery("from Uzsakymas",Uzsakymas.class).list();
            ListXML(orders);
        }
        catch(Exception e)
        {
            e.printStackTrace();

        }
    }
    public static <T> void ListXML(T data)
    {
        try {






           JaxbUtil.transformToXML(data, new File("JAXBObject.xml"), new File("JAXBObject.xsd"));


        }
        catch(Exception e)
        {
            e.printStackTrace();

        }


    }

    public static <T> void ListXMLToObject()
    {
        try {




            JaxbUtil.transformToPOJO(Uzsakymas.class, new File("JAXBObject.xml"), new File("JAXBObject.xsd"));

        }
        catch(Exception e)
        {
            e.printStackTrace();

        }


    }

}

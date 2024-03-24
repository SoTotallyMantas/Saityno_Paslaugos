package lt.viko.eif.m.trojanovskis.taksi.db;

import lt.viko.eif.m.trojanovskis.taksi.model.*;
import lt.viko.eif.m.trojanovskis.taksi.util.GenericList;
import lt.viko.eif.m.trojanovskis.taksi.util.HibernateUtil;
import lt.viko.eif.m.trojanovskis.taksi.util.JaxbUtil;
import org.h2.tools.Server;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Database loader
 */
public class DBLoader {

    /**
     * Database setup
     * With Example Data that is uploaded to Database
     */
    public static void SetupDB() {
//      Student student = new Student("Name1" , "LastName1" , "Code1");
//      Account account1 = new Account("User1","Pass1");
//      Subject test = new Subject("Test",10);
//      Subject test2 = new Subject("Test2",15);
//      Subject test3 = new Subject("Test3",20);
//      student.setAccount(account1);
//      student.getSubject().add(test);
//      student.getSubject().add(test2);
//      student.getSubject().add(test3);
        List<Order> orderList = new ArrayList<>();
        List<String> firstNames = Arrays.asList("Jonas", "Andrius", "Tomas", "Marius", "Vytautas", "Domantas", "Lukas", "Matas", "Dovydas", "Rokas");
        List<String> lastNames = Arrays.asList("Petrauskas", "Jonaitis", "Kazlauskas", "Burokas", "Simkus", "Vasiliauskas", "Kavaliauskas", "Zuvoskis", "Lapinaitis", "Kazinec");
        List<String> numbers = Arrays.asList("+37012345678", "+37087654321", "+37098765432", "+37012345679", "+37087654320", "+37098765431", "+37012345680", "+37087654322", "+37098765433", "+37012345681");
        List<String> licensePlate = Arrays.asList("T2052", "T1052", "T1252", "T2452", "T3236", "T5421", "T1725", "T4362", "T6457", "T6256");
        List<String> adresses = Arrays.asList("Erfurto 90", "A.Kojalaviciaus 23", "Mindaugo g 41", "Liubarto g 30", "Seliu g 50", "T.Narburto g 42", "Tuskulenu g 2", "Rygos g 5", "Ozo g 53", "Kestucio g 9");
        int randomLastNames;
        int randomFirstNames;
        int randomNumbers;
        int randomPlate;
        int randomAdress;
        for (int i = 0; i < 10; i++) {
            randomLastNames = new Random().nextInt(0, 9);
            randomFirstNames = new Random().nextInt(0, 9);
            randomNumbers = new Random().nextInt(0, 9);
            Client client = new Client(firstNames.get(randomFirstNames), lastNames.get(randomLastNames), numbers.get(randomNumbers));
            randomLastNames = new Random().nextInt(0, 9);
            randomFirstNames = new Random().nextInt(0, 9);
            randomNumbers = new Random().nextInt(0, 9);
            randomPlate = new Random().nextInt(0, 9);
            Driver driver = new Driver(firstNames.get(randomFirstNames), lastNames.get(randomLastNames), numbers.get(randomNumbers), licensePlate.get(randomPlate));
            randomLastNames = new Random().nextInt(0, 9);
            randomFirstNames = new Random().nextInt(0, 9);
            randomNumbers = new Random().nextInt(0, 9);
            Dispatch dispatch = new Dispatch(firstNames.get(randomFirstNames), lastNames.get(randomLastNames), numbers.get(randomNumbers), numbers.get(randomFirstNames));
            Order order = new Order();
            order.setDispatch(dispatch);
            order.setClient(client);
            order.setDriver(driver);
            randomAdress = new Random().nextInt(0, 9);
            order.setAddress(adresses.get(randomAdress));
            orderList.add(order);
        }


        org.h2.tools.Server server = null;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            server = Server.createTcpServer("-tcpPort", "9093").start();
            transaction = session.beginTransaction();
            //session.save(student);
            orderList.forEach(order -> session.save(order));

            transaction.commit();
        } catch (SQLException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {

            if (server != null) {
                server.shutdown();
            }
        }

    }

    /**
     * List Order class data from database
     */
    public static List<Order> ListOrder() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Order> orders = session.createQuery("from Order", Order.class).list();
            return orders;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * List Client class data from database
     */
    public static List<Client> ListClient() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Client> clients = session.createQuery("from Client", Client.class).list();
            return clients;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * List Driver class data from database
     */
    public static List<Driver> ListDriver() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Driver> drivers = session.createQuery("from Driver", Driver.class).list();

            return drivers;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * List Dispatch class data from database
     */
    public static List<Dispatch> ListDispatch() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Dispatch> dispatcher = session.createQuery("from Dispatch ", Dispatch.class).list();
            return dispatcher;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * Retrieve Order class data from database and call generic ListXML
     */
    public static String ListOrderXML() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            List<Order> orders = session.createQuery("from Order", Order.class).list();
            return ListXML(orders);
        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    /**
     * Generic
     * Convert POJO To XML
     *
     * @param data POJO Data
     */
    public static <T> String ListXML(T data) {
        try {


            return JaxbUtil.transformToXML(data, new File("JAXBObject.xml"), new File("JAXBObject.xsd"));


        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }


    }

    /**
     * Function call to convert XML To object
     */
    public static <T> void ListXMLToObject() {
        try {


            GenericList<T> Data = new GenericList<T>();
            Data = (GenericList<T>) JaxbUtil.transformToPOJO(Order.class, new File("JAXBObject.xml"), new File("JAXBObject.xsd"));
            Data.getData().forEach(data -> System.out.println(data));

        } catch (Exception e) {
            e.printStackTrace();

        }


    }

}

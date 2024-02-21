package lt.viko.eif.m.trojanovskis.student;


import lt.viko.eif.m.trojanovskis.student.model.Account;
import lt.viko.eif.m.trojanovskis.student.model.Student;
import lt.viko.eif.m.trojanovskis.student.model.Subject;
import lt.viko.eif.m.trojanovskis.student.util.HibernateUtil;
import org.h2.tools.Server;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
         Student student = new Student("Name1" , "LastName1" , "Code1");
         Account account1 = new Account("User1","Pass1");
         Subject test = new Subject("Test",10);
        Subject test2 = new Subject("Test2",15);
        Subject test3 = new Subject("Test3",20);



         student.setAccount(account1);
         student.getSubject().add(test);
        student.getSubject().add(test2);
        student.getSubject().add(test3);

         System.out.println(student);
         org.h2.tools.Server server = null;
         Transaction transaction = null;
         try(Session session = HibernateUtil.getSessionFactory().openSession())
         {
             server = Server.createTcpServer("-tcpPort", "9092").start();
             transaction = session.beginTransaction();
             session.save(student);
             transaction.commit();
         }
         catch (Exception e)
         {
             if(transaction!=null)
             {
                 transaction.rollback();
             }
         }
         finally
         {
             server.shutdown();
         }

    }
}
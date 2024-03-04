package lt.viko.eif.m.trojanovskis.student.db;

import lt.viko.eif.m.trojanovskis.student.model.Account;
import lt.viko.eif.m.trojanovskis.student.model.Student;
import lt.viko.eif.m.trojanovskis.student.model.Subject;
import lt.viko.eif.m.trojanovskis.student.model.TempUser;
import lt.viko.eif.m.trojanovskis.student.util.HibernateUtil;
import org.h2.tools.Server;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class DBLoader
{
  public static void SetupDB()
  {
      Student student = new Student("Name1" , "LastName1" , "Code1");
      Account account1 = new Account("User1","Pass1");
      Subject test = new Subject("Test",10);
      Subject test2 = new Subject("Test2",15);
      Subject test3 = new Subject("Test3",20);
      TempUser tempuser = new TempUser("Testas","Testauskas");



      student.setAccount(account1);
      student.getSubject().add(test);
      student.getSubject().add(test2);
      student.getSubject().add(test3);
      org.h2.tools.Server server = null;
      Transaction transaction = null;
      try(Session session = HibernateUtil.getSessionFactory().openSession())
      {
          server = Server.createTcpServer("-tcpPort", "9093").start();
          transaction = session.beginTransaction();
          session.save(student);
          session.save(tempuser);
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
}

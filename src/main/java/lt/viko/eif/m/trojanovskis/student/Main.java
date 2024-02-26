package lt.viko.eif.m.trojanovskis.student;


import lt.viko.eif.m.trojanovskis.student.db.DBLoader;
import lt.viko.eif.m.trojanovskis.student.menu.Menu;
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
         DBLoader.SetupDB();
        Menu.showMenu();

    }
}
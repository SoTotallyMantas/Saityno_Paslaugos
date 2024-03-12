package lt.viko.eif.m.trojanovskis.student;


import lt.viko.eif.m.trojanovskis.student.db.DBLoader;
import lt.viko.eif.m.trojanovskis.student.menu.Menu;

public class Main {
    public static void main(String[] args)
    {
         DBLoader.SetupDB();
        Menu.showMenu();

    }
}
package lt.viko.eif.m.trojanovskis.student;


import lt.viko.eif.m.trojanovskis.student.Socket.JavaClient;
import lt.viko.eif.m.trojanovskis.student.Socket.JavaServer;
import lt.viko.eif.m.trojanovskis.student.db.DBLoader;
import lt.viko.eif.m.trojanovskis.student.menu.Menu;
import lt.viko.eif.m.trojanovskis.student.menu.StartMenu;

public class Main {
    public static void main(String[] args) {
        StartMenu.showMenu();
        StartMenu.menuSelected();

    }
}
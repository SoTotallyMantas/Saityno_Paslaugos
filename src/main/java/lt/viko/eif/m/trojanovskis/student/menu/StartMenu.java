package lt.viko.eif.m.trojanovskis.student.menu;

import lt.viko.eif.m.trojanovskis.student.Socket.JavaClient;
import lt.viko.eif.m.trojanovskis.student.Socket.JavaServer;
import lt.viko.eif.m.trojanovskis.student.db.DBLoader;

import java.util.Scanner;

public class StartMenu {

    public static void showMenu() {
        System.out.println("Make a selection");
        System.out.println("-----------------");
        //System.out.printf("| 1)  %10s \n", " Load Students");
        System.out.printf("| 1)  %10s \n", " Start Server");
        System.out.printf("| 2)  %10s \n", " Start Client");
        System.out.printf("| 3)  %10s \n", " Setup Database");
        System.out.printf("| 4)  %10s \n", " Show Database menu");
        System.out.printf("| 5)  %7s \n", " Quit ");

    }

    public static int selection() {
        Scanner UserInput = new Scanner(System.in);

        return UserInput.nextInt();
    }

    public static void menuSelected() {
        int Input = selection();
        switch (Input) {
            case 1:
                JavaServer.startServer();

                break;
            case 2:
                JavaClient.startClient();

                break;
            case 3:
                DBLoader.SetupDB();
                Menu.showMenu();
                Menu.menuSelected();
                break;
            case 4:

                Menu.showMenu();
                Menu.menuSelected();
                break;

            case 5:
                System.out.println("Thank you and goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Input Try Again");
                showMenu();
                break;

        }
    }
}

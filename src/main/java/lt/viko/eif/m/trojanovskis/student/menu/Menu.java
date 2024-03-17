package lt.viko.eif.m.trojanovskis.student.menu;

import lt.viko.eif.m.trojanovskis.student.Socket.JavaClient;
import lt.viko.eif.m.trojanovskis.student.db.DBLoader;
import lt.viko.eif.m.trojanovskis.student.util.GenericPrint;

import java.lang.reflect.InvocationHandler;
import java.util.Objects;
import java.util.Scanner;

public class Menu {
    /**
     * Database and XML function menu
     */
    public static void showMenu() {
        System.out.println("Make a selection");
        System.out.println("-----------------");
        System.out.printf("| 1)  %10s \n", " Load Orders");
        System.out.printf("| 2)  %10s \n", " Load Dispatcher");
        System.out.printf("| 3)  %10s \n", " Load Drivers");
        System.out.printf("| 4)  %10s \n", " Load Clients");
        System.out.printf("| 5)  %10s \n", " Load Order XML ");
        System.out.printf("| 6)  %10s \n", " Load XML To Object ");
        System.out.printf("| 7)  %7s \n", " Quit ");

    }



    /**
     * Awaits User Input
     *
     * @return returns selection
     */
    public static int selection() {
        Scanner UserInput = new Scanner(System.in);

        return UserInput.nextInt();
    }



    /**
     * User selection Switch that calls selected function
     */
    public static void menuSelected() {
        GenericPrint Printable = new GenericPrint();
        int Input = selection();
        switch (Input) {

            case 1:
                Printable.Print(Objects.requireNonNull(DBLoader.ListOrder()));

                showMenu();
                break;
            case 2:
                Printable.Print(Objects.requireNonNull(DBLoader.ListDispatch()));
                showMenu();
                break;
            case 3:
                Printable.Print(Objects.requireNonNull(DBLoader.ListDriver()));
                showMenu();
                break;
            case 4:
                Printable.Print(Objects.requireNonNull(DBLoader.ListClient()));
                showMenu();
                break;
            case 5:

                System.out.println(DBLoader.ListOrderXML());
                showMenu();
                break;
            case 6:
                DBLoader.ListXMLToObject();
                showMenu();
                break;
            case 7:
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


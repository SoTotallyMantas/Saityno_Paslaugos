package lt.viko.eif.m.trojanovskis.student.menu;

import lt.viko.eif.m.trojanovskis.student.db.DBLoader;
import net.bytebuddy.pool.TypePool;
import org.hibernate.sql.Select;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu
{

    public static void showMenu()
    {
        System.out.println("Make a selection");
        System.out.println("-----------------");
        //System.out.printf("| 1)  %10s \n", " Load Students");
        System.out.printf("| 1)  %10s \n", " Load Orders");
        System.out.printf("| 2)  %10s \n", " Load Dispatcher");
        System.out.printf("| 3)  %10s \n", " Load Drivers");
        System.out.printf("| 4)  %10s \n", " Load Clients");
        System.out.printf("| 5)  %10s \n", " Load Order XML ");
        System.out.printf("| 6)  %10s \n", " Load XML To Object ");
        System.out.printf("| 8)  %7s \n", " Quit ");
        menuSelected(selection());
    }
    public static int selection()
    {
        Scanner UserInput = new Scanner(System.in);

        return UserInput.nextInt();
    }
    public static void menuSelected(int Input)
    {

        switch (Input)
        {
//            case 1:
//                DBLoader.ListUzsakymas();
//                showMenu();
//                break;
            case 1:
                DBLoader.ListUzsakymas();
                showMenu();
                break;
            case 2:
                DBLoader.ListDespecerine();
                showMenu();
                break;
            case 3:
                DBLoader.ListVairuotojas();
                showMenu();
                break;
            case 4:
                DBLoader.ListKlientas();
                showMenu();
                break;
            case 5:
                DBLoader.ListOrderXML();
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

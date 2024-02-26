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
        System.out.printf("| 1)  %10s \n", " Load Students");
        System.out.printf("| 6)  %7s \n", " Quit ");
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
            case 1:
                DBLoader.ListStudents();
                showMenu();
                break;
            case 6:
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

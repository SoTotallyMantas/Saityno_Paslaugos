package lt.viko.eif.m.trojanovskis.student;


import lt.viko.eif.m.trojanovskis.student.model.Account;
import lt.viko.eif.m.trojanovskis.student.model.Student;
import lt.viko.eif.m.trojanovskis.student.model.Subject;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
         Student student = new Student("Name1" , "LastName1" , "Code1");
         Account account1 = new Account("User1","Pass1","1");
         Subject test = new Subject("Test",10);
        Subject test2 = new Subject("Test2",15);
        Subject test3 = new Subject("Test3",20);



         student.setAccount(account1);
         student.getSubject().add(test);
        student.getSubject().add(test2);
        student.getSubject().add(test3);

         System.out.println(student);


    }
}
package lt.viko.eif.m.trojanovskis.student.util;

import java.util.List;

public class GenericPrint {


    public <T> void Print(List<T> list) {
        list.forEach(System.out::println);
    }
}

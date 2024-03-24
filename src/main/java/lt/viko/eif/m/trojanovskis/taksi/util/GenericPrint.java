package lt.viko.eif.m.trojanovskis.taksi.util;

import java.util.List;

/**
 *  Generic print class
 */
public class GenericPrint {

    /**
     * Generic print
     * @param list generic list
     *
     */
    public <T> void Print(List<T> list) {
        list.forEach(System.out::println);
    }
}

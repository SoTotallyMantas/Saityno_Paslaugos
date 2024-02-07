package org.example;

import java.util.*;

public class Antra_praktine
{
    public static void main() {
        List<Integer> intList = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            intList.add(rand.nextInt(0, 100));
        }
        List<Double> doubleList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            doubleList.add(rand.nextDouble(0, 100));
        }
        List<Float> floatList  = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            floatList.add(rand.nextFloat(0, 100));
        }
        arrayList(new List[]{intList});
        arrayList(new List[]{doubleList});
        arrayList(new List[]{floatList});

        TreeSet<Double> valueTree = new TreeSet<>(doubleList);
        Iterator<Double>  itr = valueTree.iterator();
        while(itr.hasNext())
        {
         System.out.print(itr.next());
        }

//        Set<Integer> intSet = new HashSet<>(intList);
//        for (int value: intSet)
//        {
//         System.out.print(value);
//        }

//        for(int i=0; i<intList.size();i++)
//        {
//            System.out.println(intList.get(i));
//        }
//        for (Integer integer : intList) {
//            System.out.print(integer + " ");
//        }
    }

    public static <T> void arrayList(T[] list)
    {
        for (T value : list) {
            System.out.print(value + " ");
        }
        System.out.println("\n");
    }

}

package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        List<Integer> intList = new ArrayList<>();
        Random rand = new Random();
        for(int i=0;i<20;i++)
        {
            intList.add(rand.nextInt(0,100));
        }


//        for(int i=0; i<intList.size();i++)
//        {
//            System.out.println(intList.get(i));
//        }
        for (Integer integer: intList)
        {
          System.out.print(integer + " ");
        }




    }
}
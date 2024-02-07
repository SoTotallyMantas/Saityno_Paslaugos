package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        List<Integer> intList = new ArrayList<>();
        Random rand = new Random();
        for(int i=0;i<10;i++)
        {
            intList.add(rand.nextInt());
        }


        for(int i=0; i<intList.size();i++)
        {
            System.out.println(intList.get(i));
        }




    }
}
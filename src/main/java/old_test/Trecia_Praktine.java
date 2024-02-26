package old_test;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Trecia_Praktine
{
    public static void main()
    {
        List<Integer> list = Stream.of(1,2,3,4,5).collect(Collectors.toList());
        Antra_praktine.arrayList(new List[]{list});

        //list.stream().forEach( s-> System.out.println(s+" "));

        List<Double> doubleList = Stream.generate(Math::random).limit(20).collect(Collectors.toList());
       // doubleList.stream().forEach( s-> System.out.println(s+" "));
        Antra_praktine.arrayList(new List[]{doubleList});
        List<Long> intList = Stream.generate(Math::random).limit(100).map(el -> el*100).map(Math::round).collect(Collectors.toList());
        List<Long> intList2 = Stream.generate(Math::random).limit(100).map(el -> el*100).map(Math::round).collect(Collectors.toList());
       // intList.stream().forEach( s-> System.out.println(s+" "));
        Antra_praktine.arrayList(new List[]{intList});

        Antra_praktine.arrayList(new List[]{intList.stream().filter(element -> element< 50).collect(Collectors.toList())});

        Stream<Integer> myStream = Stream.of(1,2,3,4,5);
        myStream.map(el ->  el+ " elementas ").peek(System.out::println).collect(Collectors.toList());

        System.out.println(" Nelyginiai");

        intList = intList.stream().filter(element -> element % 2 != 0).collect(Collectors.toList());
        Antra_praktine.arrayList(new List[]{intList});

        System.out.println(" Daugiau uz 10");

        intList = intList.stream().filter(element -> element > 10).collect(Collectors.toList());
        Antra_praktine.arrayList(new List[]{intList});

        System.out.println(" Maziau uz 70");

        intList = intList.stream().filter(element -> element <70).collect(Collectors.toList());
        Antra_praktine.arrayList(new List[]{intList});

//        System.out.println(" Nelyginiai daugiau uz 10 ir maziau uz 70");
//        intList2 = intList2.stream().filter(element -> element % 2 != 0).filter(element -> element > 10).filter(element -> element <70).collect(Collectors.toList());
//        Antra_praktine.arrayList(new List[]{intList2});


//        Antra_praktine.arrayList(new List[]{Antra_praktine.ListIntegerGenerate(20,0,100)});
        // Old style
        System.out.println("Map Old Style");
        Map map=new HashMap();
        map.put(1,"Amit");
        map.put(5,"Rahul");
        map.put(2,"Jai");
        map.put(6,"Amit");
        Set set=map.entrySet();
        Iterator itr=set.iterator();
        while(itr.hasNext()) {
            Map.Entry entry = (Map.Entry) itr.next();
            System.out.println(entry.getKey() + " " + entry.getValue());

        }
        System.out.println("Map New Style");
            Map<Integer,String> integerstringMap =  new HashMap<>();
            integerstringMap.put(100,"Test");
            integerstringMap.put(101,"Test2");
            integerstringMap.put(102,"Test3");
            for(Map.Entry m:integerstringMap.entrySet())
        {
            System.out.println(m.getKey()+ " " +  m.getValue());
        }
        System.out.println("Map Comparing By Key ");
        integerstringMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);
        System.out.println( " Map Comparing By Key Reverse order");
            integerstringMap.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                    .forEach(System.out::println);
        System.out.println( " Map Comparing By Value");
        integerstringMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);
        System.out.println( " Map Comparing By Value Reverse order");
        integerstringMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);


    }

}

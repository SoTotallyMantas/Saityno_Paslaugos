package old_test;

import java.util.*;

public class Antra_praktine {
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
        List<Float> floatList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            floatList.add(rand.nextFloat(0, 100));
        }
        arrayList(new List[]{intList});
        arrayList(new List[]{doubleList});
        arrayList(new List[]{floatList});

        TreeSet<Double> valueTree = new TreeSet<>(doubleList);
        Iterator<Double> itr = valueTree.iterator();
        while (itr.hasNext()) {
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

    public static <Integer> List ListIntegerGenerate(int size, int limitOrigin, int limitBound )
    {
        List<java.lang.Integer> intList = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            intList.add(rand.nextInt(limitOrigin    , limitBound));
        }
        return List.of(intList);
    }
    public static <Double> List ListDoubleGenerate(int size, int limitOrigin, int limitBound )
    {
        List<java.lang.Double> intList = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            intList.add(rand.nextDouble(limitOrigin    , limitBound));
        }
        return List.of(intList);
    }
    public static <Float> List ListFloatGenerate(int size, int limitOrigin, int limitBound )
    {
        List<java.lang.Float> intList = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            intList.add(rand.nextFloat(limitOrigin    , limitBound));
        }
        return List.of(intList);
    }

    public static <T> void arrayList(T[] list) {
        for (T value : list) {
            System.out.print(value + " ");
        }
        System.out.println("\n");
    }

    static <T> void printArray(T[] array) {
        int sizeArray = array.length;
        for (int i = 0; i < sizeArray; i++) {
            System.out.print(array[i]);
            System.out.print(" ");
            if (i == (sizeArray / 2)) {
                System.out.println("\000");
            }
        }

    }
}

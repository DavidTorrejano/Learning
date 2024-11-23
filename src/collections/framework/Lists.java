package collections.framework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lists {
    public static void main(String[] args) {
        List<Integer> arrList = new ArrayList<>();
        arrList.add(1);
        arrList.add(2);
        arrList.add(3);
        arrList.add(4);

        // With this method we can update a position in the list, and it will return the value at the given index
//        int n = arrList.set(0, 0);

        List<Integer> arrList2 = new ArrayList<>();
        arrList2.add(5);
        arrList2.add(6);
        arrList2.add(7);
        arrList2.add(8);

        // This method will add all the elements from another collection to the list after the last value
        //arrList2.addAll(arrList);

        arrList2.forEach(System.out::println);

        // This returns the index of a specified object if found
        System.out.println(arrList2.indexOf(3));

        //Here we are creating a new list from an existing one, the method is exclusive for the second argument
        List<Integer> arrList3 = arrList2.subList(1, 3);
        arrList3.set(1, 50);
        System.out.println(arrList2);
        System.out.println(arrList3);


    }
}

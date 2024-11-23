package collections.framework;

import java.util.*;

public class LinkedLists {
    public static void main(String[] args) {
        List<Integer> lk = new LinkedList<>();
        lk.add(1);
        lk.add(2);
        lk.add(3);

        ListIterator<Integer> it = lk.listIterator();

        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.previous());

    }
}

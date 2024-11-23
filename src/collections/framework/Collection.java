package collections.framework;

import java.util.ArrayDeque;
import java.util.Deque;

public class Collection {
    public static void main(String[] args) {

        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("Element 1");
        deque.offerFirst("Element 2");

        deque.addLast("Element 3");
        deque.offerLast("Element 4");

        System.out.println(deque);
        deque.iterator();

    }
}

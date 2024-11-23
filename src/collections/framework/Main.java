package collections.framework;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        OurGenericList<Integer> numbers = new OurGenericList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        for (int n : numbers) {
            System.out.println(n);
        }

    }
}

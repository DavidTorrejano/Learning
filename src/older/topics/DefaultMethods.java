package older.topics;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class DefaultMethods implements Left, Right{

    public void m1() {
        Left.super.m1();
    }

    public void move() {
        System.out.println("Solved");
    }

    public static void main(String[] args) {

        Predicate<Integer> evenOrNot = n -> {
            return n % 2 == 0;
        };

        System.out.println(evenOrNot.test(4));
        System.out.println(evenOrNot.test(3));
        System.out.println(evenOrNot.test(0));

        Consumer<String> print = System.out::println;
        print.accept("Consumiendo");





    }

}


interface Left {
    default void m1() {
        System.out.println("Turn to the left");
    }
}

interface Right {
    default void m1() {
        System.out.println("Turn to the right");
    }
}


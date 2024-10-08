package libro.behavior.parameterization;

import lambda.expressions.Pear;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class LocalVariablesWithLambda {

    public static void main(String[] args) {

        int portNumber = 243;
        Runnable r = () -> System.out.println(portNumber);
//        portNumber = 5 -> This is not allowed, the variable can't change, it must be final.

        List<String> str = Arrays.asList("Dav", "Dani", "Mari", "Elías");

        str.sort(String::compareToIgnoreCase);

        BiPredicate <List<String>, String> contains = List::contains;

        str.forEach(System.out::println);

        Function<Integer, Pear> createNewPear = Pear::new;
        Pear p1 = createNewPear.apply(89);
        System.out.println(p1.getWeight());




    }

}



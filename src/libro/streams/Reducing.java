package libro.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reducing {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // The reduce method what it does is, from the stream takes the first two elements, assign 1 to a and 2 to b
        // then after they have been summed the result will be assigned to a and from there on, the next element from
        // the stream will be consumed through b, while the accumulated value will be at "a", at the end, "a" will be
        // returned.
        Optional<Integer> reduction = numbers.stream().reduce((a, b) -> a + b);
        System.out.println(reduction.get());

        // When using the identity parameter, is pretty much the same as the previous case, the only difference is,
        // you are passing now a "starter" value to the whole operation, after the identity has been consumed and
        // added to "a", it won't be utilized anymore.
        int reduced = numbers.stream().reduce(0, (a, b) -> a + b);

        // What this code does is, first will assign 7 to "a" and will take the first value from the stream of numbers
        // and will assign it to "b", after the comparison made in the "if" statement, will return the higher between
        // them, and that value will be assigned to "a", then the operation will be repeated until every value in the
        // stream has been consumed, then "a" will be returned and saved in the maxReduced variable.
        int maxReduced = numbers.stream().reduce(7, (a, b) -> {
            if (a<b) return b;
            else return a;
        });

        System.out.println(maxReduced);

        List<String> words = Arrays.asList("Java", "is", "a", "great", "language", "for", "programing");

        Optional<String> reducedWords = words.stream().reduce((a, b) -> a + " " + b);
        System.out.println(reducedWords.get());


        String word= "I know";

            word = words.stream().reduce(word, (a, b) -> a + " " + b);

            word = words.stream().reduce(word, (a, b) -> a + " " + b);


        System.out.println(word);


        // QUIZ: How would you count the number of dishes in a stream using the map and reduce
        //methods?

        List<Dish> dishes = Menu.getMenu();

        int numberOfDishes = dishes.stream().map(d -> 1).reduce(0, Integer::sum);
        System.out.println("There are " + numberOfDishes + " dishes in the stream.");




    }
}

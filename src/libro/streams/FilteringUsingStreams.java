package libro.streams;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;

public class FilteringUsingStreams {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 4, 2, 3, 1, 5, 3, 1, 2, 4, 7, 7);

        /*
        @distinct: by using distinct a filter will be applied that won't allow any repeated object to be returned.
         */
        System.out.println("Using distinct()");
        numbers.stream()
                .filter(n -> n > 2)
                .distinct()
                .sorted(Integer::compareTo)
                .forEach(System.out::println);
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::");


        List<Dish> organizedMenu = Menu.getMenu().stream().sorted(comparing(Dish::getCalories)).toList();
        /*
        * @dropWhile: this method will ignore all the objects in the stream that don't comply with the predicate
        * one an object that comply with it is found, all the subsequent objects will be returned
        */
        System.out.println("Using dropWhile(calories < 400)");
        organizedMenu.stream()
                .dropWhile(dish -> dish.getCalories() < 400)
                .forEach(dish -> System.out.println(dish.getName() + " - " + dish.getCalories()));
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::");

        /*
        @takeWhile: this method will take al the objects that comply with the predicate, once an object that
        doesn't comply it, the iteration will stop and no other object will be returned in the stream
         */
        System.out.println("Using takeWhile(calories < 400)");
        organizedMenu.stream()
                .takeWhile(dish -> dish.getCalories() < 400)
                .forEach(dish -> System.out.println(dish.getName() + " - " + dish.getCalories()));
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::");

        /*
        @limit: this method will truncate the stream to the given number of elements.
         */
        System.out.println("Using limit(maxSize: 4)");
        organizedMenu.stream()
                .limit(4)
                .forEach(dish -> System.out.println(dish.getName() + " - " + dish.getCalories()));
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::");

        /*
        @skip: this method will ignore n number of elements from a stream and then will return the remaining ones,
        if n is greater than the elements of the stream, then an empty stream will be returned.
         */
        System.out.println("Using skip(4)");
        organizedMenu.stream()
                .skip(4)
                .forEach(dish -> System.out.println(dish.getName() + " - " + dish.getCalories()));
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::");

        System.out.println("Using skip(n).limit(n)");
        organizedMenu.stream()
                .skip(2)
                .limit(4)
                .forEach(dish -> System.out.println(dish.getName() + " - " + dish.getCalories()));
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::");

        System.out.println("Limiting the list so it gives me only the first two meat dishes");
        organizedMenu.stream()
                .filter(dish -> dish.getType() == Dish.Type.MEAT)
                .limit(2)
                .forEach(dish -> System.out.println(dish.getName() + " - " + dish.getCalories()));
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::");
    }
}

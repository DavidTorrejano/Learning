package libro.collecting_data_with_streams;

import libro.streams.Dish;
import libro.streams.Menu;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class Partitioning {
    public static void main(String[] args) {

        List<Dish> menu = Menu.getMenu();

        /*
        Partitioning is a special case of grouping: having a predicate called a partitioning function as a classification
         function. The fact that the partitioning function returns a boolean means the resulting grouping Map will have
         a Boolean as a key type, and therefore, there can be at most two different groups, one for true and one for
         false  for instance, if you are vegetarian or have invited a vegetarian friend to have dinner with you, you may
         be interested in partitioning the menu into vegetarian and non-vegetarian dishes:
         */

        Map<Boolean, List<Dish>> partitionedMenu = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian));

        // This will return a map with two keys, one called true and the other false, if you want to get the vegetarian
        // dishes, what you need to do is as follows:
        System.out.println(partitionedMenu.get(true));

        /*
        Advantages of partitioning: Has the advantage of keeping both lists of the stream elements, for which the
        application of the partitioning function returns true or false. In the previous example, you can obtain the List
        of the non-vegetarian Dishes by accessing the value of the key false in the partitionedMenu Map.
        Also, as you already saw for groupingBy, the partitioningBy factory method has an overloaded version to which
        you can pass a second collector:
         */

        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesType = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));

        System.out.println(vegetarianDishesType);

        /*
        You can reuse this code to find the most caloric dish among both vegetarian and non-vegetarian dishes:
         */
        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian,
                        collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));


        /*
        Here what we do is first, divide the dishes into two categories, vegetarian and non-vegetarian, the using
        groupingBy we group them by type to then apply a comparator getting the less caloric dish.
         */
        Map<Boolean, Map<Dish.Type, Dish>> mostCaloricVegAndNonVegDishByType =
                menu.stream()
                        .collect(partitioningBy(
                                Dish::isVegetarian, groupingBy
                                        (Dish::getType, collectingAndThen(
                                                minBy(comparingInt(Dish::getCalories)),
                                                Optional::get)
                                        )
                                )
                        );

        System.out.println(mostCaloricVegAndNonVegDishByType);

        Map<Boolean, Map<Boolean, List<Dish>>> vegAndNonVegLowAndHighCaloricDishes =
                menu.stream().collect(partitioningBy(Dish::isVegetarian,
                        partitioningBy(d -> d.getCalories() > 500)));


        // Partitioning numbers into prime and non-prime
        Map<Boolean, List<Integer>> primeNumbers = partitionPrimes(55);
        System.out.println(primeNumbers.get(true));

    }

    public static boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt(candidate);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }

    public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(partitioningBy(Partitioning::isPrime));
    }

}

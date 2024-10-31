package libro.collecting_data_with_streams;


import libro.streams.Dish;
import libro.streams.Menu;

import java.util.*;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;


public class ReducingAndSummarizing {
    public static void main(String[] args) {

        List<Dish> menu = Menu.getMenu();

        //long howManyDishes = menu.stream().collect(counting());

        Comparator<Dish> dishCaloriesComparator =
                comparingInt(Dish::getCalories);

        //Collect: maximum
        Optional<Dish> mostCaloricDish =
                menu.stream()
                        .collect(maxBy(dishCaloriesComparator));

        //Collect: summing
        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println(totalCalories);

        // Collect: Collectors.averagingInt()
        double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));
        System.out.println(avgCalories);

        // This is a class that can store all the basic statistics sum, count, min, max, average
        IntSummaryStatistics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println(menuStatistics);

        // Joining Strings: 
        String shortMenu = menu.stream().map(Dish::getName).collect(joining(", "));
        System.out.println(shortMenu);


        // Reducing using collectors:
        // the reducing method takes three arguments:
        // * The first one is the starting value, which will also be returned
        // if there are no elements in the stream, and because it is a sum, 0 is the perfect value
        // * The second argument is a kind of "mapping" operation, here we are going to transform what we are getting
        // to an operable int
        // * And the third argument is a lambda, in this case a BinaryOperator that aggregates two items into a sighle
        // value of the same type.

        int totalCaloriesReducing = menu.stream()
                .collect(reducing(0, Dish::getCalories, Integer::sum));
        System.out.println(totalCaloriesReducing);

        Optional<Dish> mostCaloricDishOther = menu.stream()
                .reduce((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2);
        System.out.println(mostCaloricDishOther);


        // Here we are classifying the dishes by their type, therefore we will obtain a map with three keys, Fish, Meat,
        // and other, and each key will have as the value a list of dishes
        Map<Dish.Type, List<Dish>> dishesByType =
                menu.stream().collect(groupingBy(Dish::getType));

        // In this example we are using an Enum to make ourselves a classification method, therefore when grouping every
        // dish we will put them into DIET, NORMAL, or FAT,

        enum CaloricLevel {DIET, NORMAL, FAT}
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(
                groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                }));

        /* Multilevel grouping:
        We can do this by passing a second inner groupingBy to the outer groupingBy as a second argument, defining a
        second level criterion to classify the stream's items.
         */
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
                menu.stream().collect(
                        groupingBy(Dish::getType,
                                groupingBy(dish -> {
                                    if(dish.getCalories() <= 400) return CaloricLevel.DIET;
                                    else if(dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                    else return CaloricLevel.FAT;
                        }))
                );

        // Collecting data in subgroups

        /*
        The collector passed to the outer groupingBy is not limited to another groupingBy, you can use any other
        collector, for instance it's possible to count the number of Dishes in the menu for each type, by passing the
        counting collector as a second argument to the groupingBy collector:
         */
        Map<Dish.Type, Long> typesCount = menu.stream().collect(
                groupingBy(Dish::getType, counting())
        );
        System.out.println(typesCount);

        /*
        You can get the max caloric dish for each type
         */
        Map<Dish.Type, Optional<Dish>> maxCaloricDishByType =
                menu.stream().collect(
                        groupingBy(Dish::getType, maxBy(comparingInt(Dish::getCalories)))
                );

        /*
        Here we can adapt the collector to obtain a different type of value:
         */
        Map<Dish.Type, Dish> mostCaloricDishByType =
                menu.stream().collect(
                        groupingBy(Dish::getType,
                                collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get))
                );

        Map<Dish.Type, Integer> totalCaloriesByType =
                menu.stream().collect(
                        groupingBy(Dish::getType, summingInt(Dish::getCalories))
                );
        System.out.println(totalCaloriesByType);


        /*
        In this case we are only retrieving the caloric level of each dish and storing them into a Set, that way we
        won't have repeated values, the first argument fo the groupingBy is the classifier, after it, we have a map
        that transform the dish to an Enum value, and finally this value is added to the Set value of the corresponding
        Dish.Type key.
         */
        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType =
                menu.stream().collect(
                        groupingBy(Dish::getType, mapping(dish -> {
                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                            else if(dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;
                        }, toCollection(HashSet::new)))
                );
    }
}

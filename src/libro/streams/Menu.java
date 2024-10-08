package libro.streams;

import java.util.Arrays;
import static java.util.Comparator.comparing;
import java.util.List;

public class Menu {

    public static void main(String[] args) {
        List<Dish> menu = getMenu();

        List<String> threeHighCaloricDishesNames =
                menu.stream()
                        .filter(dish -> dish.getCalories() > 400)
                        .sorted(comparing(Dish::getCalories))
                        .map(dish -> dish.getName() + ": " + dish.getCalories())
                        .limit(3)
                        .toList();

        System.out.println(threeHighCaloricDishesNames);
    }

    public static List<Dish> getMenu() {
        return Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));
    }


}

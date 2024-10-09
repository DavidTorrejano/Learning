package libro.streams;

import java.util.List;
import java.util.OptionalInt;

public class SpecializedPrimitiveStreams {
    public static void main(String[] args) {

        List<Dish> dishList = Menu.getMenu();

        int totalCalories = dishList.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println(totalCalories);

        OptionalInt maxCalories = dishList.stream()
                .mapToInt(Dish::getCalories)
                .max();

        int max = maxCalories.orElse(1);

        maxCalories.ifPresent(System.out::println);
        System.out.println(max);

    }
}

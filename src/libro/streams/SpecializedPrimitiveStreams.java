package libro.streams;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

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

        // Numeric ranges
        IntStream evenNumbers = IntStream.rangeClosed(0, 100)
                .filter(n -> n % 2 == 0);


        IntStream aNum = IntStream.rangeClosed(1, 999);

        List<int[]> triple = aNum.boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 999)
                        .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
                        .boxed()
                        .map(b -> new int[]{a, b, (int)Math.sqrt(a*a + b*b)}))
                .toList();

        triple.forEach(arr -> System.out.println("{" + arr[0] + "," + arr[1] + "," + arr[2] + "}"));


    }
}

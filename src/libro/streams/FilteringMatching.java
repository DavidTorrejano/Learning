package libro.streams;

import java.util.List;

import static java.util.Comparator.comparing;

public class FilteringMatching {

    public static void main(String[] args) {

    List<Dish> menu = Menu.getMenu().stream()
            .sorted(comparing(Dish::getCalories))
            .toList();

    if (menu.stream().anyMatch(Dish::isVegetarian)) {
        System.out.println("The menu has vegetarian options");
    }

    if (menu.stream().allMatch(dish -> dish.getCalories() < 1000)) {
        System.out.println("The menu is healthy");
    }

    if (menu.stream().noneMatch(dish -> dish.getCalories() > 900)) {
        System.out.println("There are no fatty options");
    }

    Dish notVeryLowCalorieDish = menu.stream().filter(dish -> dish.getCalories() > 400)
            .findAny().orElseThrow(() -> new RuntimeException("No dish like that was found"));

        System.out.println(notVeryLowCalorieDish);





    }
}

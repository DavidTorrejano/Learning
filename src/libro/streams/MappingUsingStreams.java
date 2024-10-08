package libro.streams;

import java.util.Arrays;
import java.util.List;

public class MappingUsingStreams {
    public static void main(String[] args) {

        List<Dish> menu = Menu.getMenu();
        
        /*
        @map: It's a stream method that receives a function, that is applied to all the objects in the stream
        that way you can extract information or transform that object you are receiving and return a stream of the
        transformed object.
         */
//        List<Integer> dishNames = menu.stream()
//                .map(Dish::getName)
//                .map(String::length)
//                .toList();
//        System.out.println(dishNames);

        List<String> words = Arrays.asList("Hand", "Rice", "Tomato", "Crocodile", "Rhino", "Tomato");

        if (menu.stream().anyMatch(Dish::isVegetarian)) {
                System.out.println("The menu is vegetarian friendly");
        }


       List<Integer> length = words.stream()
               .map(String::length)
               .toList();
       System.out.println(length);


       System.out.println("Testing: ");

       List<String> uniqueCharacters = words.stream()
               .map(word -> word.split(""))
               .flatMap(word -> {
                   System.out.println(Arrays.toString(word));
                   return Arrays.stream(word);
               })
               .distinct()
               .toList();

       System.out.println(uniqueCharacters);



       System.out.println("Squared Numbers: ");
       List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

       List<Integer> squaredNumbers = numbers.stream()
               .map(num -> num * num)
               .toList();
       System.out.println(squaredNumbers);


        System.out.println("flatMap example: ");
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<int[]> pairs = numbers1.stream()
                .flatMap(i ->  numbers2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j})
                )
                .toList();

        pairs.forEach(arr -> System.out.println(Arrays.toString(arr)));

        



//        pairs.forEach(arr -> System.out.println(arr[0] + ", " + arr[1]));

    }
}

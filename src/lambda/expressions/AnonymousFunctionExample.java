package lambda.expressions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
public class AnonymousFunctionExample {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        // Create the predicate to evaluate each number and classify it as even or odd
        Predicate<Integer> isEven = (n) -> n % 2 == 0;

        // calling the static method passing the list and the predicate to classify the numbers
        List<Integer> evenNumbers = filter(numbers, isEven);


        // Print the even numbers
        System.out.println("Even numbers:");
        for (Integer number : evenNumbers) {
            System.out.println(number);
        }
    }

    // Filter a list using a predicate
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T element : list) {
            if (predicate.test(element)) {
                result.add(element);
            }
        }
        return result;
    }
}  
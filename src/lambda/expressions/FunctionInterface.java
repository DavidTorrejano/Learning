package lambda.expressions;

import java.util.*;
import java.util.function.Function;

public class FunctionInterface {

    public static void main(String[] args) {



        Long start = System.nanoTime();
        //________________________________________________________________________________

        Map<String, Integer> nameMap = new HashMap<>();
        String alberto = "Alberto";
        nameMap.put(alberto, null);
        Integer value = nameMap.computeIfAbsent("Alberto", v -> new Random().nextInt(100));

        nameMap.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v));
        System.out.println(value);

        List<String> names = Arrays.asList("admin_Carlos", "user_Antonio", "user_Maria");

        Map<String, List<String>> userGroups = new HashMap<>();


        names.forEach(name ->
            userGroups.computeIfAbsent(name, user -> {
                List<String> groups = new ArrayList<>();
                if (user.startsWith("admin")) {
                    groups.add("administrators");
                }
                groups.add("users");
                return groups;
            }));

        userGroups.forEach((k, v) -> {
            System.out.println("User: " + k);
            System.out.println("Groups: " );
            v.forEach(System.out::println);
        });

        Function<Integer, String> intToString = Objects::toString;
        Function<String, String> quote = str -> "'" + str + "'";

        Function<Integer, String> quoteIntToString = quote.compose(intToString);

        String numToString = quoteIntToString.apply(9);
        System.out.println(numToString);

        System.out.println(intToString.andThen(quote).apply(9));


        //________________________________________________________________________________
        Long end = System.nanoTime();
        long toMiliSeconds = 1000000L;
        System.out.println("Execution time: " + ((end - start)/toMiliSeconds) + " ms.");


    }

}

package older.topics;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UsingOptional {
    public static void main(String[] args) {
        // Three ways to create an Optional ->

        // 1. An empty Optional
        Optional<String> empty = Optional.empty();

        // 2. An optional of a value (String)
        Optional<String> value = Optional.of("Something");

        // 3. A nullable optional, if there is no value, it'll create an empty one
        Optional<String> nullable = Optional.ofNullable(null);

        // Methods ->

        // 1. isPresent() -> this method returns a boolean indicating if a value exists or not
        System.out.println(value.isPresent());

        // 2. ifPresent(Consumer<? super T> consumer) -> this method will execute the consumer if a value is present
        value.ifPresent(System.out::println);

        // 3. orElse(T other) -> This method returns the value if present, if not present, will return a default value
        System.out.println(value.orElse("other 1"));
        System.out.println(nullable.orElse("other 2"));

        // 4. orElseGet(supplier) -> Similar to orElse but instead of a default value, executes the supplier if empty
        System.out.println(empty.orElseGet(() -> "This is from the supplier"));

        // 5. orElseThrow(exceptionSupplier) -> if present, returns the value, if not, throws an exception
        try{
            nullable.orElseThrow(() -> new NumberFormatException("Error created"));
        } catch (NumberFormatException e) {
            System.out.println("5. The exception was thrown");
        }

        // 6. map(mapperFunction) -> Transforms the value contained in the optional if present
        Optional<Integer> lengthValue = value.map(String::length);
        lengthValue.ifPresent(val -> System.out.println("6. map: " + val));

        /* 7. flatMap(Function <? super T, Optional<U>> mapper) -> Like map but if a method in a class, as example
        'user', returns an optional.of(String) if we use map it will return Optional<Optional<String>>, on the other
        hand, using flatMap won't automatically wrap the returned value in an Optional, unless we explicitly write it*/
        Optional<Integer> flatMapLength = value.flatMap(val -> Optional.of(val.length()));
        flatMapLength.ifPresent(s -> System.out.println("7. flatMap: " + s));

        // 8. filter(predicate) -> Filters the value in the optional if present y complies with the predicate
        Optional<String> filteredOptional = value.filter(val -> val.length() > 7);
        filteredOptional.ifPresent(val -> System.out.println("8. filter: " + val));


    }
}

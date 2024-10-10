package libro.streams;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BuildingStreamsOutOfEverything {
    public static void main(String[] args) {

        // You can create a stream of anything by using the static method Stream.of
        // With the next code we create a stream of strings directly using Stream.of.

        Stream<String> stream = Stream.of("Modern ", "Java ", "In ", "Action!");
        stream.map(String::toUpperCase).forEach(System.out::println);

        // You can get an empty stream using the .empty() method
        Stream<String> emptyStream = Stream.empty();

        // Stream from nullable, you can create a stream from a nullable object
        Stream<String> values =
                Stream.of("config", "home", "user")
                        .flatMap(key -> Stream.ofNullable(System.getProperty(key)));

        values.forEach(System.out::println);

        // Creating a Stream from an array of numbers using the static method Arrays.stream(array)

        int[] numbers = {1, 2, 3, 4, 5};

        int sum = Arrays.stream(numbers).sum();
        System.out.println(sum);

        // Here we can create a stream from reading a file line by line, in this example we are separating each word
        // and counting how many of them are unique.
        long uniqueWords = 0;
        try(Stream<String> lines =
                    Files.lines(Paths.get("data.txt"), Charset.defaultCharset())){
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
        }
        catch(IOException e){
            System.out.println("There is not such file");
        }

        // Streams from functions: Here we are creating the Fibonacci series using Stream.iterate()
        // to do this, first we pass an array as the "seed" parameter, then, in the second parameter, we are going to
        // specify what is going to happen next in a sequence with the "seed"
        Stream.iterate(new int[]{0, 1},
                        n -> new int[]{n[1], n[0] + n[1]})
                .mapToInt(a -> a[0])
                .limit(20)
                .forEach(System.out::println);

        // You can also use a predicate to limit the iterating process as you wish to do it
        Stream.iterate(0, n -> n < 100, n ->  n + 5)
                .forEach(System.out::println);



    }
}

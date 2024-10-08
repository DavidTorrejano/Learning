package lambda.expressions;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SupplierInterface {

    public static void main(String[] args) {

        Long start = System.nanoTime();

        Stream.generate(() -> new Random().nextInt(100))
                .limit(10)
                .forEach(System.out::println);

        Supplier<List<String>> listaNombres = () -> Arrays.asList("Mario", "Juan", "Iliana");

        List<String> nombresGenerados = listaNombres.get();
        nombresGenerados.forEach(System.out::println);

        Long end = System.nanoTime();
        long toMiliSeconds = 1000000L;
        System.out.println("Execution time: " + ((end - start)/toMiliSeconds) + " ms.");

    }
}

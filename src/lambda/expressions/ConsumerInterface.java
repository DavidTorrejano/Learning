package lambda.expressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConsumerInterface {

    public static void main(String[] args) {

        List<String> nombres = Arrays.asList("Ana", "Pedro", "María");
        nombres.forEach(System.out::println);

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> modifiedNumbers = new ArrayList<>();

        numeros.forEach((numero) -> {
            numero *= 2;
            modifiedNumbers.add(numero);
        });

        modifiedNumbers.forEach(System.out::println);


    }

}

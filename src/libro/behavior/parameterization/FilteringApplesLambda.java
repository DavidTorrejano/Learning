package libro.behavior.parameterization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;

public class FilteringApplesLambda {

    public static void main(String[] args) {

        // Definimos constantes para los colores de las manzanas
        String GREEN = "green";
        String RED = "red";

        // Creamos una lista de manzanas con diferentes pesos y colores
        List<Apple> apples = Arrays.asList(
                new Apple(189, RED),
                new Apple(150, GREEN),
                new Apple(110, GREEN),
                new Apple(155, RED),
                new Apple(143, RED),
                new Apple(189, GREEN),
                new Apple(136, RED)
        );

        // Creamos un comparador que ordena las manzanas por peso
        Comparator<Apple> byWeight = comparing(Apple::getWeight);

        // Filtramos las manzanas para obtener solo las rojas
        List<Apple> redApples = filter(apples, apple -> RED.equals(apple.getColor()));

        // Ordenamos la lista de manzanas original por peso
        List<Apple> orderedApples = apples.stream()
                .sorted(byWeight).toList();

        // Ordenamos la lista de manzanas original por peso utilizando el método sort
        apples.sort(comparing(Apple::getWeight));

        // Imprimimos cada manzana en la lista ordenada
        orderedApples.forEach(System.out::println);
    }

    // Método genérico para filtrar una lista basada en un predicado
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }
}

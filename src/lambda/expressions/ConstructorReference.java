package lambda.expressions;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import static java.util.Comparator.comparing;

public class ConstructorReference {

    //Creamos un método llamado "map", el cual devuelve una lista de peras y toma como argumento una lista de números
    //y una función de firma (Integer) -> Pear;
     public static List<Pear> map(List<Integer> list, Function<Integer, Pear> f) {
        List<Pear> result = new ArrayList<>();
        for(Integer i: list) {
            result.add(f.apply(i));
        }
        return result;
    }

    public static void main(String[] args) {


        List<Integer> weights = Arrays.asList(7, 3, 4, 10, 11, 5, 90);

        // Al pasar como segundo argumento una referencia al constructor "Constructor reference" estamos implementando
        // el método apply() de manera que creará una nueva manzana pasando al constructor el Integer sobre el cual esté
        // iterando el bucle for.
        List<Pear> pears = map(weights, Pear::new);
        pears.forEach(System.out::println);

        System.out.println("::::::::::::::::::::");

        // Organizamos las Peras usando lambdas, method reference y type inference
        // Si queremos que el orden esté invertido, solo debemos añadir ".reversed()".
        pears.sort(comparing(Pear::getWeight)/*.reversed()*/);

        // Si tuviésemos otros atributos, podríamos usarlo para organizar más los elementos, en caso de que haya
        // dos o más con el mismo peso.
//        pears.sort(comparing(Pear::getWeight).reversed().thenComparing(Pear::getCountry));


        pears.forEach(System.out::println);



    }
}

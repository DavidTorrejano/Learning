package libro.behavior.parameterization;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;


public class LambdasWithDefInter {

    public static String processFile(String ruta, Function<BufferedReader, String> bufferProcessor) throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader(ruta))) {
            return bufferProcessor.apply(br);
        }
    }

    public static <T, R> List<R> contadorDePalabras(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for(T t: list) {
            result.add(function.apply(t));
        }
        return result;
    }


    public static void main(String[] args) {

        String ruta = "C:/Users/davit/OneDrive/Escritorio/Documentos/planAleman.txt";


        String result;
        try {
            result = processFile(ruta, buffer -> {
                try {
                    return buffer.readLine() + "\n" + buffer.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(result);



        List<String> words = Arrays.asList("Hola", "Soy", "David", "hipotálamo", "Abuelito");

        List <Integer> lengths = contadorDePalabras(words, String::length);

        lengths.forEach(System.out::println);

        words.sort(String::compareTo);
        words.forEach(System.out::println);

    }


}


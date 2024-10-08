package programacion.generica.creacion.clases.propias;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");

        // Get the class of the first element
        Class<?> clazz = list.get(0).getClass();

        // Print the class name
        System.out.println("Type of element in list: " + clazz.getName());
    }
}
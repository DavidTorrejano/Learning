package programacion.generica.creacion.clases.propias;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MetodosGenericos {

    public static void main(String[] args) {

        String[] nombres = {"Romen", "Alejandro", "Daniela", "María", "David"};

        System.out.println(ElementoMenor.getMenor(nombres));



    }

}


class MisMatrices {

    public static <T> String getElementos(T[] a) {
        return "El array tiene " + a.length + " elementos";
    }

    public <T> List<T> fromArrayToList(T[] a) {
        return Arrays.stream(a).collect(Collectors.toList());
    }
}

class ElementoMenor {
    public static <T extends Comparable<T>> T getMenor(T[] a) {
        if(a == null || a.length == 0) {
            return null;
        }

      T elementoMenor = a[0];
        for (int i=1; i<a.length; i++){
            if(elementoMenor.compareTo(a[i]) > 0) {
                elementoMenor = a[i];
            }
        }
        return elementoMenor;
    }
}






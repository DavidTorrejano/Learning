package programacion.generica.creacion.clases.propias;

import java.util.ArrayList;
import java.util.List;

public class HerenciaGenericos {

    public static void main(String[] args) {
/*
        Empleado administrativa = new Empleado("Elena", 45, 1500);
        Jefe directoraComercial = new Jefe("Ana", 27, 3500);

        Empleado nuevoEmpleado = directoraComercial;


        Pareja<Empleado> administrativa = new Pareja<>();
        Empleado elena = new Empleado("Elena", 45, 1500);
        administrativa.setPrimero(elena);

        Pareja<Jefe> directoraComercial = new Pareja<>();
        Jefe ana = new Jefe("Ana", 27, 3500);
        directoraComercial.setPrimero(ana);

//        Pareja<Empleado> nuevoEmpleado = directoraComercial;
        Pareja.imprimirTrabajador(administrativa);
        Pareja.imprimirTrabajador(directoraComercial);

 */

        List<String> words = new ArrayList<>();
        words.add("hola");
        words.add("soy");
        words.add("david");

        words.forEach(word -> {
            System.out.println(Word.capitalize(word));
        });



    }
}

class Word {
    public static String capitalize(String word) {
        if (word == null || word.length()==0) {
            return word;
        } else {
            return word.substring(0, 1).toUpperCase() + word.substring(1);
        }
    }
}
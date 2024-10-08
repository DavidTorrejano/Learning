package programacion.generica.arraylist;

import java.util.*;


public class UsoArrayLists {

    public static void main(String[] args) {

        java.util.ArrayList<Empleado> listaEmpleados = new java.util.ArrayList<>();
        listaEmpleados.add(new Empleado("Martín", 23, 8500));
        listaEmpleados.add(new Empleado("Andrés", 21, 7500));
        listaEmpleados.add(new Empleado("Nancy", 30, 9000));
        listaEmpleados.add(new Empleado("Rodrigo", 42, 9500));
        listaEmpleados.add(new Empleado("Alexa", 23, 8500));
        listaEmpleados.add(new Empleado("Pedro", 21, 7500));
        listaEmpleados.add(new Empleado("Daniela", 30, 9000));
        listaEmpleados.add(new Empleado("Sett", 42, 9500));
        listaEmpleados.add(new Empleado("Gwen", 23, 8500));

//        System.out.println("Lista sin ordenar: ");
//        for (Empleado empleado : listaEmpleados) {
//            System.out.println(empleado.dameDatos());
//        }
//        System.out.println("__________________________________");

        Iterator<Empleado> iteradorEmpleados = listaEmpleados.iterator();

        while(iteradorEmpleados.hasNext()){
            System.out.println(iteradorEmpleados.next().dameDatos());
        }

//        System.out.println("Lista ordenada por nombre: ");
//        listaEmpleados.sort(new SortPeople());
//        for (Empleado empleado : listaEmpleados) {
//            System.out.println(empleado.dameDatos());
//        }


    }

}

class Empleado implements Comparable <Empleado> {
    private String nombre;
    private int edad;
    private double salario;

    public Empleado(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public String dameDatos() {
        return """
                Nombre: %s
                Edad: %d
                Salario: %.2f
                """.formatted(nombre, edad, salario);
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public int compareTo(Empleado empleado) {
        return this.nombre.compareTo(empleado.getNombre());
    }
}

class SortPeople implements Comparator<Empleado> {
    @Override
    public int compare(Empleado o1, Empleado o2) {

        return o1.getNombre().compareTo(o2.getNombre());
    }
}
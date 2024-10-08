package programacion.generica.creacion.clases.propias;

public class Empleado {

    private final String nombre;
    private final int edad;
    private final double salario;

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

}

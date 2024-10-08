package programacion.generica.creacion.clases.propias;

public class UsoPareja {

    public static void main(String[] args) {

        Pareja<String> primeraInstancia = new Pareja<>();

        primeraInstancia.setPrimero("David");
        System.out.println(primeraInstancia.getPrimero());

        Persona persona1 = new Persona("Ana");

        Pareja<Persona> segundaInstancia = new Pareja<>();
        segundaInstancia.setPrimero(persona1);

        System.out.println(segundaInstancia.getPrimero().toString());

    }

}

class Persona {
    private String name;

    public Persona(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
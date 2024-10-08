package programacion.generica.arraylist;


import java.io.File;

public class UsoArrayListPropio {

    public static void main(String[] args) {
        ArrayList archivos = new ArrayList(5);

        archivos.add("Juan");
        archivos.add("Andrés");
        archivos.add("María");
        archivos.add("Marcos");
        // No marca ningún problema en tiempo de compilación, sin embargo, lo hará en tiempo de ejecución, lo cual
        // suele ser más inconveniente, es allí donde hacen magia las clases genéricas.
        archivos.add(new File("pedidos.xls"));

        String nombrePersona = (String) archivos.get(4);
        System.out.println(nombrePersona);




    }

}

package acceso.ficheros.ficheros_directorios;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class CreandoArchivos {
    public static void main(String[] args) {

        String separator = File.separator;

        File ruta = new File("""
                C:%s
                Users%s
                Public%s
                java_test%s
                nueva_carpeta%s
                archivo_nuevo.txt
                """.
                formatted(separator, separator, separator, separator, separator)
                .replace("\n", "")
                .trim());

        // Para crear una carpeta en la ruta especificada
//        ruta.mkdir();


//        try {
//            boolean created = ruta.createNewFile();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

//        String archivoDestino = ruta.getAbsolutePath();

//        Escribiendo accede_es = new Escribiendo();
//        String frase = "Esto es lo que debemos escribir";
//
//        accede_es.escribir(archivoDestino, frase);

        boolean eliminado = ruta.delete();
        System.out.println(eliminado ? "Se eliminó el archivo." : "Algo falló.");

    }

}
class Escribiendo {

    public void escribir (String rutaArchivo, String texto) {

        try {
            FileWriter escritura = new FileWriter(rutaArchivo);
            BufferedWriter buffer = new BufferedWriter(escritura);

            for(char letra : texto.toCharArray()){
                buffer.write(letra);
            }

            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
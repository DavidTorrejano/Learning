package acceso.ficheros.ficheros_directorios;

import java.io.File;

public class Pruebas_Rutas {

    public static void main(String[] args) {

        String separator = File.separator;

        File ruta = new File("""
                C:%s
                Users%s
                Public%s
                java_test
                """.
                formatted(separator, separator, separator)
                .replace("\n", "")
                .trim());

        String [] nombresArchivos = ruta.list();

        if (nombresArchivos != null) {
            for (String fileName : nombresArchivos) {
                System.out.println(fileName);
                File iteratedFile = new File(ruta.getAbsolutePath(), fileName);

                if (iteratedFile.isDirectory()){
                    String[] filesInSubDirectory = iteratedFile.list();
                    for (String file : filesInSubDirectory) {
                        System.out.println("|  " + file);
                    }
                }
            }
        }




    }


}

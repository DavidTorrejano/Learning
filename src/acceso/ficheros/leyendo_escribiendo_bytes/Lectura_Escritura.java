package acceso.ficheros.leyendo_escribiendo_bytes;

import java.io.*;

public class Lectura_Escritura {

    public static void main(String[] args) {

        long startTime = System.nanoTime();
        int contador = 0;

        int [] datos_entrada = new int[2786586];

        try {

            FileInputStream archivoLectura =
                    new FileInputStream("C:/Users/davit/OneDrive/Escritorio/java_usable/leon.png");

            BufferedInputStream buffer = new BufferedInputStream(archivoLectura);

            boolean continuarLeyendo = true;

            while(continuarLeyendo) {
                int byteEntrada = buffer.read();


                if(byteEntrada != -1)
                    datos_entrada[contador] = byteEntrada;
                else
                    continuarLeyendo = false;

                contador++;
            }
            archivoLectura.close();

        } catch (IOException ioException){
            ioException.printStackTrace();
        }


        crea_fichero(datos_entrada);

        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        long miliSec = duration / 1000000;
        System.out.println("Execution time: " + miliSec + " ms");

    }

    static void crea_fichero(int[] datosNuevoFichero) {

        try{
            FileOutputStream ficheroNuevo =
                    new FileOutputStream("C:/Users/davit/OneDrive/Escritorio/java_usable/copia2.png");

            BufferedOutputStream outputStream = new BufferedOutputStream(ficheroNuevo);

            for (int byteImage : datosNuevoFichero) {
                outputStream.write(byteImage);
            }

            outputStream.close();

        } catch (IOException e) {
            System.out.println("Error al crear el archivo");
            e.printStackTrace();
        }

    }

}

class Employee implements Serializable{

    private String nombre;
    private String apellido;
    private int salario;

    public Employee(String nombre, String apellido, int salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

}

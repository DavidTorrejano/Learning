package acceso.ficheros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AccesoFicheros {

    public static void main(String[] args) {

        LeeFichero leerDoc = new LeeFichero();
        System.out.println(leerDoc.leeArchivo().toUpperCase());


    }
}


class LeeFichero {

    public String leeArchivo() {

        StringBuilder text = new StringBuilder();

        try {
            FileReader input = new FileReader("C:/Users/davit/OneDrive/Escritorio/archivoParaLeer.txt");
            BufferedReader bufferedReader = new BufferedReader(input);

//            int character = input.read();
            String line = "";

//            while(character != -1) {
//                char letter = (char) character;
//                text.append(letter);
//                character = input.read();
//            }

            while(line != null) {
                line = bufferedReader.readLine();
                if (line != null) {
                    text.append(line).append("\n");
                }
            }

            input.close();

        } catch (IOException e) {
            System.out.println("Un error ha ocurrido");
            e.printStackTrace();
        }
        return text.toString();
    }
}

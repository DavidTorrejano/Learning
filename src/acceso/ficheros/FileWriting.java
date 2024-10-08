package acceso.ficheros;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriting {

    public static void main(String[] args) {

        Writing letsWrite = new Writing();
        letsWrite.write();

    }
}


class Writing {
    public void write() {
        String phrase = "This is a writing test 2";

        try {
            FileWriter writer = new FileWriter("C:/Users/davit/OneDrive/Escritorio/file_note.txt");

            for (int i=0; i<phrase.length(); i++) {
                writer.write(phrase.charAt(i));
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
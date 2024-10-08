package libro.behavior.parameterization;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UsingLambdas {

    public static String processFile(String ruta, BufferedReaderProcessor bufferProcessor) throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader(ruta))) {
            return bufferProcessor.process(br);
        }
    }

    public static void main(String[] args) {

        try {
            String result = UsingLambdas.processFile("data.txt", (BufferedReader buffer)
                    -> buffer.readLine() + buffer.readLine());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}


@FunctionalInterface
interface BufferedReaderProcessor {
    String process(BufferedReader bufferedReader) throws IOException;
}


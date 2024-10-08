package libro.behavior.parameterization;

import java.io.File;

public class MethodReferences {

    public static void main(String[] args) {

        File[] hiddenFiles = new File(".").listFiles(File::isHidden);
        
        System.out.println(hiddenFiles);

    }

}



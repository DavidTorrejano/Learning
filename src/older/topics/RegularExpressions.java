package older.topics;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class RegularExpressions {
    public static void main(String[] args) {

        Stream<String> words = Stream.of("john", "jack", "phillip", "antoni", "pit");
        List<Character> result = words
                // Regular expressions, it is usable between programming languages
                // This one means that the word (w) should be written using lowercase words from a to p, and the word
                // can contain more than a single letter
                .filter(w -> w.matches("[a-p]+"))
                .map(w -> w.charAt(2))
                .toList();
        System.out.println(result);

        //fahrenheit converter to Celsius
        Scanner scanner = new Scanner(System.in);

        //Requesting the temperature from user in Fahrenheit
        System.out.println("Enter the Fahrenheit temperature");
        String strFahTemp = scanner.next();

        // Checking if the input is a valid integer
        boolean acceptableInput = strFahTemp.matches("[+-]?\\d+");

        // Converting and displaying the temperature in Celsius
        if (acceptableInput) {
            int fahTemp = Integer.parseInt(strFahTemp);
            double celTemp = (fahTemp - 32) * 5.0 / 9.0;
            System.out.printf("%d F is %.2f Celsius.\n", fahTemp, celTemp);
        } else {
            System.out.println(strFahTemp + " is not a valid integer.");
        }

        // Checking the course codes
        Checker checker = new CourseCodeChecker();
        System.out.println("Please introduce a course code to verify it:");
        String courseCode = scanner.next();

        if (checker.check(courseCode)) {
            System.out.println("That is a correct code, go ahead, you are hired");
        } else {
            System.out.println("I am sorry, that is not a real course code.");
        }


    }
}

interface Checker {
    boolean check(String text);
}

class CourseCodeChecker implements Checker{
    @Override
    public boolean check(String text) {
        // This is to check that the code starts with 4 letters upper or lower case, and followed by 5 numbers.
        return text.matches("[A-z]{4}\\d{5}");
    }
}

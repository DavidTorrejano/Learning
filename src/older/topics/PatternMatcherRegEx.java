package older.topics;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherRegEx {
    public static void main(String ...args) {
        Scanner scanner = new Scanner(System.in);
        GradeCalculation grade = new ThreeGradesCalculator();

        System.out.println("Enter the three grades separated by space if needed use (.) as decimal separator: ");
        String grades = scanner.nextLine();
        double weightedAverage = grade.calculate(grades);

        if (weightedAverage == -1) {
            System.out.println("I am sorry, one or more of the introduced values are not valid");
        } else {
            DecimalFormat formated = new DecimalFormat("#.##");
            System.out.println("The weighted average is: " + formated.format(weightedAverage) + "%");
        }
    }
}

// This interface defines the main method for the grades calculation
interface GradeCalculation {
    double calculate(String grades);
}

class ThreeGradesCalculator implements GradeCalculation {
    // Here we'll convert from string to a list of doubles using streams
    private List<Double> convertFromStrToDouble(String ex) {
        return Arrays.stream(ex.trim().split(" "))
                .map(Double::parseDouble)
                .toList();
    }
    // Here we check that the introduced grade has the format (## ## ##) or (##.## ##.## ##.##)
    private boolean checkExpression(String ex) {
        Pattern regex = Pattern.compile("(\\d{2}.?\\d*\\s){2}\\d{2}.?\\d* ?");
        Matcher validation = regex.matcher(ex.trim());
        return validation.matches();
    }

    @Override
    public double calculate(String grades) {
        // In this if, just to make it general, we will return -1 if the format doesn't match the pattern
        if (!checkExpression(grades)) return -1;
        List<Double> gradesDouble = convertFromStrToDouble(grades);
        // The value of each "exam"
        List<Integer> examValue = Arrays.asList(15, 25, 35);
        double finalGrade = 0;
        int EXAM_MARKS = 50;

        for (int i = 0; i<gradesDouble.size(); i++) {
            finalGrade += gradesDouble.get(i) / EXAM_MARKS * examValue.get(i);
            if (gradesDouble.get(i) < 0 || gradesDouble.get(i) > 50) {
                return -1;
            }
        }
        return finalGrade / 75 * 100;
    }
}
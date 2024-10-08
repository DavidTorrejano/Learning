package libro.behavior.parameterization;

import java.util.Arrays;
import java.util.List;

public class FilteringApples {

    public static void main(String[] args) {

        String RED = "red";
        String GREEN = "green";

        List<Apple> apples = Arrays.asList(
          new Apple(189, RED),
          new Apple(150, RED),
          new Apple(110, GREEN),
          new Apple(155, GREEN),
          new Apple(143, RED),
          new Apple(189, GREEN),
          new Apple(136, RED)
        );

        FilteringApples.prettyPrintApple(apples, new PrintOnlyTheWeight());

        FilteringApples.prettyPrintApple(apples, new PrintAppleAndSayWhetherIsHeavyOrLight());


    }
    public static void prettyPrintApple(List<Apple> inventory, AppleToString formatter) {
        for (Apple apple: inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }



}



class Apple {
    private Integer weight;
    private String color;

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Its a " + this.getWeight() + "g " + this.getColor() + " apple.";
    }
}

interface AppleToString {
    String accept(Apple apple);
}

class PrintOnlyTheWeight implements AppleToString {
    @Override
    public String accept(Apple apple) {
        return String.valueOf(apple.getWeight());
    }
}

class PrintAppleAndSayWhetherIsHeavyOrLight implements AppleToString {
    @Override
    public String accept(Apple apple) {
        StringBuilder cadena = new StringBuilder();
        cadena.append("The apple is ")
                .append(apple.getColor());

        if (apple.getWeight() > 150) cadena.append(", and it's heavy.");
        else cadena.append(", and it's light.");
        return cadena.toString();
    }
}
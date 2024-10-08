package older.topics;

public class AbstractLearning {

    public static void main(String[] args) {

        Circle small = new Circle("Balón", 8);
        System.out.println("The area is: " + small.getArea());
        small.printShapeName();

    }

}

abstract class Shape {

    public String name;

    public Shape(String name) {
        this.name = name;
    }

    abstract double getArea();
    abstract double getPerimeter();

    public void printShapeName() {
        System.out.println("Soy un " + name);
    };
}

class Circle extends Shape{

    private final double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}
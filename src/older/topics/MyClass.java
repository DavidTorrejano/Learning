package older.topics;

// Instance Initialization Block
public class MyClass {
    {
        System.out.println("Instance initialization block");
    }

    private int myVar;

    {
        myVar = 10;
        System.out.println("Another instance block " + myVar);
    }

    public MyClass() {
        System.out.println("Constructor");
    }
}

// Static Initialization Block
class MyStaticClass {
    static {
        System.out.println("Static initialization block");
    }

    private static int staticVar;

    static {
        staticVar = 20;
        System.out.println("Another static block");
    }

    public MyStaticClass() {
        System.out.println("Constructor");
    }
}

// Main class to demonstrate execution order
class Main {
    public static void main(String[] args) {
        System.out.println("Creating first instance of MyClass:");
        MyClass obj1 = new MyClass();

        System.out.println("\nCreating second instance of MyClass:");
        MyClass obj2 = new MyClass();

        System.out.println("\nCreating first instance of MyStaticClass:");
        MyStaticClass staticObj1 = new MyStaticClass();

        System.out.println("\nCreating second instance of MyStaticClass:");
        MyStaticClass staticObj2 = new MyStaticClass();
    }
}
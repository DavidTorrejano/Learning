package lambda.expressions;

public class Lambda_first {
    public static void main(String[] args) {

        Test t = new Test();
        t.meth2();

    }
}

interface Inter {
    void meth1();
}


class Test {

    int x = 10;

    public void meth2() {

        int y = 20;
        System.out.println(x);
        
        Inter inter = () -> {
            x = 888;
            System.out.println(x);
            System.out.println(y);
        };
        inter.meth1();

    }
}

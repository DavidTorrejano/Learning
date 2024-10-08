package older.topics;

import java.util.function.Consumer;

public class ConsumerDemo {

    public static void main(String[] args) {

        Consumer<String> consumer = (String s) -> System.out.println(s);

        consumer.accept("David");

    }
}

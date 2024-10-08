package lambda.expressions;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Supplier;

public class MethodReference {

    static void print(String s) {
        Consumer<String> print = System.out::println;
        print.accept(s);
    }

    static void print(Integer i) {
        IntConsumer print = System.out::println;
        print.accept(i);
    }

    public static void main(String[] args) {



        Transaction expensiveTransaction = new Transaction(1000.0);

        // Usando el Method Reference a un método de instancia de un objeto específico
        Supplier<Double> getValueFunction = expensiveTransaction::getValue;

        // Aplicando la función
        double value = getValueFunction.get();

        System.out.println("Valor de la transacción: " + value); // Imprime "Value: 1000.0"

        Function<String, Integer> stringLengthFunc = String::length;
        String sentence = "It is a beautiful day";
        int length = stringLengthFunc.apply(sentence);
        print(length);
        print("Hello I am trying my new print");


    }
}


class Transaction {
    private double value;

    public Transaction(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
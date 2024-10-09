package libro.streams.into_practice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;

public class Exercises {

    public static List<Transaction> getTransactions() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");


        return Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }

    public static void main(String[] args) {

        List<Transaction> transactions = getTransactions();

        // Exercise 1. Find all transactions in the year 2011 and sort them by value (small to high).
        System.out.println("1. Transactions in 2011, sorted from smaller to higher: ");
        transactions.stream().filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .forEach(System.out::println);
        System.out.println("===================================================");

        // Exercise 2. What are all the unique cities where the traders work?
        System.out.println("2. Unique cities traders work at: ");
        transactions.stream().map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
        System.out.println("===================================================");

        // Exercise 3. Find all traders from Cambridge and sort them by name.
        System.out.println("3. Traders from Cambridge organized by name: ");
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equalsIgnoreCase("cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .forEach(System.out::println);
        System.out.println("===================================================");

        // Exercise 4. Return a string of all traders’ names sorted alphabetically.
        System.out.println("4. Traders' names in a single string sorted alphabetically: ");
        String namesTogether =
                transactions.stream()
                        .map(transaction -> transaction.getTrader().getName())
                        .distinct()
                        .sorted()
                        .reduce("", (a, b) -> a + " " + b);
        System.out.println(namesTogether);
        System.out.println("===================================================");

        // Exercise 5. Are any traders based in Milan?
        System.out.println("5. Are there any traders in Milan?");

        boolean anyTraderInMilan =
                transactions.stream()
                .anyMatch(transaction -> transaction.getTrader()
                        .getCity()
                        .equalsIgnoreCase("milan"));
        System.out.println(anyTraderInMilan);

        System.out.println("===================================================");

        // Exercise 6. Print the values of all transactions from the traders living in Cambridge.
        System.out.println("Values of all transactions from traders living in Cambridge");
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equalsIgnoreCase("cambridge"))
                .forEach(transaction -> System.out.println(transaction.getValue()));
        System.out.println("===================================================");

        // Exercise 7. What’s the highest value of all the transactions?
        System.out.println("The highest value of all the transactions is (Only the value): ");
        int maxValue = transactions.stream().map(Transaction::getValue)
                .reduce(0, Integer::max);
        System.out.println(maxValue);
        System.out.println("===================================================");

        // Exercise 7. What’s the highest value of all the transactions?
        System.out.println("The highest value of all the transactions is (The transaction): ");
         Optional<Transaction> highestTransactionValue =
                 transactions.stream()
                         .max(comparing(Transaction::getValue));
        highestTransactionValue.ifPresent(System.out::println);
        System.out.println("===================================================");

        // Exercise 8. Find the transaction with the smallest value.
        System.out.println("Transaction with the smallest value.");
        Optional<Transaction> lowestTransactionValue =
                transactions.stream()
                        .min(comparing(Transaction::getValue));

        lowestTransactionValue.ifPresent(System.out::println);

        System.out.println("===================================================");


    }
}

package libro.streams;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class TransactionExample {

    public static void main(String[] args) {

        Currency usd = new Currency("USD");
        Currency cad = new Currency("CAD");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(1200, usd),
                new Transaction(1500, cad),
                new Transaction(700, usd),
                new Transaction(1050, usd),
                new Transaction(1100, cad),
                new Transaction(1600, usd),
                new Transaction(1900, cad),
                new Transaction(4000, usd),
                new Transaction(1090, cad)
        );



        Map<Currency, List<Transaction>> transactionsByCurrencies =
                transactions.stream().filter(transaction -> transaction.price() > 1000)
                        .collect(groupingBy(Transaction::currency));


        transactionsByCurrencies.forEach((currency, transactionsList) -> {
            System.out.println("Currency: " + currency.name());
            System.out.println("Transactions: ");
            transactionsList.forEach(transaction -> System.out.println(transaction.price()));
        });



    }


}

record Transaction (int price, Currency currency) {

}

record Currency (String name) {}

//class Currency {
//    private final String currency;
//
//    public Currency(String currency) {
//        this.currency = currency;
//    }
//
//    public String getName() {
//        return currency;
//    }
//}




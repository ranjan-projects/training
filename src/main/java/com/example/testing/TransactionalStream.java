package com.example.testing;

import com.example.testing.model.Transaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TransactionalStream {

    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
    private static List<Transaction> transactions = Collections.emptyList();

    public static void main(String[] args) {

        Transaction tx1 = populateTransactions(10.40, "card", "Morrisons", "Groceries", LocalDate.parse("01/Nov/2020",dtf));
        Transaction tx2 = populateTransactions(600, "direct debit", "CYBG", "MyMonthlyDD", LocalDate.parse("28/Oct/2020",dtf));
        Transaction tx3 = populateTransactions(40, "direct debit", "PureGym", "MyMonthlyDD", LocalDate.parse("28/Oct/2020",dtf));
        Transaction tx4 = populateTransactions(5.99, "card", "M&S", "Groceries", LocalDate.parse("01/Oct/2020",dtf));
        Transaction tx5 = populateTransactions(10, "internet", "McMillan", "null", LocalDate.parse("20/Sep/2020",dtf));
        Transaction tx6 = null;

        transactions = Arrays.asList(tx1,tx2,tx3,tx4,tx5,tx6);

        getTransactionsByCategories(transactions).forEach(System.out::println);
        /*getTransactionTotalByCategory(transactions).forEach((k,v) -> {
            System.out.println(k + ":" + v);
        });*/
        /*getHighestSpendTransactionByCategory(transactions).forEach((k,v) -> {
            System.out.println(k + ":" + v);
        });*/
    }



    //getTransactionByCategorySorted
    //getTransactionTotalByCategory
    //getMonthlySpendByCategory
    //getHighestSpendByCategoryForYear
    //getLowestSpendByCategoryForYear



    private  static List<Transaction> getTransactionsByCategories(List<Transaction> transactions) {

        List<String> category = Arrays.asList(new String[]{  "MyMonthlyDD" , "Groceries" });

        Predicate<Transaction> categoryFilter = t ->  null != t.getCategory() && category.stream().anyMatch(c -> c.equalsIgnoreCase(t.getCategory()));

        return Optional.ofNullable(transactions).orElseGet(Collections::emptyList).stream()
                        .filter(Objects::nonNull)
                        .filter(categoryFilter)
                        .sorted(Comparator.comparing(Transaction::getTransactionDate).reversed())
                        .collect(Collectors.toList());
    }

    //getTransactionTotalByCategory
    private  static Map<String, Double> getTransactionTotalByCategory(List<Transaction> transactions) {

        return Optional.ofNullable(transactions).orElseGet(Collections::emptyList).stream()
                        .filter(Objects::nonNull)
                        .collect(Collectors.groupingBy(Transaction::getCategory ,Collectors.summingDouble(Transaction::getAmt)));
    }

    //getTransactionByCategorySorted
    private static List<Transaction> getTransactionByCategorySorted(List<Transaction> transactions , String category) {

        Predicate<Transaction> categoryFilter = t ->  null != t.getCategory() && t.getCategory().equalsIgnoreCase(category);

        return Optional.ofNullable(transactions).orElseGet(Collections::emptyList).stream()
                        .filter(Objects::nonNull)
                        .filter(categoryFilter)
                        .sorted(Comparator.comparing(Transaction::getTransactionDate).reversed())
                        .collect(Collectors.toList());
    }

    //getTransactionByCategorySorted
    private static Map<String, Optional<Transaction>> getHighestSpendTransactionByCategory(List<Transaction> transactions) {

        return Optional.ofNullable(transactions).orElseGet(Collections::emptyList).stream()
                        .filter(Objects::nonNull)
                        .collect(Collectors.groupingBy(Transaction::getCategory, Collectors.maxBy(Comparator.comparingDouble(Transaction::getAmt))));

    }


    private static Transaction populateTransactions(double amt, String type, String vendor, String Category, LocalDate date) {
        return Transaction.builder()
                        .amt(amt)
                        .category(Category)
                        .transactionDate(date)
                        .transactionType(type)
                        .vendor(vendor)
                        .build();
    }
}

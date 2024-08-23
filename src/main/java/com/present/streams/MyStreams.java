package com.present.streams;

import com.present.streams.model.Account;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyStreams {

        static Account umeshAccount;
        static Account andyAccount;
        static Account shalieshAccount;
        static Account janaAccount;
        static Account harishAccount;


        //Streams method
        // intermediary -> Any Method that returns back streams of same type is Intermediary

        //final -> Any method that returns other than stream


        public static void main(String[] args) {
            Stream<Account> accountsStream = Stream.of(umeshAccount,andyAccount,shalieshAccount,janaAccount, harishAccount);

            //System.out.println(accountsStream.max(Comparator.comparing(Account::getAccountBalance)));
            //System.out.println(accountsStream.count());
            //System.out.println(accountsStream.collect(Collectors.groupingBy(Account::getBankType,Collectors.counting())));




            /* Function takes an object and return another object BI function takes two params and returns third.
            Can be used to merge two list and create another list
            */
           /* Function<Account, String> concatenatedStringFunction = account -> {
              return account.getAccountName() + "-> "+ account.toString();
            };
            accountsStream.map(concatenatedStringFunction).forEach(System.out::println);*/


            /*
            Consumer takes a object. Does not return any thing.  Same way we have BiConsumer for two objects.
            Consumer<Account> printConsumerMethodReference = System.out::println;
            Consumer<Account> printConsumerLambda = account -> {
                System.out.println(account.toString());
                System.out.println("++++++++++++++");
            };
            accountsStream.forEach(printConsumerLambda)*/;

            /*
            Predicates takes object as param and evaluates it to boolean
            Predicate<Account> savingsGreaterThan10000 = account -> account.getAccountBalance() > 10000;
            System.out.println(accountsStream.filter(savingsGreaterThan10000).findFirst());
            accountsStream.forEach(printConsumerLambda);
             */

            /*
            removing dupes and then you can collect it to list
            //System.out.println(accountsStream.count());
            //accountsStream.distinct().forEach(System.out::println);
            */

            /*//supplier
            <R> R collect(Supplier<R> supplier,
                            BiConsumer<R,? super T> accumulator,
                            BiConsumer<R,R> combiner)
            This method performs a mutable reduction operation on the elements of this stream.

                            Type Parameter:
            R - type of the result
            Parameters:
            supplier - a function that creates a new result container (mutable object) . For a parallel execution, this function may be called multiple times. It must return a fresh value each time.
            accumulator - a function for incorporating an additional element into a result.
                            combiner - a function for combining two values, used in parallel stream, combines the results received from different threads.*/
            /*String s = accountsStream.collect(StringBuilder::new,
                            (collector, account) -> collector.append(",").append(account.getAccountName()),
                            (collector1, collector2) -> collector1.append(collector2.toString())).toString();

            System.out.println(s);*/


            /*System.out.println(accountsStream.map( Account::getAccountName )
                            .collect( Collectors.joining( "," ) ));*/



            // to map
            accountsStream.collect(Collectors.toMap(Account::getBankType,Function.identity(), BinaryOperator.minBy(Comparator.comparing(Account::getAccountNo)))).forEach((x,y) -> {
                System.out.println(x + "" + y);
            });

        }


        static {
            umeshAccount = Account.builder().accountBalance(9999).bankType("VM").accountNo(01).accountName("umesh").build();
            andyAccount = Account.builder().accountBalance(10001).bankType("VM").accountNo(02).accountName("andy").build();
            shalieshAccount = Account.builder().accountBalance(9999.50).bankType("YB").accountNo(03).accountName("shailesh").build();
            janaAccount = Account.builder().accountBalance(10000.50).bankType("CB").accountNo(04).accountName("jana").build();
            harishAccount = Account.builder().accountBalance(10000).bankType("VM").accountNo(05).accountName("harish").build();
        }






}

package pratice.TradeAndTransaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;


import static java.util.stream.Collectors.toList;

/**
 * Created by Amit on 5/18/2015.
 */
public class BookSolution {


    public static void main(String args[])
    {
        {

            Trader rat = new Trader("rat", "cambridge");
            Trader cat = new Trader("cat", "Milan");
            Trader snake = new Trader("snake", "amazon");
            Trader tiger = new Trader("tiger", "cambridge");
            Trader lion = new Trader("Loin","cambridge");

            List<Transaction> transactions = Arrays.asList(
                    new Transaction(rat, 2011, 200),
                    new Transaction(cat, 2013, 300),
                    new Transaction(snake, 2012, 1000),
                    new Transaction(cat, 2014, 700),
                    new Transaction(tiger, 2016, 900),
                    new Transaction(tiger, 2001, 400),
                    new Transaction(cat, 2001, 600),
                    new Transaction(cat, 2011, 700),
                    new Transaction(cat, 2015, 200),
                    new Transaction(rat, 2010, 100),
                    new Transaction(snake, 2011, 400)
            );




        /* Finding all the transaction in year 2011 and sorting them*/

            List<Transaction> year2011 = transactions.stream()
                    .filter(t -> t.getYear() == 2011)
                    .sorted(Comparator.comparing(Transaction::getValue))
                    .collect(toList());

            year2011.stream().forEach(System.out::println);

            System.out.println("--------------------------------------------------------------------");


            /*  Find All Trade From Cambridge  and Sort them By name*/

            List<Trader> traders  = transactions.stream()
                                        .map(Transaction::getTrader)
                                        .filter(t->t.getCity().equals("cambridge"))
                                        .distinct()
                                        .sorted(Comparator.comparing(Trader::getName))
                                        .collect(toList());


            traders.stream().forEach(System.out::println);


            /*  Return of String of all Trader name sorted alphabetically   */

            String traderStr  = transactions.stream()
                                .map(Transaction::getTrader).map(Trader::getName).
                                distinct().sorted().reduce("" , (n1 , n2) ->n1+n2);

            System.out.println("Sorted Name is    "+traderStr);

            System.out.println("--------------------------------------------------------------------");

            boolean milanBased  = transactions.stream().anyMatch(transaction -> transaction.getTrader().getCity().equals("milan"));

            System.out.println("Milan Based is -----   "+milanBased);




            // Using Numeric Streams

            // Problem using the normal stream is  it include lot of boxing and unboxing

            /* Primitive stream specialization IntSteam , DoubleStream and LongStream  to tackel these condition*/

            int cost = transactions.stream().mapToInt(Transaction::getValue).sum();

            System.out.println("Total cost is "+cost);


            // Converting back to the stream of Objects

            IntStream intStream = transactions.stream().mapToInt(Transaction::getValue);

           // intStream.forEach(System.out::println);

            //Converting back

            Stream<Integer> stream = intStream.boxed();

            System.out.print("Sys outing stream");
            stream.forEach(System.out::println);

            // Default Values :OptionalInt
            /* Optional can be parameterized with reference type such as Integer ,  String , and so on
             */

            OptionalInt maxCost =  transactions.stream().mapToInt(Transaction::getValue).max();

            System.out.println("Maximun Cost is "+maxCost);


            //  Java 8 introduces two static method  available on IntStream and LongStream to help generate such
            // ranges: range and rangeClosed
            /* Both Method take the starting value of the range as the first parameter and the end value of the range
             * as the second parameter  But range is exclusive whereas rangeClosed in inclusive  */


            IntStream  evenNumber = IntStream.rangeClosed(1,100).filter(d->d%2==0);

           System.out.println("------------------------------------------------");

            System.out.println("even numbers are  ");

            evenNumber.forEach(System.out::println);

            System.out.println("------------------------------------------------");


            // Doing the same with the range

            IntStream  evenNumberOpenRange = IntStream.range(1, 100).filter(d->d%2==0);

            System.out.println("------------------------------------------------");

            System.out.println("even numbers open range  ");

            evenNumberOpenRange.forEach(System.out::println);

            System.out.println("------------------------------------------------");








        }
    }

}

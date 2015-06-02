package pratice.TradeAndTransaction;

import com.sun.corba.se.impl.naming.cosnaming.TransientNameServer;

import java.util.Arrays;
import java.util.List;


import static java.util.stream.Collectors.toList;

/**
 * Created by Amit on 5/18/2015.
 */
public class MainClass {

    public static void main(String args[]) {

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
                                    .filter(t-> t.getYear()==2011)/*.map(t->t.getTrader().getName())*/
                                    .sorted((a,b)->a.getTrader().getName().compareTo(b.getTrader().getName()))
                                    .collect(toList());

        System.out.println("--------------------------------------------------------------------");

        System.out.println("Transaction in year 2011>");

        year2011.stream().forEach(System.out::println);

        System.out.println("--------------------------------------------------------------------");

        System.out.println("Finding All The Cities Where The Trader Works");

        List<String> uniqueCities  = transactions.stream().
                map(t->t.getTrader()
                        .getCity())
                        .distinct()
                        .collect(toList());

        uniqueCities.stream().forEach(System.out::println);

        System.out.println("--------------------------------------------------------------------");

        System.out.println(" Finding All Traders from Cambridge  and sort them by name ");


        List<Trader> traders = transactions.
                                        stream().
                                        filter(t->t.getTrader().getCity().equals("cambridge")).
                                        map(t->t.getTrader()).collect(toList());


        traders.stream().forEach(System.out::println);






        System.out.println("--------------------------------------------------------------------");

        System.out.print("Are Any Trader Based in Milan");

        boolean result = transactions.stream().filter(t->t.getTrader().getCity().equals("milan")).findAny().isPresent();

        System.out.println("    " + result);

        System.out.println("--------------------------------------------------------------------");


        System.out.print("Finding highest value of all The Transaction");

        int highest = transactions.stream().map(t->t.getValue()).reduce(Integer::max).get().intValue();

        System.out.println("   "+highest);

        System.out.println("--------------------------------------------------------------------");




    }




}

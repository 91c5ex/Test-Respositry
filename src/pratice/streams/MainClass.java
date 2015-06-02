package pratice.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by Amit on 5/14/2015.
 */
public class MainClass {

    public static void main(String args[]) {
        List<Dish> menu = Arrays.asList(

                new Dish("pork", false, 9000, Dish.Type.MEAT),
                new Dish("beef", false, 200, Dish.Type.MEAT),
                new Dish("chicken", false, 900, Dish.Type.MEAT),
                new Dish("french fries", true, 400, Dish.Type.OTHER),
                new Dish("rice", true, 800, Dish.Type.OTHER),
                new Dish("season fruit", true, 800, Dish.Type.OTHER),
                new Dish("pizza", true, 1000, Dish.Type.OTHER),
                new Dish("prawns", false, 990, Dish.Type.FISH),
                new Dish("salmon", false, 890, Dish.Type.FISH),
                new Dish("shark", false, 700, Dish.Type.FISH),
                new Dish("whale", false, 10000, Dish.Type.FISH)
        );


        List<String> threeHighCaloriesDishName = menu.stream()
                .filter(d -> {
                    System.out.println("filtering             " + d.getName());
                    return d.getCalories() > 900;
                }).sorted((a, b) -> {
                    System.out.println("Comparing a with b      " + a.getName() + "   " + a.getCalories() + " " + b.getName() + " " + b.getCalories());
                    return a.getCalories() > b.getCalories() ? 1 : -1;
                })
                .map(/*Dish::getName*/
                        //SECOND METHOD
                        d -> {
                            System.out.println("Mapping                " + d.getName());
                            return d.getName();
                        }

                )
                .limit(4)
                .collect(toList());

        System.out.println("LIST of High Calories Dishes\n" + threeHighCaloriesDishName);


        System.out.println("-------------------------------------------------------------------\n");


        List<Dish> vegitarianDishes = menu.stream()
                .filter(dish/*::isVegetarina*/ -> {
                    System.out.println(" is dish  vegetarian " + dish.isVegetarina());
                    return dish.isVegetarina();
                })
                .collect(toList());


        System.out.println("Vegitaian Dishes are \n" + vegitarianDishes);


        System.out.println("-------------------------------------------------------------------\n");

        System.out.println("Filtering Unique Elements-------      ");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 2, 2, 4, 4, 4);


        numbers.stream().filter(digit -> (digit % 2 == 0)).distinct().forEach(System.out::println);


        System.out.println("-------------------------------------------------------------------\n");

        System.out.println("Filter first two meat dishes");


        List<Dish> firstTwoMeatDish = menu.stream().filter(d -> d.getType() == Dish.Type.MEAT).limit(2).collect(toList());

        System.out.println("First two Meat Dish are " + firstTwoMeatDish);


        System.out.println("-------------------------------------------------------------------\n");


        System.out.println("Finding the length of the Vegetarian Dishes");

        List<Integer> lenghtOfMeatDishes = menu.stream()
                .filter(d -> d.getType() == Dish.Type.OTHER)
                .map(Dish::getName)
                .map(String::length)
                .collect(toList());

        System.out.println("-------------------------------------------------------------------\n");

        System.out.println("---------------- Incorrect Use of the Map-----------------------------");


        List<String> words = Arrays.asList("Hello", "World");
        words.stream().map(word -> word.split("")).distinct().forEach(System.out::println);
        List<String[]> distinctWords = words.stream().map(word -> word.split("")).distinct().collect(toList());

        System.out.println("found Distinct Words using Map " + distinctWords.toString());

        for (String[] s : distinctWords) {
            for (int i = 0; i < s.length; i++) {
                System.out.print(s[i] + " ");
            }
            System.out.println("\n");
        }


        System.out.println("--------------- Solving the Problem with Arrays.Stream--------------------");


        String[] arrayOfWords = {"Good ", "Bye "};

        Stream<String> streamOfWords = Arrays.stream(arrayOfWords);

      /*List<String> distinctString =  words.stream()
                                          .map(word->word.split(""))
                                          .map(Arrays::stream)
                                          .distinct()
                                          .collect(toList());
*/

        /*Above commented code doest not work because the using Arrays::stream we end up with list of stream  more
         * precisely , Stream<Stream<String>> */

        System.out.println("------------------ Using the flat Stream-------------------------------");

        List<String> distinctWordsUsingFlatMap = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());

        System.out.println("Distinct Words using the Flatmpa\n" + distinctWordsUsingFlatMap);


        System.out.println("-------------- Returning Square of Number ----------------------");

        List<Integer> listOfInteger = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        listOfInteger.stream().map(n -> n * n).forEach(System.out::println);





        /*------------------  Finding and Matching       ----------*/

        if (menu.stream().anyMatch(Dish::isVegetarina)) {
            System.out.println("------   Yes vegetarian dishes found    -------");

        }

        /*  Checking if Predicate Matches all Element --------*/

        boolean isHealty = menu.stream().allMatch(d -> d.getCalories() > 900);
        System.out.println("Is Food Healty " + isHealty);


        /*    Example of None Match*/

        boolean isNoneHealty = menu.stream().noneMatch(d -> d.getCalories() >= 5000);


        /*--------------- Find Any Method ----------------------*/

        /*   Return Arbitary Element from the stream*/

        Optional<Dish> dish = menu.stream().filter(Dish::isVegetarina).findAny();


        dish.ifPresent(d -> System.out.println(d.getName()));



        /*-------------    Finding the First Element ------------------------*/
            /* ------  Find the First Square Divisible by 3  */

        List<Integer> someNumber = Arrays.asList(1, 2, 3, 4, 5, 6);

        Optional<Integer> divisibleByTwo = someNumber.stream().map(x -> (x * x)).filter(x -> x % 3 == 0).findFirst();

        divisibleByTwo.ifPresent(d -> System.out.println("Divisible By 3 is " + d));



        /*--------------  Reducing --   also Refered as folding -----------------*/

        int sum = someNumber.stream().reduce(0, (a, b) -> a + b);

        System.out.println("-------- Adding with the help of Reduce---------" + sum);

        int mulitplication = someNumber.stream().reduce(1, (a, b) -> a * b);

        System.out.println("---------------Multiplication with the help of reduce-----------------" + mulitplication);

        /*-----------------  using More specific Way of doing above-----------------------*/

        int specificeWay = someNumber.stream().reduce(0, Integer::sum);

        System.out.println("----- Using More speicifc Way " + specificeWay);


    }


}

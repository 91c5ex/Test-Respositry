package pratice.collectingdatawithstream.main;

import pratice.collectingdatawithstream.model.Dish;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Amit on 5/23/2015.
 */
public class GeneralizedReduction {


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


        int totalCalories = menu.stream()
                .collect(Collectors.reducing(0, Dish::getCalories, (a, b) -> a + b));

        System.out.println("Total calories in menu are  " + totalCalories);


        // Finding highest calories dish using one-argument  version of reducing

        Optional<Dish> mostCalorieDish = menu.stream()
                .collect(Collectors.reducing(
                        (d1, d2) -> d1.getCalories() > d2.getCalories()
                                ? d1 : d2
                ));

        System.out.println("heighest calores dish is " + mostCalorieDish.get().toString());


        // Using Reduce instead of toList

        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6, 7).stream();

        List<Integer> numbers = stream.reduce(
                new ArrayList<Integer>(),
                (List<Integer> l, Integer i) -> {
                    System.out.println("Adding e " + i);
                    l.add(i);
                    return l;
                },
                (List<Integer> l1, List<Integer> l2) -> {

                    l1.addAll(l2);
                    System.out.println("Adding l1 " + l1.toString());
                    return l2;
                }

        );

        System.out.println("List of Integer is ");
        // numbers.stream().forEach(System.out::println);

//      Summing the calories again with reduction

        int caloriesSum = menu.stream()
                .collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));

        System.out.println("Calories Sum is "+caloriesSum);

        long count = menu.stream().collect(counting());

        System.out.println("Counted using count method  "+count);


        //Another way to calculate the total calories;

        int totalCaloriesTwice = menu.stream()
                .mapToInt(Dish::getCalories).sum();

        System.out.println("Sum calculate using second method  "+totalCaloriesTwice);



    }


    public static <T> Collector<T , ? , Long> counting(){

        return Collectors.reducing(0L ,e->1L , Long::sum);
    }



}

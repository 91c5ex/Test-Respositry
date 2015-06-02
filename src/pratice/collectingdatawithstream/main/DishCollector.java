package pratice.collectingdatawithstream.main;

import pratice.collectingdatawithstream.model.*;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Amit on 5/23/2015.
 */
public class DishCollector {


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

        long howManyDishes = menu.stream().count();

        System.out.println("How Many Dishes " + howManyDishes);

        long howManyDishes2 = menu.stream().collect(Collectors.counting());

        System.out.println("How Many Dished " + howManyDishes2);


        // Finding the maximun and minimun calories food

        Comparator<Dish> dishCaloriesCompartator = Comparator.comparingInt(Dish::getCalories);

        Optional<Dish> mostCalorieDish = menu.stream().collect(Collectors.maxBy(dishCaloriesCompartator));

        Dish mostCalorie = mostCalorieDish.get();

        System.out.println("Most Calorie Dish is " +
                mostCalorie.getName() + " having calories  " + mostCalorie.getCalories());

                //  Summarization

        int totalCalories  =  menu.stream().collect(Collectors.summingInt((Dish::getCalories)));

        System.out.println("Total Calories are "+totalCalories);

        // Calculating the average calories in the dishesh


        double avgCalories  = menu.stream()
                                .collect(Collectors.averagingInt(Dish::getCalories));

        System.out.println("Average calories in the menu is "+avgCalories);


        // Getting all the summaries at once

        IntSummaryStatistics menuStatistics = menu.stream()
                                                    .collect(Collectors.summarizingInt(Dish::getCalories));

        System.out.println("Menu Statistics are "+menuStatistics);

        // Joining all the dishes name

        /*String shortMenu = menu.stream().map(dish -> dish.getName())
                                        .collect(Collectors.joining());*/

      // String shortMenu = menu.stream().collect(Collectors.joining());

        String shortMenu = menu.stream().map(Dish::getName).collect(Collectors.joining(", "));



        System.out.println("All Dishes name \n"+shortMenu);











    }

}

package pratice.collectingdatawithstream.main;

import pratice.collectingdatawithstream.model.Dish;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Amit on 5/24/2015.
 */
public class Grouping {

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


        // Grouping in collecting the related set of data.


        Map<Dish.Type, List<Dish>> dishByType = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType));

        System.out.println("Grouping Elements   ------ >" + dishByType);


        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(

                Collectors.groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;

                })
        );

        System.out.println("DishesByCaloriclever ----->  " + dishesByCaloricLevel);


        // To Achieve multilevel grouping   using a collector you can pass inner
        // grouping to the
        //  inner grouping


        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
                menu.stream().collect(Collectors.groupingBy(Dish::getType,
                        Collectors.groupingBy(dish -> {
                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;

                        })

                ));


        System.out.println("dishesByTypeCaloricLevel \n " + dishesByTypeCaloricLevel);


        // Count number of dishes in menu of each type.

        Map<Dish.Type, Long> typeCount = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));

        System.out.println("Type Count is \n" + typeCount);


        // find the highest-calorie dish  in the menu to achieve the similar result .

        Map<Dish.Type, Optional<Dish>> mostCaloricByType =
                menu.stream().collect(Collectors.groupingBy(Dish::getType,
                        Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))
                ));


        System.out.println("highest calorie dishes are  \n" + mostCaloricByType);


        // Adapting the collector result  to a different type

        Map<Dish.Type, Dish> mostCalorieByType = menu.stream()
                .collect(Collectors.groupingBy(

                        Dish::getType, Collectors.collectingAndThen(Collectors.maxBy(
                                        Comparator.comparingInt(Dish::getCalories)),
                                        Optional::get
                        )
                ));

        System.out.println("mostCaliresByType \n" + mostCalorieByType);


    }

}


enum CaloricLevel {DIET, NORMAL, FAT}
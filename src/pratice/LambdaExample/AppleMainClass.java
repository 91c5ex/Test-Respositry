package pratice.LambdaExample;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Amit on 5/11/2015.
 */
public class AppleMainClass {

    public static void main(String... args) {

        List<Apple> listOApple = Arrays.asList(
                new Apple("a", 160, "red"),
                new Apple("b", 1, "green"),
                new Apple("c", 160, "yello"),
                new Apple("d", 1, "blue"),
                new Apple("e", 180, "blace")
        );

        boolean r = new AppleGreenColorPredicate().test(listOApple.get(0));
        System.out.println("Result is " + r);

        boolean w = new AppleHeavyWeightPredicate().test(listOApple.get(0));
        System.out.println("Weight is greater than  " + w);

        System.out.println("Using predicate  on whole list passing the predicate refernce");

        System.out.println(Utils.filterApple(listOApple, new AppleGreenColorPredicate()));

        System.out.println(Utils.filterApple(listOApple, new AppleHeavyWeightPredicate()));

        System.out.println("---------------------------------------------------------------");

        System.out.println("Solving problem through anonymous class");

        List<Apple> redApples = Utils.filterApple(listOApple, new ApplePredicate() {

            @Override
            public boolean test(Apple apple) {

                return "red".equals(apple.getColor());
            }


        });

        System.out.println("Red apples are "+redApples);

        System.out.println("--------------------------------------------------------------------");

        System.out.println("Using the lambda expression");

        List<Apple> result  = Utils.filterApple(listOApple, (Apple apple) -> "red".equals(apple.getColor()));

        System.out.println("Result using the lambda expression "+result);


        List<Apple> result2 =Utils.filter(listOApple,(Apple apple)->"blue".equals(apple.getColor()));

        System.out.println("Result 2 using the lambda expression "+result2);

        List<Integer> evenNumbers  = Utils.filter( Arrays.asList(1,2,3,4,5), (Integer i)->  i%2==0);

        System.out.println("Even nuber generate using the lambda expression "+evenNumbers);


        System.out.println("-------- Comparision By Weight without lambda expression------------");

        Comparator<Apple> byWeight  = new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return (a1.getWeight()>a2.getWeight())?1:0;
            }
        };




        System.out.println("-------- Comparision using lambda Expresion----------------");

        Comparator<Apple> byWei = (Apple a1 , Apple a2) -> a1.getWeight()>a2.getWeight()?1:0;

        System.out.println("using byWei  ----" +byWei.compare(listOApple.get(0) , listOApple.get(1)));



    }



}

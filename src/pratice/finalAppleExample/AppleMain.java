package pratice.finalAppleExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.Comparator;

/**
 * Created by Amit on 5/12/2015.
 */
public class AppleMain {

    public static void main(String args[]) {

        List<Apple> listOfApples = Arrays.asList(

                new Apple("green", 150),
                new Apple("read", 160),
                new Apple("green", 80),
                new Apple("red", 50)
        );


//        listOfApples.sort(new AppleComparator());

        //      System.out.println("List of sorted Apple By weight is "+listOfApples);


        /*  Using the Anonymous Class*/

       /* listOfApples.sort(new Comparator<Apple>() {

            public int compare(Apple a1, Apple a2) {

                return a1.getWeight() > a2.getWeight() ? 1 : -1;
            }
        });

        System.out.println("Sorted Through Anonymous Class" +listOfApples);*/


        /*Using the Lambda function*/

        /*listOfApples.sort((Apple a1 , Apple a2) -> a1.getWeight()>a2.getWeight()?1:-1);

        System.out.println("Soreted Through the Lambda Expressrion "+listOfApples);*/


        /*Using the static comparing method    */

        /*listOfApples.sort(java.util.Comparator.comparing((a->a.getWeight())));*/

        /*Using the method references*/

        listOfApples.sort(Comparator.comparing(Apple::getWeight));

        System.out.println("Comparing using the method references" +listOfApples);






    }


  /*  public static <T> List<T> applePredicate(List<T> listOfApple , Predicate<T> p)
    {

        List<T> returnList = new ArrayList<T>();
        for(T s : listOfApple)
        {

        }


        return new ArrayList<T>();
    }*/

}



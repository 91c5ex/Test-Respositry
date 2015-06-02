package pratice.javaInbuildFunctionClasses;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by Amit on 5/12/2015.
 */
public class MixUp {

    public static void main(String args[]) {

        System.out.println("Working with predicates's ");

        Predicate<String> nonEmptyString = (String s) -> !s.isEmpty();

        List<String> testList = Arrays.asList("1", "2", "", "", "4");
        List<String> testListString = Arrays.asList("Amit" ,"Thakur" , "Akash"  , "thkaur");

        System.out.println("Predicate Example " + filter(testList, nonEmptyString));

        System.out.println("Working with Consumers ");

        forEach(Arrays.asList(1, 2, 3, 4), (Integer i) -> System.out.println(i));


        System.out.println("------- Working with Functions----------");


        System.out.println("Working with Function "+map(testListString , (String  s ) -> s.length()));

        int portNumber = 8080;
        Runnable r = ()->System.out.println(portNumber);
        r.run();


        System.out.println("Comparing ignore case");

        /*It was using the lambda expression*/

        //testListString.sort((s1,s2)->s1.compareToIgnoreCase(s2));

        /*It's using he Method references*/

        testListString.sort(String::compareToIgnoreCase);
        System.out.println("String after Comparision --->"+testListString);





        System.out.println("At Last Dumping Thread");

        Thread.currentThread().dumpStack();

    }


    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T s : list) {
            if (p.test(s)) {
                result.add(s);
            }
        }
        return result;
    }

    public static <T> void forEach(List<T> list, Consumer<T> c
    ) {
        for (T s : list) {
            c.accept(s);

        }

    }


    public static<T,R> List<R> map(List<T> list , Function<T,R> f){

        List<R> result  = new ArrayList<>();
        for(T s :list)
        {
            result.add(f.apply(s));
        }
        return result;
    }



}

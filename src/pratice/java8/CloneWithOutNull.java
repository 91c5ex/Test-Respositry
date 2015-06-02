package pratice.java8;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Amit on 5/3/2015.
 */
public class CloneWithOutNull {


    public static void main(String args[])
    {

        List<String> listOfString = Arrays.asList("a", "b" , null ,null , "c" , null , "d");

        System.out.println("Initial List ----> "+listOfString);

        List<String> withoutNull = new ArrayList<>(listOfString);

        withoutNull.removeIf(Predicate.isEqual(null));

        System.out.println("Final List -----> "+withoutNull);

    }
}

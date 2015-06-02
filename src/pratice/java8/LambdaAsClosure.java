package pratice.java8;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by Amit on 5/4/2015.
 */
public class LambdaAsClosure {

    public static void main(String args[])
    {
        String greeting  = "Hello";
        Function<String , String > greeter = whom -> greeting + whom + "!";
        greetWorld(greeter);

        Supplier<Number> functionNum = () ->1;

        System.out.println("Supplier "+ functionNum.get());

        BiFunction<String , String  , String> concat  = (a,b) -> a+b;

        System.out.println("BiFunction "+concat.apply("abc " , " cde"));
    }

    private static void greetWorld(Function<String , String > greeter){

        System.out.println(greeter.apply("World"));

    }
}

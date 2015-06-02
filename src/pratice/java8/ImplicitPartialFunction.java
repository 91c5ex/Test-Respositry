package pratice.java8;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by Amit on 5/5/2015.
 */
public class ImplicitPartialFunction {

    public static void main(String args[])
    {

        BiFunction<String , String, String > concat = (a,b) -> a+b;

        greetFolks(whom -> concat.apply("Hello " , whom));
    }

    public static void greetFolks(Function<String , String > greeter){

        for(String name : Arrays.asList("amit" , "rahul" , "santosh")){
            System.out.println(greeter.apply(name));
        }
    }

}

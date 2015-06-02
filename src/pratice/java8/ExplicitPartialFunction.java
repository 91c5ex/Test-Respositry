package pratice.java8;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by Amit on 5/6/2015.
 */
public class ExplicitPartialFunction {

    public static void main(String... args)
    {
        BiFunction<String , String , String> concat = (a,b) -> a+b;
        greetFolks(applyPartial(concat , "Hello ,"));
    }

    public   static<T , U , V> Function<U,V> applyPartial(
            BiFunction<T,U,V> bif , T firstArgument
    ){
        System.out.println("ApplyPartial function called");
        return u->bif.apply(firstArgument, u);
    }

    public    static void greetFolks(Function<String, String> greeter)
    {
        System.out.println("GreetFolks Function called"+greeter);
        for(String name : Arrays.asList("Amit" , "Pakaj" , "Chandan" , "Vikrant")){
            System.out.println("Name is "+name);
            System.out.println(greeter.apply(name));

        }
    }

}

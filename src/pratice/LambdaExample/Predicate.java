package pratice.LambdaExample;

/**
 * Created by Amit on 5/11/2015.
 */

//This is a functional interface . A functionl interface  is an interface that specifies exactly one abstract method.

public interface Predicate<T> {
    boolean test(T t);
}

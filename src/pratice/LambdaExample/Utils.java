package pratice.LambdaExample;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amit on 5/11/2015.
 */
public class Utils {

        public static   List<Apple> filterApple (List<Apple> listOfApple , ApplePredicate p)
        {
            List<Apple>    result  = new ArrayList<Apple>();

            for(Apple apple :listOfApple)
            {
                if(p.test(apple))
                {
                    result.add(apple);
                }
            }
            return result;
        }




    public static <T>   List<T> filter(List<T> list, Predicate<T> p)
    {
        System.out.println("Test in predicate called");
        List<T> result =  new ArrayList<>();
        for (T e : list)
        {
            if(p.test(e))
            {

                result.add(e);
            }
        }
        return result;
    }

}

package pratice.LambdaExample;

/**
 * Created by Amit on 5/11/2015.
 */
public class AppleGreenColorPredicate implements ApplePredicate{

    @Override
    public  boolean test(Apple apple)
    {
     //   System.out.println(" AppleGreenColorPredicate callled");
        return "green".equals(apple.getColor());
    }
}

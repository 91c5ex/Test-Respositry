package pratice.LambdaExample;

/**
 * Created by Amit on 5/11/2015.
 */


public class AppleHeavyWeightPredicate implements  ApplePredicate{

    @Override
    public boolean test(Apple apple)
    {
       // System.out.println(" AppleHeavyWeightPredicate callled");
        return apple.getWeight() > 150;
    }
}
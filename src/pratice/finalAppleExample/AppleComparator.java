package pratice.finalAppleExample;

import java.util.Comparator;

/**
 * Created by Amit on 5/12/2015.
 */
public class AppleComparator implements Comparator<Apple> {

    @Override
    public int compare(Apple a1 , Apple a2){
        return a1.getWeight()>a2.getWeight()?1:-1;
    }

}

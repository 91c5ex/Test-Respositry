package pratice.collectingdatawithstream.model;

/**
 * Created by Amit on 5/14/2015.
 */
public class Dish {

    private final String name;

    private final boolean vegetarina;

    private final int calories;

    private final Type type;

    public Dish( String name, boolean vegetarina,int calories, Type type) {
        this.calories = calories;
        this.name = name;
        this.vegetarina = vegetarina;
        this.type = type;
    }


    public int getCalories() {
        return calories;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public boolean isVegetarina() {
        return vegetarina;
    }

      @Override
    public String toString() {
    return name;
      }

        public enum Type {
            MEAT, FISH, OTHER,SWEET
        }



    }


package pratice.finalAppleExample;

/**
 * Created by Amit on 5/12/2015.
 */
public class Apple {

    private String color;

    private int weight;




    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }


    public Apple() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}

package pratice.LambdaExample;

/**
 * Created by Amit on 5/10/2015.
 */
public class Apple {

    private String name;
    private int weight;

    private String color;

    public Apple(String name, int weight, String color) {
        this.name = name;
        this.weight = weight;
        this.color = color;

    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", name='" + name + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }
}

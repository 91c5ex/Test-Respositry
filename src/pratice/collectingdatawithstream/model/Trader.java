package pratice.collectingdatawithstream.model;

/**
 * Created by Amit on 5/18/2015.
 */
public class Trader {


    private final String name;

    private final String city;


    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "city='" + city + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

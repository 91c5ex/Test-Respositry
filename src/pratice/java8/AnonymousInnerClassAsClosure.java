package pratice.java8;

/**
 * Created by Amit on 5/4/2015.
 */
public class AnonymousInnerClassAsClosure {

    public static void main(String args[]) {

        final String greeting = "Hello  ";

        System.out.println("1");

        Greeter greeter = new Greeter() {

            {
                System.out.println("2");
            }
            @Override
            public String createGreating(String whom) {
                System.out.println("4");
                return greeting + whom + "!";
            }

            public String sayHello(){
                    return "empty";
            }

        };

        greetWorld(greeter);
    }

    private static void greetWorld(Greeter greeter ){


        System.out.println("3");
        System.out.println(greeter.createGreating("World"));

    }

}


interface Greeter {

    String createGreating(String whom);
}

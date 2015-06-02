package pratice.LambdaExample;

/**
 * Created by Amit on 5/11/2015.
 */
public class RunnableLambda {


    public static void process(Runnable r) {
        r.run();
    }

    public static void main(String... args) {
        Runnable r1 = () -> {
            System.out.println("Hello World 1");
            System.out.println("R1 Thread name is " + Thread.currentThread().getName());
        }
            ;

        Runnable r2 = new Runnable() {
            public void run() {
                System.out.println("Hellow world 2");
                System.out.println("R2 Thread name is "+Thread.currentThread().getName());
            }
        };

        process(r1);
        process(r2);
        System.out.println("Main  Thread name " + Thread.currentThread().getName());

        process(() -> {
            System.out.println("Hello world 3");
            System.out.println(" This thread name " + Thread.currentThread().getName());


        });
    }

}

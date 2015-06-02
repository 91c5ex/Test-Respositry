package pratice.buildingstream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Amit on 5/20/2015.
 */
public class BuildingStream {

    public static void main(String args[]) {


        /* Stream from values */
        Stream<String> stringStream = Stream.of("java 8", "Lambdas ", "In ", "Action ");

        stringStream.map(String::toUpperCase).forEach(System.out::println);

        // stringStream.forEach(System.out::println);


        // creating an empty stream

        Stream<String> emptyStream = Stream.empty();

        /*Creating Stream from array*/

        int[] number = {2, 3, 4, 5, 6};
        int sum = Arrays.stream(number).sum();

        System.out.println("Sum of elements is " + sum);


        // Stream from file

        long uniqueWords = 0;

        try (Stream<String> lines = Files.lines(Paths.get("C:\\Users\\Amit\\IdeaProjects\\Java8\\src\\pratice\\buildingstream\\data.txt"), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


        System.out.println("Total No of Unique words in a file as follows " + uniqueWords);


        // Streams from function creatinf infinte stream

        // Stream.iterate and Stream.generate  let you create what we call infinte stream

        /*Stream  produce by iterate and generate create values on demand given function and can therefore can create
        * Stream forever . It is sensible to use limit(n) on such stream to avoid printing and infinte  number of values*/

        /*  ------------------ Iterate ---------------------------------*/
        /*  Use iterate to produce a sequence of successive values */
            /*Stream  are unbounded */
        Stream.iterate(0, n->n+2).limit(5).forEach(System.out::println);


        /*     Generating Fibonacci tuples series    */

        Stream.iterate(new int[]{0,1}, t->new int[]{t[1], t[0]+t[1]})
                                        .limit(5)
                                        .forEach(t -> System.out.println(t[0] + " " + t[1]));


        // Stream using Generate Method

        /*the method generate let you produce an infinite stream of   values computed to demand*/
        /*It takes a lambda of type Supplier<T> to provide new values  and is stateless*/
        /* Supplier that is stateful isn't safe to use in parallel code.  */

        System.out.println("Creating stream using the generate method");


        Stream.generate(Math::random).limit(5).forEach(System.out::println);

        IntStream twos = IntStream.generate(()->1);

    }
}

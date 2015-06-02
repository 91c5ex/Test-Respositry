package pratice.pythagorean;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static pratice.LambdaExample.Utils.filter;

/**
 * Created by Amit on 5/19/2015.
 */
public class PythagoreanTriple {

    public static void main(String args[])
    {


        Stream<int[]> pythgoreanTriples = IntStream.rangeClosed(1,100).boxed()
                                            .flatMap(
                                                    a->IntStream.rangeClosed(a,100)
                                                    .filter(b->Math.sqrt(a*a+b*b)%1==0)
                                                    .mapToObj(b->new int[]{a , b ,(int)Math.sqrt(a*a+b*b)})

                                            );


    //    pythgoreanTriples.forEach(t->System.out.println(t[0]+"   "+t[1]+"      "+t[2]));



// Flat Map method does the mapping and also flattens all the generated streams of triples into a single stream.
        //As a result  you produce  a stream  of triples


        // Solving it with other method

        Stream<double[]> pythgoreanTriples2 = IntStream.rangeClosed(1,100).boxed()
                                                .flatMap(a-> IntStream.rangeClosed(a,100)
                                                .mapToObj(b->new double[]{a,b,Math.sqrt(a*a+b*b)})).filter(t->t[2]%1==0);

        pythgoreanTriples2.forEach(t->System.out.println(t[0]+"     "+t[1]+"     "+t[2]));



    }


}

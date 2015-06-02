package pratice.ReadLineLambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Amit on 5/12/2015.
 */
public class FileProcess {


    public static void main(String[] args) throws IOException{

    System.out.println("Main Class Loaded");


        System.out.println("Reading line without lambda expression---------------");

            String firstLine = processFile(new BufferedReaderProcessor() {
                @Override
                public String process(BufferedReader r) throws IOException {

                    BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Amit\\Desktop\\lambdaTest.csv"));
                    return br.readLine();
                }
            });
        System.out.println("Reading first Line "+firstLine);

        System.out.println("Reading Line with Lambda Expression------------------ ");
        String onLine = processFile((BufferedReader br)->br.readLine() +"\n"+ br.readLine());
        System.out.println("First Line iss "+onLine);


    }

    public static String processFile(BufferedReaderProcessor p) throws IOException{

        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Amit\\Desktop\\lambdaTest.csv")))
        {
            return p.process(br);
        }

    }

}

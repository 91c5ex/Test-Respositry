package pratice.file;

import java.io.*;

/**
 * Created by Amit on 5/3/2015.
 */
public class CharacterReading {

    public static void main(String... args) throws IOException {
        long startTime;
        long currentTimeStart;

        long midTime;
        long currentTimeMid;

        long currentTimeEnd;
        long endTime;

        int c;

        FileReader in = null;
        FileWriter out = null;
        try {
            File inputFile = new File("C:\\Users\\Amit\\Desktop\\us___3.csv");


            System.out.println("Start Time " + (startTime = System.currentTimeMillis()));
            in = new FileReader(inputFile);


            File outputStream = new File("C:\\Users\\Amit\\Desktop\\us___Character_By_Character.csv");


            if (!outputStream.exists()) {
                outputStream.createNewFile();
                System.out.println("File created");
            } else {
                System.out.println("File already exists");
            }


            out = new FileWriter(outputStream);


            while (-1 != (c = in.read())) {
                out.write(c);
            }


            System.out.println("Total time taken to read byte by byte---->  " + (System.currentTimeMillis() - startTime));
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }

        }

    }
}


package pratice.file;

import java.io.*;

/**
 * Created by Amit on 5/3/2015.  I have uploaded it to git so just checking and doing so more work
 */
public class BufferdReading {

    public static void main(String... args) throws IOException {
        long startTime;
        long currentTimeStart;

        long midTime;
        long currentTimeMid;

        long currentTimeEnd;
        long endTime;

        int c;

        InputStream in = null;
        OutputStream out = null;
        try {
            File inputFile = new File("C:\\Users\\Amit\\Desktop\\1.pdf");


            System.out.println("Start Time " + (startTime = System.currentTimeMillis()));
            in = new BufferedInputStream(new FileInputStream("C:\\Users\\Amit\\Desktop\\1.pdf"));


            File outputStream = new File("C:\\Users\\Amit\\Desktop\\2.pdf" );


            if (!outputStream.exists()) {
                outputStream.createNewFile();
                System.out.println("File created");
            } else {
                System.out.println("File already exists");
            }

            out = new BufferedOutputStream(new FileOutputStream(outputStream) , 8*1024) ;


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

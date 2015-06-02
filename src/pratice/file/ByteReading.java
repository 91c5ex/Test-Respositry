package pratice.file;

import java.io.*;

/**
 * Created by Amit on 5/3/2015.
 */
public class ByteReading {

    public static void main(String... args)  throws IOException
    {

        long startTime;
        long currentTimeStart;

        long midTime;
        long currentTimeMid;

        long currentTimeEnd;
        long endTime;

        int c;

        InputStream in=null;
        OutputStream out=null;
       try{
           File inputFile = new File("C:\\Users\\Amit\\Desktop\\1.pdf");


           System.out.println("Start Time " + (startTime = System.currentTimeMillis()));
            in  = new FileInputStream(inputFile);



           File outputFile = new File("C:\\Users\\Amit\\Desktop\\2.pdf");



           if(!outputFile.exists())
           {
               outputFile.createNewFile();
               System.out.println("File created");
           }
           else{
               System.out.println("File already exists");
           }



            out = new FileOutputStream(outputFile);



           while(-1!=(c=in.read()))
           {
              // System.out.println("Byte is "+c);

               out.write(c);
           }


           System.out.println("Total time taken to read byte by byte---->  "+(System.currentTimeMillis()-startTime)/1000);
       }
       finally {
                if(in!=null)
                {
                    in.close();
                }
           if(out!=null){
               out.close();
           }
        }



    }

}



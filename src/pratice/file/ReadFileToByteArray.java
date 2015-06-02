package pratice.file;

import java.io.*;


/**
 * Created by Amit on 5/3/2015.
 */
public class ReadFileToByteArray {


    public static void main(String args[]) throws IOException {

        InputStream in = null;

        long startTimeFirst, timeToConvertToByteArray, toConverToFileFromBtyeArray = 0l;

        System.out.println("Begin Time-->      " + (startTimeFirst = System.currentTimeMillis()));

        in = new FileInputStream(new File("C:\\Users\\Amit\\Desktop\\Moviesnhackss.Com.GBck.Scrmkv"));

        Reader reader = new BufferedReader(new InputStreamReader(in));


        ByteArrayOutputStream output = new ByteArrayOutputStream();

        Writer writer = new BufferedWriter(new OutputStreamWriter(output));

        //OutputStreamWriter out = new OutputStreamWriter(output);


        char[] buffer = new char[1024];
        int count = 0;
        int n = 0;

        while (-1 != (n = reader.read(buffer))) {

            writer.write(buffer, 0, n);
            count += n;
        }



        System.out.println("Time to convert to byte array  -->      " + (timeToConvertToByteArray = (startTimeFirst - System.currentTimeMillis())/1000));

        System.out.println("char buffer " + output.toByteArray());


        File copyFile = new File("C:\\Users\\Amit\\Desktop\\Gabbar.Scrmkv");

        if (!copyFile.exists()) {
            copyFile.createNewFile();
        }


        long startTimeSecond = System.currentTimeMillis();


        OutputStream outSteam = new FileOutputStream(copyFile);
        outSteam.write(output.toByteArray());


        System.out.println("Time to convert from byte array to file ---->     "+(toConverToFileFromBtyeArray=(startTimeSecond-System.currentTimeMillis())/1000));

    }


}

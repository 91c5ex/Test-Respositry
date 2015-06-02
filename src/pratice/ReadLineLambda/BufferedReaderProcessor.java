package pratice.ReadLineLambda;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Amit on 5/12/2015.
 */
@FunctionalInterface
public interface BufferedReaderProcessor {

    String process(BufferedReader r) throws IOException;
}

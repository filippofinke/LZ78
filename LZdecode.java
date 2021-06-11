import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Decodes an input stream with the LZ78 algorithm
 */
public class LZdecode {

    /**
     * Decodes input from stdin assuming it is encoded with LZ78 encoding space
     * separated values of the form "index charachter"
     * 
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        // create a new decoder to retrieve original message from the compressed data
        Decoder decoder = new Decoder();
        while ((line = br.readLine()) != null) {
            // pass values to our decoder
            decoder.add(line.split(" "));
        }
        // print our decoded output
        System.out.print(decoder.decode());
    }
}
import java.util.ArrayList;

/**
 * Internal decoder class
 */
public class Decoder {
    ArrayList<Integer> indexes;
    ArrayList<Byte> chars;
    int pairsCount;

    /**
     * Initialise a new Decoder
     */
    public Decoder() {
        indexes = new ArrayList<Integer>();
        chars = new ArrayList<Byte>();
        pairsCount = 0;
        indexes.add(0);
        chars.add((byte) 0);
    }

    /**
     * Adds pairs into our array to be decoded
     * 
     * @param line String[] in form [index, charachter]
     */
    public void add(String[] line) {
        pairsCount++;
        indexes.add(Integer.parseInt(line[0]));
        chars.add((byte) line[1].charAt(0));
    }

    /**
     * Decode the items that have been added into our decoder
     */
    public String decode() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= pairsCount; i++) {
            sb.append(decodeRecursion(indexes.get(i), chars.get(i)));
        }
        return sb.toString();
    }

    /**
     * Recursively builds a string from an input pair
     * 
     * @param i Current index
     * @param c Current charachter
     */
    private String decodeRecursion(int i, int c) {
        if (i == 0) {
            // base case, our string is prefixed by the empty string
            return Character.toString(c);
        } else {
            // else we must prefix the current string we have build with the charachter at
            // the index of our chars[] array at index i
            return decodeRecursion(indexes.get(i), chars.get(i)) + Character.toString(c);
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Encodes an input stream with the LZ78 algorithm
 */
public class LZencode {
    /**
     * Encodes standard input using LZ78 encoding using a multi-way Trie. Outputs to
     * standard out in the form "index characher"
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Trie trie = new Trie(); // Create a new Trie object to store our patterns
        int i = 0; // The index of the character.
        int c = 0; // The character value.
        String s = "";

        // Read the file charachter by charachter
        while ((c = br.read()) != -1) {
            s += Character.toString((char) c);
            if ((i = trie.searchInsert(s)) >= 0) {
                // if i >= 0, then we have inserted a mismatched charachter (which is the final
                // charachter in the string s, or more simply the charachter c) into our trie
                // and need to output the index of the longest string that we found (at index i)
                // and the mismatched charachter c to standard out
                System.out.println(i + " " + c);
                // reset s as we need to search for a new string
                s = "";
            }
        }
        if (!s.equals("")) {
            // We got to end of file but didnt output anything cause there was no mismatched
            // charachter, so output the last index found (sign fixed by multiplying by -1)
            // followed by a null charachter
            System.out.println(-1 * trie.searchInsert(s) + " " + 0);
        }
    }
}
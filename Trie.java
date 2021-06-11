import java.nio.charset.StandardCharsets;

/**
 * Trie abstract data structure
 */
public class Trie {
    private TrieNode root;
    private int nodeCount;

    /**
     * Constructor for Trie class.
     */
    public Trie() {
        // Initialise a new Trie structure.
        this.root = new TrieNode(0, 0);
        this.nodeCount = 0;
    };

    /**
     * Method for searching and inserting.
     * 
     * @param s String to be inserted.
     * @return If a charachter was inserted into our trie, we return the index of
     *         its parent. If however our query string already existed in our trie
     *         (and therefore we did not need to insert it) we return the index
     *         multiplied by -1
     */
    public int searchInsert(String s) {
        TrieNode current = this.root;
        // loop through each charachter in our query string 's'
        for (int c : s.getBytes(StandardCharsets.US_ASCII)) {
            if (current.children.get(c) == null) {
                // if our string is an invalid path in our trie, we have found a mismatched
                // string and must add it to our trie. In our encoder we want to output this
                // mismatched charachter prefixed by the index of its parent
                current.children.put(c, new TrieNode(c, ++this.nodeCount));
                return current.index;
            }
            current = current.children.get(c);
        }
        // If we have have iterated through our entire string and not found a mismatched
        // charachter, our query string exists in our trie. In this case we want to try
        // a longer string

        // Here, we output the index multiplied by -1, so as to indicate the index of
        // the string, but also to show that nothing was inserted (negative sign). We
        // only care about the value here for the last word to be encoded.
        return current.index * -1;
    };
}
import java.util.HashMap;

/**
 * TrieNode class for Trie data structure
 */
public class TrieNode {
    public int value;
    public int index;
    // we chose to use a hashmap to store pointers to the child nodes as it is a
    // much simpler approach than using arrays
    public HashMap<Integer, TrieNode> children;

    /**
     * Constructor for the TrieNode class.
     * 
     * @param c The character value we want the node to represent.
     * @param i The index we want to store at.
     */
    public TrieNode(int c, int i) {
        value = c;
        index = i;
        children = new HashMap<Integer, TrieNode>();
    }
}
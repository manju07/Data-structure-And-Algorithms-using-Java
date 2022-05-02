package datastructure.trie;

/**
 * Trie data structure used for auto suggestion
 * 
 * @author Manjunath Asundi
 */
public class AutoSuggestion {

    static class TrieNode {
        TrieNode[] childNodes = new TrieNode[26];
        Boolean isEndOfWord;

        public TrieNode() {
            this.isEndOfWord = false;
            for (int i = 0; i < childNodes.length; i++)
                childNodes[i] = null;
        }
    }

    public static void insert(String word, TrieNode root) {
        TrieNode tempRoot = root;
        int index = -1;
        for (int i = 0; i < word.length(); i++) {
            index = word.charAt(i) - 'a';
            if (tempRoot.childNodes[index] == null)
                tempRoot.childNodes[index] = new TrieNode();
            tempRoot = tempRoot.childNodes[index];
        }
        tempRoot.isEndOfWord = true;
    }

    public static Boolean searchWord(String word, TrieNode root) {
        if (root == null)
            return false;
        TrieNode tempRoot = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (tempRoot.childNodes[index] == null)
                return false;
            tempRoot = tempRoot.childNodes[index];
        }
        return tempRoot.isEndOfWord;
    }

    public static void main(String[] args) {
        TrieNode root = new TrieNode();
        String[] strs = { "manju", "vishwa", "netra", "bhagya", "shivu" };

        // Inserting strings to trie data structure
        for (int i = 0; i < strs.length; i++)
            insert(strs[i], root);

        // Searching strings in trie
        for (int i = 0; i < strs.length; i++)
            System.out.println("Searching " + strs[i] + " = " + searchWord(strs[i], root));

        System.out.println("Searching manjunath = " + searchWord("manjunath", root));
    }
}

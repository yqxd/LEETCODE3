import com.sun.xml.internal.bind.v2.model.core.NonElement;

import java.util.ArrayList;

//Implement a trie with insert, search, and startsWith methods.
//
//        Example:
//
//        Trie trie = new Trie();
//
//        trie.insert("apple");
//        trie.search("apple");   // returns true
//        trie.search("app");     // returns false
//        trie.startsWith("app"); // returns true
//        trie.insert("app");
//        trie.search("app");     // returns true
//        Note:
//
//        You may assume that all inputs are consist of lowercase letters a-z.
//        All inputs are guaranteed to be non-empty strings.
class TrieNode {
    char data = '0';
    TrieNode[] next;
    boolean end;

    public TrieNode(char data) {
        this.data = data;
        this.next = new TrieNode[26];
        this.end = false;
    }

    public void AddNode(String word, int index) {
        if (index < word.length()) {
            int p = word.charAt(index) - 'a';
            if (this.next[p] == null) {
                this.next[p] = new TrieNode(word.charAt(index));
            }
            next[p].AddNode(word, index + 1);
        } else {
            this.end = true;
        }
    }

    public boolean startsWith(String word, int index) {
        if (index < word.length()) {
            int p = word.charAt(index) - 'a';
            if(this.next[p] == null){
                return false;
            }
            if (this.next[p].data != word.charAt(index)) {
                return false;
            }
            return this.next[p].startsWith(word, index + 1);
        } else {
            return true;
        }
    }

    public boolean search(String word, int index) {
        if (index < word.length()) {
            int p = word.charAt(index) - 'a';
            if(this.next[p] == null){
                return false;
            }
            if (this.next[p].data != word.charAt(index)) {
                return false;
            }
            return this.next[p].search(word, index + 1);
        } else {
            if (this.end) {
                return true;
            } else {
                return false;
            }
        }
    }
}

class Trie {
    TrieNode root = new TrieNode('0');

    /**
     * Initialize your data structure here.
     */
    public Trie() {

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word.length() > 0) {
            int p = word.charAt(0) - 'a';
            this.root.next[p] = new TrieNode('0');
            this.root.next[p].AddNode(word, 0);
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        int p = word.charAt(0) - 'a';
        if(this.root.next[p] == null){
            return false;
        }
        return this.root.next[p].search(word, 0);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        int p = prefix.charAt(0) - 'a';
        if(this.root.next[p] == null){
            return false;
        }
        return this.root.next[p].startsWith(prefix, 0);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */


public class Q208ImplementTrie_PrefixTree {
    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
        trie = new Trie();
        System.out.println(trie.startsWith("a"));
    }
}

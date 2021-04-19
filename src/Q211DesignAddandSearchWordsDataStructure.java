import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q211DesignAddandSearchWordsDataStructure {
    static class WordDictionary {
        Map<String, Integer> A = new HashMap<>();

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
        }

        public void addWord(String word) {
            if (!this.A.containsKey(word)) {
                putIndex(new StringBuilder(word), 0);
            }
        }

        public void putIndex(StringBuilder sb, int index) {
            if (index < sb.length()) {
                putIndex(sb, index + 1);
                char str = sb.charAt(index);
                sb.replace(index, index + 1, ".");
                if (!this.A.containsKey(sb.toString())) {
                    putIndex(sb, index + 1);
                }
                sb.replace(index, index + 1, String.valueOf(str));
            } else {
                this.A.put(sb.toString(), 1);
            }
        }

        public boolean search(String word) {
            return A.containsKey(word);
        }
    }

    /**
     * Your WordDictionary object will be instantiated and called as such:
     * WordDictionary obj = new WordDictionary();
     * obj.addWord(word);
     * boolean param_2 = obj.search(word);
     */

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
    }
}

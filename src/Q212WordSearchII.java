import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//public class Q212WordSearchII {
//    public static void main(String[] args) {
//        char[][] board = {{'a'}};
//        String[] words = {"a"};
//        Q212WordSearchII A = new Q212WordSearchII();
//        System.out.println(A.findWords(board, words));
//    }
//
//    public List<String> findWords(char[][] board, String[] words) {
//        List<String> result = new ArrayList<>();
//        for (String word : words) {
//            List<int[]> filled = new ArrayList<>();
//            if (findWord(board, word, filled, new int[]{-1, -1}, 0)) {
//                result.add(word);
//            }
//        }
//        return result;
//    }
//
//    public boolean findWord(char[][] board, String word, List<int[]> filled, int[] index_now, int index) {
//        if (index_now[0] == -1) {
//            for (int x = 0; x < board.length; x++) {
//                for (int y = 0; y < board[0].length; y++) {
//                    List<int[]> result = new ArrayList<>();
//                    index_now = new int[]{x, y};
//                    filled.add(index_now);
//                    if (findWord(board, word, result, index_now, 1)) {
//                        return true;
//                    }
//                }
//            }
//            return false;
//        } else {
//            if (index == word.length()) {
//                return true;
//            } else {
//                int x = index_now[0];
//                int y = index_now[1];
//                char w = word.charAt(index);
//                if (board[x][y] != w) {
//                    return false;
//                } else {
//                    int[] add = new int[]{x, y};
//                    if (filled.contains(add)) {
//                        return false;
//                    } else {
//                        filled.add(add);
//                        for (int[] next : findnext(board, filled, x, y)) {
//                            if (findWord(board, word, filled, next, index + 1)) {
//                                return true;
//                            }
//                        }
//                        return false;
//                    }
//
//                }
//            }
//        }
//    }
//
//    public List<int[]> findnext(char[][] board, List<int[]> filled, int x, int y) {
//        List<int[]> result = new ArrayList<>();
//        int MX = board.length;
//        int MY = board[0].length;
//        if (!filled.contains(new int[]{x + 1, y}) && x + 1 < MX) {
//            result.add(new int[]{x + 1, y});
//        }
//        if (!filled.contains(new int[]{x, y + 1}) && y + 1 < MY) {
//            result.add(new int[]{x, y + 1});
//        }
//        if (!filled.contains(new int[]{x - 1, y}) && x > 0) {
//            result.add(new int[]{x - 1, y});
//        }
//        if (!filled.contains(new int[]{x, y - 1}) && y > 0) {
//            result.add(new int[]{x, y - 1});
//        }
//        return result;
//    }
//}

public class Q212WordSearchII {
    public static void main(String[] args) {
        char[][] board = {{'a'}};
        String[] words = {"a"};
        Q212WordSearchII A = new Q212WordSearchII();
    }

    class TrieNode {
        HashMap<Character, TrieNode> map = new HashMap<Character, TrieNode>();
        char c;
        int index;

        TrieNode(char c) {
            this.c = c;
            this.index = -1; // store index of the word in trie node as end of the word
        }
    }

    class Trie {
        TrieNode root;
        List<String> result;
        String[] words;

        Trie() {
            root = new TrieNode('0');
        }

        // trie construction
        public void insert(String word, int index) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!curr.map.containsKey(ch)) {
                    curr.map.put(ch, new TrieNode(ch));
                }
                curr = curr.map.get(ch);
            }
            curr.index = index;
        }

        //calling backtrack for possible valid word
        public List<String> helper(char[][] board) {
            result = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (root.map.containsKey(board[i][j])) {
                        backtrack(board, i, j, root);
                    }
                }
            }
            return result;
        }

        public void backtrack(char[][] board, int row, int col, TrieNode parent) {
            if (row < 0 || col < 0 || row == board.length || col == board[0].length || !parent.map.containsKey(board[row][col]))
                return;

            char ch = board[row][col];
            TrieNode curr = parent.map.get(ch);
            if (curr.index >= 0) {
                result.add(words[curr.index]); // fetch index of the word
                curr.index = -1;
            }

            board[row][col] = '#';

            backtrack(board, row + 1, col, curr);
            backtrack(board, row, col + 1, curr);
            backtrack(board, row, col - 1, curr);
            backtrack(board, row - 1, col, curr);

            board[row][col] = ch;

        }
    }

    class Solution {

        Trie trie = new Trie();

        public List<String> findWords(char[][] board, String[] words) {
            int index = 0;
            for (String word : words) {
                trie.insert(word, index++);
            }
            trie.words = words;
            return trie.helper(board);
        }


    }
}
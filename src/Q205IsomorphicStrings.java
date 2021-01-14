//Given two strings s and t, determine if they are isomorphic.
//
//        Two strings s and t are isomorphic if the characters in s can be replaced to get t.
//
//        All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
//
//
//
//        Example 1:
//
//        Input: s = "egg", t = "add"
//        Output: true
//        Example 2:
//
//        Input: s = "foo", t = "bar"
//        Output: false
//        Example 3:
//
//        Input: s = "paper", t = "title"
//        Output: true


//public class Q205IsomorphicStrings {
//    public boolean isIsomorphic(String s, String t) {
//        char ret[] = {0, 0, 0, 0, 0, 0,
//                0, 0, 0, 0, 0, 0,
//                0, 0, 0, 0, 0, 0,
//                0, 0, 0, 0, 0, 0,
//                0, 0};
//        int loc;
//        if (s.length() == t.length()) {
//            for (int index = 0; index < s.length(); index++) {
//                loc = ret[s.charAt(index) - 97];
//                if (loc == 0) {
//                    ret[s.charAt(index) - 97] = t.charAt(index);
//                    if (t.indexOf(t.charAt(index)) != index) {
//                        return false;
//                    }
//                } else if (loc != t.charAt(index)) {
//                    return false;
//                }
//            }
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public static void main(String[] args) {
//        Q205IsomorphicStrings A = new Q205IsomorphicStrings();
//        String s = "badc";
//        String t = "baba";
//        System.out.println(A.isIsomorphic(s, t));
//    }
//}


import java.util.HashMap;

public class Q205IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        int lengthOfS = s.length();
        int lengthOfT = t.length();
        if (lengthOfS != lengthOfT)
            return false;
        else if (lengthOfS == 0)
            return true;
        HashMap<Character, Character> previousMatchingChar = new HashMap<Character, Character>();
        for (int i = 0; i < lengthOfS; i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (previousMatchingChar.containsKey(sChar) && previousMatchingChar.get(sChar) != tChar)
                return false;
            previousMatchingChar.put(sChar, tChar);
        }
        previousMatchingChar.clear();
        for (int i = 0; i < lengthOfT; i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (previousMatchingChar.containsKey(tChar) && previousMatchingChar.get(tChar) != sChar)
                return false;
            previousMatchingChar.put(tChar, sChar);
        }
        return true;
    }

    public static void main(String[] args) {
        Q205IsomorphicStrings A = new Q205IsomorphicStrings();
        String s = "badc";
        String t = "baba";
        System.out.println(A.isIsomorphic(s, t));
    }
}

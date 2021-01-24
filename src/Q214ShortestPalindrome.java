public class Q214ShortestPalindrome {
    public static void main(String[] args) {
        String s = "aabababababaababaa";
        Q214ShortestPalindrome A = new Q214ShortestPalindrome();
        System.out.println(A.shortestPalindrome(s));
    }

    //    public String shortestPalindrome(String s) {
//        String t = new StringBuffer(s).reverse().toString();
//        long x = 0, y = 0;
//        int len = 0;
//        for (int index = 0; index < s.length(); index++) {
//            x = x * 27 + (s.charAt(index) - 'a' + 1);
//            y = (long) (y + Math.pow(27, index) * (t.charAt(t.length() - 1 - index) - 'a' + 1));
//            if (x == y) {
//                len = index + 1;
//            }
//        }
//        return new StringBuffer(s.substring(len)).reverse().toString() + s;
//    }
    public String shortestPalindrome(String s) {
        char[] chs = s.toCharArray();
        int n = chs.length;
        long h1 = 0, h2 = 0;
        long f = 1;
        long mod = 1000000007l;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int x = chs[i] - 'a';
            h1 = (26 * h1 + x) % mod;
            h2 = (h2 + x * f) % mod;
            f = (26 * f) % mod;
            if (h1 == h2) // && check(chs, i))
                max = i + 1;
        }
        if (max == n)
            return s;
        return new StringBuilder()
                .append(s.substring(max))
                .reverse()
                .append(s)
                .toString();
    }

    // Used for double check.
    boolean check(char[] chs, int r) {
        int l = 0;
        while (l < r)
            if (chs[l++] != chs[r--])
                return false;
        return true;
    }
}




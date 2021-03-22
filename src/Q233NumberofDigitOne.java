//Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
//
//
//
//        Example 1:
//
//        Input: n = 13
//        Output: 6
//        Example 2:
//
//        Input: n = 0
//        Output: 0


import static java.lang.Math.*;

public class Q233NumberofDigitOne {
    int countDigitOne(int n) {
        int digit = 0, result = 0, cur;
        while (pow(10, digit) <= n) {
            cur = (int) (n / pow(10, digit)) % 10;
            if (cur == 1) {
                result += ((int) (n / pow(10, digit + 1))) * pow(10, digit) + (n % pow(10, digit) + 1);
            } else if (cur == 0) {
                result += ((int) (n / pow(10, digit + 1))) * pow(10, digit);
            } else {
                result += ((int) (n / pow(10, digit + 1)) + 1) * pow(10, digit);
            }
            digit++;
        }
        return result;
    }

    public static void main(String[] args) {
        Q233NumberofDigitOne A = new Q233NumberofDigitOne();
        System.out.println(A.countDigitOne(0));
    }
}




















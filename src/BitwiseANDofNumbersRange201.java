import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class BitwiseANDofNumbersRange201 {
    private int FindDigit(int m, int k){
        return ((m >>> k) << k) + (1 << k);
    }

    private int rangeBitwiseAnd(int m, int n) {
        int result = m, digit = 1, newnum;
        while (true){
            newnum = FindDigit(m, digit);
            if(newnum > n || result == 0){
                break;
            } else{
                result = result & newnum;
            }
            digit += 1;
        }
        return result;
    }

    public static void main(String[] args) {
        BitwiseANDofNumbersRange201 A = new BitwiseANDofNumbersRange201();
        System.out.println(A.rangeBitwiseAnd(5, 7));
    }

}

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class RemoveLinkedListElements203 {
    public static void main(String[] args){
        System.out.println();
    }
}

class Solution1 {
    public boolean isHappy(int n) {
        int NewN = 0;
        List<Integer> list = new ArrayList<Integer>();
        while (!list.contains(n)) {
            list.add(n);
            NewN = 0;
            while (n != 0) {
                NewN += Math.pow(n % 10, 2);
                n = n / 10;
            }
            n = NewN;
            if (n == 1) {
                return true;
            }
        }
        return false;
    }
}
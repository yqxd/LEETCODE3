import java.util.ArrayList;
import java.util.List;


public class Q204CountPrimes {
    public static void main(String[] args){
        Q204CountPrimes A = new Q204CountPrimes();
        System.out.println(A.countPrimes(10));
    }
    private int countPrimes(int n) {
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(1);
        }
        for (int i = 2; i < n; i++) {
            if (list.get(i) == 1) {
                result.add(i);
                for (int j = 2; j * i <= n; j++) {
                    list.set(i*j, 0);
                }
            }
        }
        return result.size();
    }
}

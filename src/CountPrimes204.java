import java.util.ArrayList;
import java.util.List;

class countPrimes {
    public int countPrimes(int n) {
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i <= n; i++) {
            list.add(1);
        }
        for (int i = 2; i <= n; i++) {
            if (list.get(i) == 1) {
                result.add(i);
                for (int j = 2; j * i <= n; j++) {

                }
            }
        }
        return result.size();
    }
}

public class CountPrimes204 {
    public static void main(String[] args){
        countPrimes A = new countPrimes();
    }
}

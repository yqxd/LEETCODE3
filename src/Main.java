import java.util.Scanner;

public class Main {
    public int Cal(int V, int n, int[] k) {
        int[] A = new int[V + 1];
        A[0] = 1;
        for (int i : k) {
            for (int j = V - i; j >= 0; j--) {
                if (A[j] == 1) {
                    A[j + i] = 1;
                }
            }
            if (A[V] == 1) {
                return 0;
            }
        }
        for (int i = V; i >= 0; i--) {
            if (A[i] == 1) {
                return V - i;
            }
        }
        return V;
    }

    public static void main(String[] args) {
        Main solution = new Main();
        Scanner read = new Scanner(System.in);
        int V = read.nextInt();
        int n = read.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = read.nextInt();
        }
        Main B = new Main();
        System.out.print(B.Cal(V, n, A));
    }
}
import java.math.BigInteger;

public class Debug {
    public static void main(String[] args){
        StringBuilder A = new StringBuilder("123");
        System.out.println(A.toString());
        asd(A);
        System.out.println(A.toString());
    }

    static void asd(StringBuilder A){
        A.replace(0, 1, "h");
        System.out.println(A.toString());
    }
}

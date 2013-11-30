import java.util.*;

public class P353 {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextInt();
        long k1 = in.nextInt();
        long k2 = in.nextInt();
        long p1 = in.nextInt();
        long p2 = in.nextInt();
        long p3 = in.nextInt();
        long res = 0;
        if (n >= p1) {
            res += k1;
            n -= p1;
            if (n >= k2 * p2) {
                res += k2;
                n -= k2 * p2;
                res += (n + p3 - 1) / p3;
            } else {
                res += (n + p2 - 1) / p2;
            }
        }
        System.out.println(res);
    }

}

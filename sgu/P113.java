import java.util.Scanner;

public class P113 {
    public static boolean isPrime(int n) {
        if(n == 0 || n == 1)
            return false;
        if(n % 2 == 0 || n % 3 == 0 || n % 5 == 0 || n % 7 == 0)
            return n == 2 || n == 3 || n == 5 || n == 7;
        for(int i = 7; i * i <= n; i += 2) {
            if(n % i == 0)
                return false;
        }
        return true;
    }

    public static boolean isNearlyPrime(int n) {
        if(isPrime(n))
            return false;
        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0 && isPrime(i) && isPrime(n / i))
                return true;
        }
        return false;
    }

/*****************************************************************************/
    // TLE

    public static int primeFactorNum(int n) {
        int cnt = 0; 
        int i = 2; 
        while(n > 1) {
            if(n % i == 0) {
                while(n % i == 0) {
                    cnt++;
                    n /= i;
                }
            }
            i++;
        }
        return cnt;
    }

    public static int primeFactorNum_1(int n) {
        int cnt = 0;
        int end = (int) Math.sqrt(n);
        for(int i = 2; i <= end; i++) {
            if(n % i == 0) {
                while(n % i == 0) {
                    n /= i;
                }
                end = (int) Math.sqrt(n);
                cnt++;
            }
        }
        if(n > 1)
            cnt++;
        return cnt;
    }

    public static boolean isNearlyPrime_1(int n) {
        return primeFactorNum(n) == 2;
    }

/*****************************************************************************/

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cnt = in.nextInt();
        while(cnt > 0) {
            if(isNearlyPrime(in.nextInt()))
                System.out.println("Yes");
            else
                System.out.println("No");
            cnt--;
        }
    }
}

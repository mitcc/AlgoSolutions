public class Library {

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int gcd(int a, int b) {
        while(b != 0) {
            int temp = a;
            a = b;
            b = temp % a;
        }
        return a;
    }

    public boolean isPrime(int n) {
        if(n < 0)
            throw new IllegalArgumentException("negative number");
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
}



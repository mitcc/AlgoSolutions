import java.util.Arrays;

public class Prime {

    public boolean isPrime(int n) {
        if (n < 0)
            throw new IllegalArgumentException("negative number");
        if (n == 0 || n == 1)
            return false;
        if (n % 2 == 0 || n % 3 == 0 || n % 5 == 0 || n % 7 == 0)
            return n == 2 || n == 3 || n == 5 || n == 7;
        for (int i = 11; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public boolean[] isPrimeArray(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
        return prime;
    }

    public int[] primes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        int primeCount = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primeCount++;
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int[] primes = new int[primeCount];
        int i = 0;
        for (int j = 0; j < n + 1; j++) {
            if (isPrime[j]) {
                primes[i++] = j;
            }
        }
        return primes;
    }
}

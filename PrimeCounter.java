import stdlib.StdOut;

public class PrimeCounter {
    // Entry point. [DO NOT EDIT]
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdOut.println(primes(n));
    }

    // Returns true if x is prime; and false otherwise.
    private static boolean isPrime(int x) {
        // For each 2 <= i <= x / i, if x is divisible by i, then x is not a prime. If no such i
        // exists, then x is a prime.
        for (int i = 2; i <= x / i; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Returns the number of primes <= n.
    private static int primes(int n) {
        // For each 2 <= i <= n, use isPrime() to test if i is prime, and if so increment a count.
        // At the end return the count.
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                count++;


            }


        }
        return count;
    }
}
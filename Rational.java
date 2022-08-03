import stdlib.StdOut;

public class Rational {
    private long x; // numerator
    private long y; // denominator

    // Constructs a rational number whose numerator is x and denominator is 1.
    public Rational(long x) {
        // Set this.x to x and this.y to 1.
        this.x = x;
        this.y = 1;
    }

    // Constructs a rational number given its numerator x and denominator y.
    public Rational(long x, long y) {
        // Set this.x to x / gcd(x, y) and this.y to y / gcd(x, y).
        this.x = (x / gcd(x, y));
        this.y = (y / gcd(x, y));
    }

    // Returns the sum of this rational number and other.
    public Rational add(Rational other) {
        // Sum of rationals a/b and c/d is the rational (ad + bc) / bd.
        return new Rational((this.x * other.y + this.y * other.x), (this.y * other.y));
    }

    // Returns the product of this rational number and other.
    public Rational multiply(Rational other) {
        // Product of rationals a/b and c/d is the rational ac / bd.
        return new Rational((this.x * other.x), (this.y * other.y));


    }

    // Returns true if this rational number is equal to other, and false otherwise.
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }

        // Rationals a/b and c/d are equal iff a == c and b == d.
        return (this.x == ((Rational) other).x && (this.y == ((Rational) other).y));

    }


    // Returns a string representation of this rational number.
    public String toString() {
        long a = x, b = y;
        if (a == 0 || b == 1) {
            return a + "";
        }
        if (b < 0) {
            a *= -1;
            b *= -1;
        }
        return a + "/" + b;
    }

    // Returns gcd(p, q), computed using Euclid's algorithm.
    private static long gcd(long p, long q) {
        return q == 0 ? p : gcd(q, p % q);
    }

    // Unit tests the data type. [DO NOT EDIT]
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Rational total = new Rational(0);
        Rational term = new Rational(1);
        for (int i = 1; i <= n; i++) {
            total = total.add(term);
            term = term.multiply(new Rational(1, 2));
        }
        Rational expected = new Rational((long) Math.pow(2, n) - 1, (long) Math.pow(2, n - 1));
        StdOut.printf("a           = 1 + 1/2 + 1/4 + ... + 1/2^%d = %s\n", n, total);
        StdOut.printf("b           = (2^%d - 1) / 2^(%d - 1) = %s\n", n, n, expected);
        StdOut.printf("a.equals(b) = %b\n", total.equals(expected));
    }
}

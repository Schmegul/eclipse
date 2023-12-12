package Losningar.xerweek5.src.ex1useaclass;

import static java.lang.Math.abs;

/*
 *    A class representing a rational number
 *
 *    NOTE: No IO here, this is just the logical concept.
 *
 *    Test the class by running Ex1TestRational.
 *
 * See:
 * - ex1classes/
 */

public class Rational {

    private final int num;    // rational =  num / denom
    private final int denom;

    public int getNum() {
        return num;
    }

    public int getDenom() {
        return denom;
    }

    public Rational(int a) {  // Integer to RatNumb
        num = a;
        denom = 1;
    }

    public Rational(int a, int b) {  // Supply num and denom
        int d = gcd(a, b);
        if (b > 0) {
            num = a / d;
            denom = b / d;
        } else {
            num = -a / d;     // Make num store sign
            denom = -b / d;
        }
    }

    // Copy constructor
    public Rational(Rational r) {     // Copy constructor
        this(r.num, r.denom);
    }

    public double toDouble() {
        return (double) num / denom;
    }

    public Rational add(Rational r) {
        return new Rational(num * r.denom + r.num * denom, denom * r.denom);
    }

    public Rational sub(Rational r) {
        return new Rational(num * r.denom - r.num * denom, denom * r.denom);
    }

    public Rational mul(Rational r) {
        return new Rational(num * r.num, denom * r.denom);
    }

    public Rational div(Rational r) {
        return new Rational(num * r.denom, denom * r.num);
    }

    public boolean lessThan(Rational r) {
        if (denom == r.denom)
            return num < r.num;
        else
            return num * r.denom < r.num * denom;
    }

    // Euclidean alg for greatest common divisor
    private int gcd(int m, int n) {
        m = abs(m);
        n = abs(n);
        while (true) {
            int r = m % n;
            if (r == 0) {
                return n;
            }
            m = n;
            n = r;
        }
    }

    // ----- The standard Java methods ----------------

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Rational rational = (Rational) o;
        return num == rational.num && denom == rational.denom;
    }

    @Override
    public int hashCode() {
        int result = num;
        result = 31 * result + denom;
        return result;
    }

    @Override
    public String toString() {
        return num + " / " + denom;
    }
}


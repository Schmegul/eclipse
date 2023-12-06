package xerweek5.src.ex1useaclass;

import java.util.Objects;

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

    public Rational(int num, int denom) {
        if (denom == 0) {
            throw new ArithmeticException("denom can't be 0");
        }
        int gcd = gcd(num,denom);
        int a = num;
        int b = denom;
        a /= gcd;
        b /= gcd;
        if (b < 0) {
            a = -a;
            b = -b;
        }
        this.num = a; // = num
        this.denom = b; // = denom
    }
    public Rational(int num) {
        this.num = num;
        this.denom = 1;
    }

    public Rational(Rational r1) {
        this.num = r1.num;
        this.denom = r1.denom;
    }

    public int getNum() {
        return this.num;
//        try {
//            return this.num/abs(diev(this.denom,this.num));
//        }   catch (ArithmeticException e) {
//            return this.num;
//        }
    }

    public int getDenom() {
        return this.denom;
//        try {
//            return this.denom/abs(diev(this.denom,this.num));
//        }   catch (ArithmeticException e) {
//            return this.denom;
//        }
    }

    public Rational add(Rational r) {
        int r1Num = num*r.getDenom();
        int r2Num = denom*r.getNum();
        int newDenom = denom*r.getDenom();
        Rational r3 = new Rational(r1Num+r2Num,newDenom);
        return new Rational(r3.getNum(),r3.getDenom());
    }

    public Rational sub(Rational r) {
        int r1Num = num*r.getDenom();
        int r2Num = denom*r.getNum();
        int newDenom = denom*r.getDenom();
        Rational r3 = new Rational(r1Num-r2Num,newDenom);
        return new Rational(r3.getNum(),r3.getDenom());
    }


    public Rational mul(Rational r) {
        int r1Num = num*r.getNum();
        int newDenom = denom*r.getDenom();
        Rational r3 = new Rational(r1Num,newDenom);
        return new Rational(r3);
    }

    public Rational div(Rational r) {
        int r1Num = num*r.getDenom();
        int r2Num = denom*r.getNum();
        Rational r3 = new Rational(r1Num,r2Num);
        return new Rational(r3.getNum(),r3.getDenom());
    }

    public boolean lessThan(Rational r) {
        long a = (long) this.num * r.denom;
        long b = (long) this.denom * r.num;
        return a < b;
    }

    public double toDouble() {
        return (double)this.num / (double)this.denom;
    }

    public int diev(int i, int j) {
        if (i%j != 0) {
            return diev(j, i%j);
        }   else {

        return j;
        }
    }

    private static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b !=0 ) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }

    // TODO

    @Override
    public String toString() {
        return num + " / " + denom;
    }

    @Override
    public boolean equals(Object r) {
        if (r == this) {
            return true;
        }
        if (r == null || r.getClass() != this.getClass()) {
            return false;
        }
        Rational e = (Rational) r;
        return this.num == e.getNum() && this.denom == e.getDenom();
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.num, this.denom);
    }
}


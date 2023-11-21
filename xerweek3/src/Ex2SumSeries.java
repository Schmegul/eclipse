package xerweek3.src;

import static java.lang.Math.PI;
import static java.lang.Math.abs;
import static java.lang.System.out;

/*
 *  Summing series to achieve something
 *
 *  H = 1 + 1/2 + 1/3 + 1/4 + ...   (Harmonic series)
 *  PI/4 = 1 - 1/3 + 1/5 - 1/7 + 1/9 - ...    (very slow convergence)
 *
 *  Create methods to let the below print true.
 *
 * See:
 * -lectweek1
 */
public class Ex2SumSeries {

    public static void main(String[] args) {
        new Ex2SumSeries().program();
    }

    void program() {
        // How many terms from harmonic series to exceed some positive limit
        out.println(nTermsForLimitHS(1) == 2);   // Limit is 1, two terms will do
        out.println(nTermsForLimitHS(1.7) == 3); // Limit is 1.7, need 3 terms
        out.println(nTermsForLimitHS(7) == 616);

        // Calculate PI using series above
        out.println(abs(pi(100000) - PI) < 0.0001);
        out.println(pi(100000));

    }

    // ---------- Write method below this  ---------------------------
    // count how many terms are needed to surpass supplied number
    int nTermsForLimitHS (double n) {
        double number = 0;
        double count = 1;
        while (number <= n) {
            number += 1/count;
            count++;
        }

        return (int)count-1;
    }

    double pi (int precision) {

        double qPI = 0;
        for (int i = 0; i < precision; i++) {
            if (i%2 == 0) {
                qPI += (double) 1 /(1+2*i);
            }   else {
                qPI -= (double) 1/(1+2*i);
            }
        }
        qPI *= 4;

        return qPI;
    }

}

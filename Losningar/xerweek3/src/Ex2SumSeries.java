import static java.lang.Math.PI;
import static java.lang.Math.abs;
import static java.lang.System.out;

/*
 *  Summing series to achieve something
 *
 *  H = 1 + 1/2 + 1/3 + 1/4 + ...   (Harmonic series)
 *  PI/4 = 1 - 1/3 + 1/5 - 1/7 + 1/9 - ...    (very slow convergence)
 *
 *  Create methods to do the below print true.
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

    }

    // ---------- Summing series ---------------------------

    int nTermsForLimitHS(double limit) {
        double sum = 0;
        int i = 1;
        while (sum <= limit) {
            sum = sum + 1 / (double) i;
            i++;
        }
        return i - 1;
    }

    // Alt
    int nTermsForLimitHS2(double limit) {
        double sum = 0;
        int i = 1;
        while (true) {
            sum = sum + 1 / (double) i;
            if(sum > limit){
                break;
            }
            i++;
        }
        return i;
    }

    double pi(int nTerms) {
        int i = 1;
        int sign = 1;
        double pi4 = 0;
        while (i < nTerms) {
            pi4 = pi4 + sign * 1.0 / i;
            sign = -sign;
            i = i + 2;
        }
        return 4 * pi4;
    }


}

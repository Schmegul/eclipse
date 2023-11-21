package xerweek3.src;

import java.util.Objects;

import static java.lang.Math.abs;
import static java.lang.System.out;

/*
 *     Finding point of inequality in "any" type of array, i.e. where they differ
 *
 * See:
 * - lectweek3/ex2methods/..overloading...
 */
public class Ex6PointOfInequality {

    public static void main(String[] args) {
        new Ex6PointOfInequality().program();
    }

    void program() {
        int[] a0 = {1, 2};
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {1, 2, 33, 4, 5};
        double[] d1 = {1.0, 2, 33, 4.5, 6.7};
        double[] d2 = {1.0, 2, 33, 4.5, 6.711};
        String[] s1 = {"a", "b", "c", "d", "e"};
        String[] s2 = {"a", "bb", "c", "d", "e"};

        // All should print true
        out.println(diffIndex(a1, a2) == 2);  // First index from left where they differ
        out.println(diffIndex(a1, a1) == -1); // No diff
        out.println(diffIndex(a0, a1) == -1);
        out.println(diffIndex(d1, d2) == 4);
        out.println(diffIndex(s1, s2) == 1);
    }

    // ----------- Method(s) -----------------------

//        int diffIndex (Object[] a1, Object[] a2) {
//            for (int i = 0; i < Math.min(a1.length, a2.length); i++) {
//                if (a1[i] != a2[i]) {
//                    return i;
//                }
//            }
//            return -1;
//        }
        int diffIndex (int[] a1, int[] a2) {
            for (int i = 0; i < Math.min(a1.length, a2.length); i++) {
                if (a1[i] != a2[i]) {
                    return i;
                }
            }
            return -1;
        }

        int diffIndex (double[] a1, double[] a2) {
            for (int i = 0; i < Math.min(a1.length, a2.length); i++) {
                if (a1[i] != a2[i]) {
                    return i;
                }
            }
            return -1;
        }
        int diffIndex (String[] a1, String[] a2) {
            for (int i = 0; i < Math.min(a1.length, a2.length); i++) {
                if (!a1[i].equals(a2[i])) {
                    return i;
                }
            }
            return -1;
        }
}

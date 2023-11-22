package Losningar.xerweek3.src;

import static java.lang.Math.abs;
import static java.lang.System.out;

/*
 * Finding point of inequality in "any" type of array, i.e. where they differ
 *
 * See:
 * - lectweek4/ex2methods/M1Overloading
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

    int diffIndex(int[] arr1, int[] arr2) {
        int index = -1;
        if (arr1.length != arr2.length) {   // TODO
            return index;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return i;
            }
        }
        return index;
    }

    // Overloaded
    int diffIndex(double[] arr1, double[] arr2) {
        int index = -1;
        if (arr1.length != arr2.length) {
            return index;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (abs(arr1[i] - arr2[i]) > 0.000000001) {  // Possible eps as parameter
                return i;
            }
        }
        return index;
    }

    // Overloaded
    int diffIndex(String[] arr1, String[] arr2) {
        int index = -1;
        if (arr1.length != arr2.length) {
            return index;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return i;
            }
        }
        return index;
    }



}

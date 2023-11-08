import java.util.Arrays;
import java.util.Random;

import static java.lang.StrictMath.round;
import static java.lang.System.*;

/*
 *  Methods with array params and/or return value. Implement methods.
 *
 *  See:
 *  ex2references
 *  ex3methods
 *  ex4algorithms
 *  - in particular A1BasicAlgs
 */
public class Ex1ArrayMethods {

    public static void main(String[] args) {
        new Ex1ArrayMethods().program();
    }

    final static Random rand = new Random();

    void program() {
        int[] arr = {1, 2, 2, 5, 3, 2, 4, 2, 7};  // Hard coded test data

        // Uncomment one at a time and implement

        // Count occurrences of some element in arr
        out.println(count(arr, 2) == 4);      // There are four 2's
        out.println(count(arr, 7) == 1);

        // Generate array with 100 elements with 25% distribution of -1's and 1's (remaining will be 0)
        arr = generateDistribution(100, 0.25, 0.25);
        out.println(count(arr, 1) == 25);
        out.println(count(arr, -1) == 25);
        out.println(count(arr, 0) == 50);

        // Generate array with 14 elements with 40% 1's and 30% -1's
        arr = generateDistribution(14, 0.4, 0.3);
        out.println(count(arr, 1) == 6);
        out.println(count(arr, -1) == 4);

        for (int i = 0; i < 10; i++) {
            // Random reordering of arr, have to check by inspecting output
            shuffle(arr);
            out.println(Arrays.toString(arr));  // Does it look random?
        }
    }


    // ---- Write methods below this ------------

    int count(int[] arr, int n) {
        int c = 0;
        for (int i = 0 ; i < arr.length ; i++) {
            if (i == n) {
                c++;
            }
        }
        return c;
    }

    int[] generateDistribution(int nElements, double percentPositive, double percentNegative) {
        int[] result = new int[nElements];
        int nPos = (int) round(percentPositive * nElements);
        int nNeg = (int) round(percentNegative * nElements);

        int i = 0;
        while (nPos > 0) {
            result[i] = 1;
            nPos--;
            i++;
        }
        while (nNeg > 0) {
            result[i] = -1;
            nNeg--;
            i++;
        }
        return result;
    }

    // Uses Fisher - Yates algorithm
    void shuffle(int[] arr) {
        for (int i = arr.length; i > 1; i--) {
            int j = rand.nextInt(i);
            int tmp = arr[j];
            arr[j] = arr[i - 1];
            arr[i - 1] = tmp;
            //out.println("Swap " + j + ":" + (i-1) + "-->" + Arrays.toString(arr));
        }
    }

}

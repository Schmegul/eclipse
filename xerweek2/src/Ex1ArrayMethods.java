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
        out.println(count(arr, -1) == 6);
        out.println(count(arr, 1) == 4);

        for (int i = 0; i < 10; i++) {
            // Random reordering of arr, have to check by inspecting output
            shuffle(arr);
            out.println(Arrays.toString(arr));  // Does it look random?
        }
    }


    // ---- Write methods below this ------------

    int count (int[] arr, int d) {
        //find number of items d in the array
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == d) {
                counter++;
            }
        }
        return counter;
    }

    int[] generateDistribution (int lgnth, double dist1, double dist2) {
        int[] full = new int[lgnth];
        long d1 = round(lgnth*dist1);
        long d2 = round(lgnth*dist2);


        for (int j = 0; j < lgnth; j++) {
            full[j] = 0;
            for (int i = 0; i < d1; i++) {
                full[i] = -1;
            }

            for (double i = d1; i < d1+d2; i++) {
                full[(int)i] = 1;
            }

        }

        return full;
    }

    void shuffle (int[] array) {

        for (int i = array.length; i > 1; i--) {
            int random = rand.nextInt(i);
            int temp = array[random];
            array[random] = array[i-1];
            array[i-1] = temp;
        }









//        int egg = count(array, 1);
//        int egg2 = count (array, -1);
//        int [] empty = new int[100];
//        int counter1 = 0;
//        int counter2 = 0;
//        int index = 0;
//        int random;
//
//
//        while (counter1 < egg || counter2 < egg2) {
//            random = rand.nextInt(0, 100);
//
//            if (array[random] == 1 && counter1 < egg) {
//                empty[index] = 1;
//                counter1++;
//                index++;
//
//            }   else if (array[random] == -1 && counter2 < egg2) {
//                empty[index] = -1;
//                counter2++;
//                index++;
//            }
//        }
//
//
//

    }
}

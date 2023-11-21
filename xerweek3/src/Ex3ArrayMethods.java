package xerweek3.src;

import java.util.Arrays;

import static java.lang.System.*;

/*
 *  Some harder array methods
 *
 * See
 * - lectweek2
 */
public class Ex3ArrayMethods {


    public static void main(String[] args) {
        new Ex3ArrayMethods().program();
    }

    void program() {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8};

        // Rotate all elements in the arr k steps to the right (in a circular fashion)
        // Assume arr.length > 0. NOTE: Original array changed!
        rotate(arr1, 3);
        out.println(Arrays.toString(arr1).equals("[6, 7, 8, 1, 2, 3, 4, 5]"));
        rotate(arr1, 0);
        out.println(Arrays.toString(arr1).equals("[6, 7, 8, 1, 2, 3, 4, 5]"));
        rotate(arr1, arr1.length);
        out.println(Arrays.toString(arr1).equals("[6, 7, 8, 1, 2, 3, 4, 5]"));
        rotate(new int[]{1}, 3);
        out.println();

        // Same as above but here we have a return value
        //int[] r = rotate2(new int[]{1, 2, 3, 4, 5}, 2);  // Return value!
        //out.println(Arrays.toString(r).equals("[4, 5, 1, 2, 3]"));
        //r = rotate2(new int[]{1, 2, 3, 4, 5}, 5);  // Return value!
        //out.println(Arrays.toString(r).equals("[1, 2, 3, 4, 5]"));


        int[] arr2 = {1, 2, 2, 3, 3};   // All sorted in increasing order
        int[] arr3 = {1, 2, 3, 4, 5};
        int[] arr4 = {1, 1, 1, 1, 1, 1};
        int[] arr5 = {1};

        // Remove all duplicates from arr2, ... (original unchanged, copy created)
        // NOTE: Assume arr is sorted in increasing order and > 0
        out.println(Arrays.toString(removeDupl(arr2)).equals("[1, 2, 3]"));
//        out.println(Arrays.toString(removeDupl(arr4)));
        out.println(Arrays.toString(arr2).equals("[1, 2, 2, 3, 3]"));   // arr2 unchanged!
        out.println(Arrays.toString(removeDupl(arr3)).equals("[1, 2, 3, 4, 5]"));
        out.println(Arrays.toString(removeDupl(arr4)).equals("[1]"));
        out.println(Arrays.toString(removeDupl(arr5)).equals("[1]"));


        arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        // Use fact that array is sorted to search efficiently
        //out.println(search(arr1, 1) == 0);
        //out.println(search(arr1, 3) == 2);
        //out.println(search(arr1, 8) == 7);

    }

    // -------------- Methods --------------------------

    void rotate (int[] arr, int n) {

        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[(i+n)%arr.length] = arr[i];

        }
        System.arraycopy(temp, 0, arr, 0, temp.length);
    }

    int[] removeDupl(int[] arr) {
        int amountOfDups = 0;
        int indexd;
        for (int i = 0; i < arr.length; i+=indexd+1) {
            indexd = 0;
            int item = arr[i];
            int index = i+1;
            int foundDups = 0;
            while (index <arr.length && arr[index] == item) {
                foundDups++;
                amountOfDups++;
                index++;
            }
            indexd += foundDups;
        }

        int[] filtered = new int[arr.length-amountOfDups];
        int[] prohibited = new int[arr.length-amountOfDups];
        int index = 0;

        for (int j : arr) {
            if (!isProhibited(j, prohibited)) {
                filtered[index] = j;
                prohibited[index] = j;
                index++;
            }

        }
        return filtered;
    }

    boolean isProhibited (int item, int[] prohib) {

        for (int j : prohib) {
            if (item == j) {
                return true;
            }
        }
        return false;
    }

    int search (int[] arr, int n) {
       int d = arr[n];

        return n;
    }
}


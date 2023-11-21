package Losningar.xerweek3.src;

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

        // TODO remove
        //out.println(countUniques(new int[]{1, 2, 2, 2, 2, 3, 4, 4, 5, 5}));
        //out.println(countUniques(arr2));

        // Rotate all elements in the arr k steps to the right (in a circular fashion)
        // Assume arr.length > 0. NOTE: Original array changed!
        rotate(arr1, 3);
        out.println(Arrays.toString(arr1).equals("[6, 7, 8, 1, 2, 3, 4, 5]"));
        rotate(arr1, 0);
        out.println(Arrays.toString(arr1).equals("[6, 7, 8, 1, 2, 3, 4, 5]"));
        rotate(arr1, arr1.length);
        out.println(Arrays.toString(arr1).equals("[6, 7, 8, 1, 2, 3, 4, 5]"));
        rotate(new int[]{1}, 3);

        // Same as above but here we have a return value
        int[] r = rotate2(new int[]{1, 2, 3, 4, 5}, 2);  // Return value!
        out.println(Arrays.toString(r).equals("[4, 5, 1, 2, 3]"));
        r = rotate2(new int[]{1, 2, 3, 4, 5}, 5);  // Return value!
        out.println(Arrays.toString(r).equals("[1, 2, 3, 4, 5]"));


        int[] arr2 = {1, 2, 2, 3, 3};   // All sorted in increasing order
        int[] arr3 = {1, 2, 3, 4, 5};
        int[] arr4 = {1, 1, 1, 1, 1, 1};
        int[] arr5 = {1};

        // Remove all duplicates from arr2, ... (original unchanged, copy created)
        // NOTE: Assume arr is sorted in increasing order and > 0
        out.println(Arrays.toString(removeDupl(arr2)).equals("[1, 2, 3]"));
        out.println(Arrays.toString(arr2).equals("[1, 2, 2, 3, 3]"));   // arr2 unchanged!
        out.println(Arrays.toString(removeDupl(arr3)).equals("[1, 2, 3, 4, 5]"));
        out.println(Arrays.toString(removeDupl(arr4)).equals("[1]"));
        out.println(Arrays.toString(removeDupl(arr5)).equals("[1]"));


        arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        // Use fact that array is sorted to search efficiently
        out.println(search(arr1, 1) == 0);
        out.println(search(arr1, 3) == 2);
        out.println(search(arr1, 8) == 7);

    }

    // -------------- Methods --------------------------

    // This also preserve original (optional)
    int[] rotate2(int[] arr, int k) {
        int j = k % arr.length;
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[(i + j) % arr.length] = arr[i];
        }
        return result;
    }

    // One (a bit complex) way to do it
    void rotate(int[] arr, int k) {
        int j = k % arr.length;
        int[] tmp = new int[j];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = arr[i + arr.length - j];
        }
        for (int i = arr.length - j - 1; i >= 0; i--) {
            arr[i + j] = arr[i];
        }
        for (int i = 0; i < tmp.length; i++) {
            arr[i] = tmp[i];
        }
    }

    int[] removeDupl(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int count = countUniques(arr);
        int[] result = new int[count];
        int i = 1;
        int j = 0;
        result[0] = arr[0];
        while (i < arr.length - 1) {
            if (arr[i] != result[j]) {
                j++;
                result[j] = arr[i];
            }
            i++;
        }
        result[result.length - 1] = arr[arr.length - 1];
        return result;
    }

    int countUniques(int[] arr) {
        int i = 0;
        int count = 1;
        while (i < arr.length - 1) {
            if (arr[i] != arr[i + 1]) {
                count++;
            }
            i++;
        }
        return count;
    }

    int[] removeDupl2(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        return null;
    }

    boolean contains(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (value == arr[i]) {
                return true;
            }
        }
        return false;
    }

    // Binary search in sorted array!
    int search(int[] arr, int value) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (value < arr[mid]) {
                hi = mid - 1;
            } else if (value > arr[mid]) {
                lo = mid + 1;
            } else {
                return mid; // Index start at 0
            }
        }
        return -1;
    }

}


package Losningar.xerweek3.src;

import java.util.Arrays;
import java.util.Random;

import static java.lang.System.out;

/*
 * Implement generic versions of shuffle and sort
 *
 *  See:
 * - ex2methods/M3GenericMethod
 */
public class Ex7GenericMethods {

    public static void main(String[] args) {
        new Ex7GenericMethods().program();
    }

    final Random rand = new Random();

    void program() {

        // TODO Uncomment and implement
        // Working with wrapper types, generic methods only work with reference types
        Integer[] is = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String origIs = Arrays.toString(is);
        String[] ss = {"a", "b", "c", "d", "e"};
        String origSS = Arrays.toString(ss);

        // diffIndex works for all arrays reference types
        out.println(diffIndex(is, is) == -1);
        out.println(diffIndex(ss, ss) == -1);

        // shuffle should be a generic method, so we can use it for Integers ...
        shuffle(is);
        out.println(!Arrays.toString(is).equals(origIs));  // May be false, but unlikely
        // ... and here for String.
        shuffle(ss);
        out.println(!Arrays.toString(ss).equals(origSS));

        // sort should also be generic
        sort(is);
        out.println(Arrays.toString(is).equals(origIs));
        sort(ss);
        out.println(Arrays.toString(ss).equals(origSS));

    }

    // ------- Methods -------------------------

    <T> int diffIndex(T[] arr1, T[] arr2) {
        int index = -1;
        if (arr1.length != arr2.length) {    // TODO
            return index;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return i;
            }
        }
        return index;
    }

    <T> void shuffle(T[] arr) {
        for (int i = arr.length; i > 1; i--) {
            int j = rand.nextInt(i);
            T tmp = arr[j];
            arr[j] = arr[i - 1];
            arr[i - 1] = tmp;
        }
    }

    // This is HARD! Integer is comparable
    <T extends Comparable<T>> void sort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {   // [j] > [j+1]
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

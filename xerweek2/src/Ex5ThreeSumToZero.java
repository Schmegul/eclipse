package xerweek2.src;

import java.util.Arrays;

import static java.lang.System.out;

/*
    Find three elements in sorted array that adds up to 0.
    Return indices to the elements as an array.
 */
public class Ex5ThreeSumToZero {

    public static void main(String[] args) {
        new Ex5ThreeSumToZero().program();
    }


    void program() {
        int[] arr1 = {-25, -10, -7, -3, 2, 4, 8, 10}; // Must be sorted
        int[] arr2 = {0, 1, 2, 4, 8, 10};
        int[] arr3 = {-2, 1, 1};
        int[] arr4 = {0, 0, 0, 0};

        out.println(Arrays.toString(getThreeSum(arr1)));    // [1, 4, 6]
        out.println(Arrays.toString(getThreeSum(arr2)));    // []
        out.println(Arrays.toString(getThreeSum(arr3)));    // [0, 1, 2]
        out.println(Arrays.toString(getThreeSum(arr4)));    // [ 0, 1 ,3 ] or any
    }

    // NOTE: Solution may not contain nested loops
    int[] getThreeSumB(int[] arr) {

        return null;
    }








    int[] getThreeSum(int[] arr) {

        int l = 0;
        int r = arr.length - 1;

        while (r -l > 2) {
            int closest = (arr[l] + arr[(l + r) / 2] + arr[r]);
            int closestLow = closest;
            int closestHigh = -closest;
            for (int m = l+1; m < r; m++) {
                int sum3 = arr[l] + arr[m] + arr[r];
                if (sum3 > 0) {
                    closestHigh = Math.min(closestHigh, sum3);
                }   else if (sum3 < 0) {
                    closestLow = Math.max(closestLow, sum3);
                }   else {
                    return new int[] {l, m, r};
                }

            }
            if (Math.abs(closestLow) > closestHigh) {
                l++;
            }   else {
                r--;
            }
        }
        return new int[] {};
    }
}

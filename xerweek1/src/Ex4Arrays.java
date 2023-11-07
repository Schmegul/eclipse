import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 * Program to exercise arrays
 *
 * See:
 * - ex3arraysfor
 * - Check AF6AritmSeries
 */
public class Ex4Arrays {

    public static void main(String[] args) {
        new Ex4Arrays().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
        out.print("Input 5 integers (space between, then enter) >");
        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        out.println("Array is: " + Arrays.toString(arr));
        out.print("Input a value to find >");
        int chosen = sc.nextInt();
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            if (chosen == arr[i]) {
                out.println("Value " + chosen + " is at index " + i);
                found = true;
                }
            }
        if (!found){
            out.print("Value not found");

        }
    }
}

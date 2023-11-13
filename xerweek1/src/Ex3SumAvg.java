package xerweek1.src;

import java.util.Scanner;

import static java.lang.System.*;;

/*
 * Program to calculate sum and average for non-negative integers
 *
 * See:
 * - ex2ifwhile
 * - IW5LoopAndAHalf in particular.
 *
 */
public class Ex3SumAvg {

    public static void main(String[] args) {
        new Ex3SumAvg().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
        // Write your code here
        double storage = 0;
        int counter = 0;
        // -- Input (and bookkeeping)
        while ( true ) {
            int temp = sc.nextInt();
            if (temp ==-1) {
                break;
            } else {
                storage = storage + temp;
                counter++;
            }
        }
        // -- Process---

        // -- Output ----
        out.println("Sum = " + storage + " Avg = " + storage/counter);

    }

}

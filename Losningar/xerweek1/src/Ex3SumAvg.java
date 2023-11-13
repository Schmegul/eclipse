package Losningar.xerweek1.src;

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
        int sum = 0;   // Or double sum?
        int count = 0;

        // -- Input (and bookkeeping)
        while (true) {                     // Loop and a half
            out.print(" > ");
            int i = sc.nextInt();
            if (i < 0) {
                break;
            }
            count++;
            sum = sum + i;
        }

        // -- Process---
        double avg = (double) sum / count;

        // -- Output ----
        out.println("Sum = " + sum + " Avg = " + avg);
    }

}

package Losningar.xerweek1.src;

import static java.lang.System.out;

/*
 *  Implement methods to make program produce correct output (normally print true)
 *
 * See:
 * - ex4methods
 */
public class Ex5Methods {

    public static void main(String[] args) {
        new Ex5Methods().program();
    }

    void program() {
        // All, except last,  should print true
        // Uncomment one at the time
        out.println(sumTo(5) == 15);     // 1 + 2 + ... + 5 = 15
        out.println(sumTo(23) == 276);
        out.println(factorial(3) == 6);    // 3 * 2 * 1 = 6
        out.println(factorial(5) == 120);
        out.println(digitSum(1111) == 4);   // 1 + 1 + 1 + 1 = 4
        out.println(digitSum(12345) == 15);

        String winner = "Olle";
        // A special case, should print: "Winner is Olle" (or whatever name)
        winnerMsg(winner);
    }

    // ------ Write methods below this  -----------

    // Declaration
    int sumTo(int n) {
        int sum = 1;
        for (int i = 2; i <= n; i++) {
            sum = sum + i;
        }
        return sum;
    }

    int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    int digitSum(int n) {
        int i = n;
        int sum = 0;
        int digit;
        while (i > 0) {
            digit = i % 10;
            sum = sum + digit;
            i = i / 10;
        }
        return sum;
    }

    void winnerMsg(String winnerName) {
        out.println("Winner is " + winnerName);
    }

}

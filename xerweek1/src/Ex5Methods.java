package xerweek1.src;

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
        int sumTo(int n) {
            int sum = 0;
            for (int i = 0; i <= n ; i ++){
                sum += i;
            }
            return sum;
        }

        int factorial (int n) {
            int prod = 1;
            for (int i = 1; i <=n; i++){
                prod *= i;
            }
            return prod;
        }

        int digitSum (int n) {
            int sum = 0;
            while (n>0) {
                sum += (n%10);
                n=n/10;
            }
            return sum;
        }

        void winnerMsg (String n) {
            out.println("Winner is "+ n);
        }

}

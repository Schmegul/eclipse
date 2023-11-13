import java.util.Random;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 * The Rock, paper, scissor game.
 * See https://en.wikipedia.org/wiki/Rock%E2%80%93paper%E2%80%93scissors
 *
 * This is exercising smallest step programming (no methods needed)
 * Write the full program in program()
 *
 * Rules:
 *
 *       -----------  Beats -------------
 *       |                              |
 *       V                              |
 *      Rock (1) --> Scissors (2) --> Paper (3)
 *
 */
public class Ex8RPS {

    public static void main(String[] args) {
        new Ex8RPS().program();
    }

    final Random rand = new Random();
    final Scanner sc = new Scanner(in);

    void program() {

        int maxRounds = 5;
        int human;          // Outcome for player
        int computer;       // Outcome for computer
        int result;         // Result for this round
        int round = 0;      // Number of rounds
        int total = 0;      // Final result after all rounds

        // All code here ... (no method calls)

        out.println("Welcome to Rock, Paper and Scissors");

        while (round < maxRounds) {  // Game loop
            // -------- Input --------------
            while (true) {
                out.print("Select 1, 2 or 3 (for R, P or S) > ");
                human = sc.nextInt();
                if (1 <= human && human <= 3) {
                    break;
                }
            }
            computer = rand.nextInt(3) + 1;         // Get a random integer 1-3
            out.println("Computer choose: " + computer);

            // ----- Process -----------------
            // There are other ways to compare (but it shouldn't be too long)
            if (human % 3 == (computer + 1) % 3) {  // Computer win (human is one step ahead)
                result = -1;
                total--;
            } else if (human % 3 == (computer + 2) % 3) {  // Human win (human is 2 steps ahead)
                result = 1;
                total++;
            } else {
                result = 0;   // Draw
            }

            // ---------- Output --------------

            if (result == 0) {
                out.println("A draw");
            } else if (result > 0) {
                out.println("You won");
            } else {
                out.println("Computer won");
            }
            out.println("Result " + total);  // Result

            round++;
        }

        out.println("Game over! ");
        if (total == 0) {
            out.println("Draw");
        } else if (total > 0) {
            out.println("Human won.");
        } else {
            out.println("Computer won.");
        }
    }
}

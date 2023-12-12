package Losningar.xerweek5.src.ex4hangman;

/*
 *  The Hangman game (in a text version)
 *  See: https://en.wikipedia.org/wiki/Hangman_(game)
 *  This is the game logic
 *
 *  This illustrated the concept of an "OO-model" (i.e. many connected
 *  objects from different classes). Objects working together
 *
 *  See:
 *    - ex2oomodels
 */
public class HangMan {

    public enum Result {
        NONE, WIN, LOSE;
    }

    private final Man man;        // Other object in model
    private final Secret secret;  // Other object in model
    private int nGuess = 0;
    private Result result = Result.NONE;

    public HangMan(Man man, Secret secret) {
        this.man = man;
        this.secret = secret;
    }

    // The game logic
    public void update(char ch) {
        if (secret.contains(ch)) {
            secret.updateMask(ch);
            if (secret.foundAnswer()) {
                result = Result.WIN;
            }
        } else {
            man.punish();
            if (man.isDead()) {
                result = Result.LOSE;
            }
        }
        nGuess++;
    }

    // ----- Getters used by CLI ------------------------

    public int getNGuess() {
        return nGuess;
    }

    public Result getResult() {
        return result;
    }

    public int getManHealth() {
        return man.getHealth();
    }

    public String getMask() {
        return secret.getMask();
    }

    public String getAnswer() {
        return secret.getAnswer();
    }


}

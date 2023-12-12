package Losningar.xerweek5.src.ex4hangman;

/*
 *  Representing the man
 */
public class Man {

    private int health;

    public Man(int maxParts) {
        this.health = maxParts;
    }

    public void punish() {
        if (health > 0) {
            health--;
        }
    }

    public int getHealth() {
        return health;
    }

    public boolean isDead() {
        return health == 0;
    }

}

package Losningar.xerweek5.src.ex4hangman;

/*
 * This represents the secret word to guess
 */
public class Secret {

    private final String answer;
    private String mask;  // Masking the answer, initially like _______ (underscores)

    public Secret(String answer) {
        this.answer = answer.toLowerCase().trim();
        // Replace any char (the .) with underscore
        this.mask = answer.replaceAll(".", "_");
    }

    public void updateMask(char guess) {
        StringBuilder sb = new StringBuilder();
         for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == guess) {
                sb.append(guess);
            } else {
                sb.append(mask.charAt(i));
            }
        }
        mask = sb.toString();
    }

    public boolean foundAnswer() {
        return answer.equals(mask);
    }

    public boolean contains(char ch) {
        return answer.indexOf(ch) >= 0;
    }

    public String getAnswer() {
        return answer;
    }

    public String getMask() {
        return mask;
    }
}

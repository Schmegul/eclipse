import static java.lang.System.out;

/*
 * A String problem
 *
 * See:
 * - ex3string
 */
public class Ex5StringOrdering {

    public static void main(String[] args) {
        new Ex5StringOrdering().program();
    }

    void program() {

        // Yes, "aa bb cc" is ordered like "abc" because all
        // a's are before all b's that are before all c's
        out.println(isOrdered("abc", "aa bb cc"));
        // Yes, all a's before all b's
        out.println(isOrdered("ab", "aa eee bb ddd cc"));
        // Yes, all e's before all c's
        out.println(isOrdered("ec", "aa eee becb c dddc"));

        // Not all c's are before all b's
        out.println(!isOrdered("acb", "aa bb cc"));
        // Not all b's before all c's
        out.println(!isOrdered("abc", "aa bb ccc b"));
        // No!
        out.println(!isOrdered("bac", "aa eee bbb ddd ccc"));

        // Degenerate cases
        // TODO have a look, remove
        out.println(isOrdered("a", "aa bb cc"));
        out.println(isOrdered("x", "aa bb cc"));
        out.println(isOrdered("", "aa bb cc"));
        out.println(isOrdered("abc", ""));
        out.println(!isOrdered("ax", "aa bb cc"));
        out.println(isOrdered("xa", "aa bb cc"));
    }


    // Depends on transitivity if "ab" && "bc" then "ac"
    public boolean isOrdered(String ordering, String target) {
        for (int i = 0; i < ordering.length() - 1; i++) {
            int lastIndex = target.lastIndexOf(ordering.charAt(i));
            int index = target.indexOf(ordering.charAt(i + 1));
            if (lastIndex > index) {
                return false;
            }
        }
        return true;
    }

    // ------- Alternatives (worse) ----------------

    public boolean isOrdered2(String ordering, String target) {
        int allowedPos = 0;
        for (int i = 0; i < ordering.length(); i++) {
            char actual = ordering.charAt(i);
            int lastPos = -1;
            for (int j = 0; j < target.length(); j++) {
                if (target.charAt(j) == actual) {
                    if (j < allowedPos) {
                        return false;
                    } else {
                        lastPos = j;
                    }
                }
            }
            if (lastPos != -1) {
                allowedPos = lastPos + 1;
            }
        }
        return true;
    }

    public boolean isOrdered3(String ordering, String target) {
        String pre = ordering;
        // Going backwards
        for (int n = ordering.length() - 1; n > 0; n--) {
            char actual = ordering.charAt(n);
            pre = pre.substring(0, pre.length() - 1);
            int i = target.indexOf(actual);
            for (int j = i + 1; j < target.length(); j++) {
                char ch = target.charAt(j);
                if (pre.indexOf(ch) >= 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // Doesn't work a later char may break it
    public boolean isOrdered4(String ordering, String target) {
        String trg = filter(ordering, target);
        StringBuilder sb = new StringBuilder();
        for (char ch : trg.toCharArray()) {
            if (sb.indexOf(Character.toString(ch)) < 0) {
                sb.append(ch);
            }
        }
        return sb.toString().equals(ordering);
    }

    // Remove filter out all char in target that is in ordering
    String filter(String order, String target) {
        StringBuilder sb = new StringBuilder();
        for (char ch : target.toCharArray()) {
            if (order.indexOf(ch) >= 0) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }


}

package tentauppgifter.exempeltentax;

public class StringExpander {
    public static void main(String[] args) {
        System.out.println(expand("3(egg)2(de)0(iii)"));
    }
    static String expand(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length();i++) {
            int m = s.charAt(i) - '0';
            i+=2;
            int ss = i;
            int se = i;
            for(int j = i; j < s.length() && s.charAt(j)!=')';j++) {
                se = j+1;
            }
            String elem = s.substring(ss,se);
            for(int j = 0; j < m; j++) {
                sb.append(elem);
            }
            i = se;
        }

        return sb.toString();
    }
}

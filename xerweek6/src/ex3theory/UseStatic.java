package xerweek6.src.ex3theory;

import static java.lang.System.out;

/*
      If uncommenting you will get compile errors? Explain, in depth!

      See:
      - week5/ex3static
 */
public class UseStatic {

    private static int i;
    private int j;

    public static void main(String[] args) {
        //doIt();
        doOther();
    }

    void doIt() {
        out.println(i);
        out.println(j);
        this.doOther();
    }

    static void doOther() {
        out.println(i);
        //out.println(j);
        //this.doIt();
    }

}

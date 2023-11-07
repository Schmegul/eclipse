package fromweek3;

/*
         Which rows compile?
         Try to predict then uncomment.
 */

public class T1 {

    public static void main(String[] args) {
        new T1().program();
    }

    void program() {

        int i = 0;
        double d = 0;
        Double dd = 0.0;
        Dir dir = null;
        Point2D p = null;
        Object o = null;

        //i = d;                         // 1
        //d = i;                         // 2
        //dd = i;                        // 3
        //d = dd;                        // 4
        //dir = (Dir) new Point2D();     // 5
        //o = dir;                       // 6
        //p = o;                         // 7
        //dir = (Dir) o;                 // 8
        //p = (Point2D) o;               // 9
        //(double) i = d;                // 10

    }

    class Point2D {
        double x;
        double y;
    }

    enum Dir {
        UP, DOWN, LEFT, RIGHT
    }

}

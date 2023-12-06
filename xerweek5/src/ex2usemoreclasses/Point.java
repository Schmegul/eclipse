package xerweek5.src.ex2usemoreclasses;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/*

  A class for points in 3D. Should be immutable

  NOTE: No IO here, this is just the logical concept.

  To test run Ex2TestPointTriangle

 * See:
 * - ex1classes/
*/
public class Point {
    private final int x, y, z;
    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point(Point p) {
        this.x = p.x;
        this.y = p.y;
        this.z = p.z;
//        this(p.x,p.y,p.z);    // same but shorter
    }

    public double distance(Point p) {
        int xd = this.x - p.x;
        int yd = this.y - p.y;
        int zd = this.z - p.z;
        return Math.sqrt(xd * xd + yd * yd + zd * zd);
    }

}



package Losningar.xerweek5.src.ex2usemoreclasses;

import java.util.Arrays;

import static java.lang.Math.sqrt;

/*
      A class for a Triangle in 3D
      Should use Point class and Herons formula

      NOTE: No IO here, this is just the logical concept.

      To test run Ex2TestPointTriangle

 * See:
 * - ex1classes/
 * - ex2oomodels/
*/
public class Triangle {

    private final Point[] pts = new Point[3];

    public Triangle(Point pt1, Point pt2, Point pt3) {
        this.pts[0] = pt1;
        this.pts[1] = pt2;
        this.pts[2] = pt3;
    }

    public double area() {
        double s1 = pts[0].distance(pts[1]);
        double s2 = pts[1].distance(pts[2]);
        double s3 = pts[2].distance(pts[0]);
        // Herons formula
        double s = 0.5 * (s1 + s2 + s3);
        return sqrt(s * (s - s1) * (s - s2) * (s - s3));
    }

    // Generated and modified
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle t = (Triangle) o;
        return pts[0].equals(t.pts[0])      // Have to modify to this
                && pts[1].equals(t.pts[1])
                && pts[2].equals(t.pts[2]);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(pts);
    }

}


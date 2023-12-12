package xerweek5.src.ex2usemoreclasses;

import java.util.List;
import java.util.Objects;

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

    private final Point x;
    private final Point y;
    private final Point z;

    public Triangle(Point x, Point y, Point z) {
        this.x = Objects.requireNonNull(x);
        this.y = Objects.requireNonNull(y);
        this.z = Objects.requireNonNull(z);
    }

    public double area() {
        double a = x.distance(y);
        double b = y.distance(z);
        double c = z.distance(x);
        double k = 0.5 * (a + b + c);
        return Math.sqrt(k * (k - a) * (k - b) * (k - c));
    }
//
//    public boolean containsr(Triangle r) {
//        Point i = r.x;
//        return true;
//    }
}


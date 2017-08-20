package algs4;

import edu.princeton.cs.algs4.*;

public class Interval2DTest {
    public static void main(String[] args) {
        double xlo = StdRandom.uniform();
        double xhi = StdRandom.uniform();
        double ylo = StdRandom.uniform();
        double yhi = StdRandom.uniform();
        int T = StdRandom.uniform(10000);

        Interval1D x_interval = new Interval1D(xlo, xhi);
        Interval1D y_interval = new Interval1D(ylo, yhi);
        Interval2D box = new Interval2D(x_interval, y_interval);
        box.draw();

        Counter c = new Counter("hits");
        for (int t = 0; t < T; t++) {
            double x = Math.random();
            double y = Math.random();
            Point2D p = new Point2D(x, y);
            if (box.contains(p)) c.increment();
            else                 p.draw();
        }
        StdOut.println(c);
        StdOut.println(box.area());
    }
}

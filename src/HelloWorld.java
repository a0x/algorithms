import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class HelloWorld {

    private static int mystery(int a, int b) {
        if (b == 0) return 0;
        if (b % 2 == 0) return mystery(a+a, b/2);
        return mystery(a+a, b/2) + a;
    }
    public static void main(String args[]) {

        int N = 100;
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, N*N);
        StdDraw.setPenRadius(.01);
        for (int i = 1; i <= N; i++)
        {
            StdDraw.point(i, 1);
            StdDraw.point(i, i*i);
            StdDraw.point(i, i*Math.log(i));
        }

//        int N = 50;
        double[] a = new double[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform();
        Arrays.sort(a);
        for (int i = 0; i < N; i++)
        {
            double x = 1.0 * i/N;
            double y = a[i] / 2.0;
            double rw = 0.5 / N;
            double rh = a[i] / 2.0;
            StdDraw.filledRectangle(x,y,rw,rh);
        }
        System.out.println(mystery(2,25));
        System.out.println(mystery(3,11));
    }
}

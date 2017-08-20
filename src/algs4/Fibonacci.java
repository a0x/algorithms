package algs4;

import edu.princeton.cs.algs4.StdOut;

public class Fibonacci {
    private static long F(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N-1) + F(N-2);
    }

    public static void main(String args[]) {
        for (int N = 0; N < 100; N++)
            StdOut.println(N + " " + F(N));
    }
}

//class lnn {
//    private static double ln(int n) {
////        double result = 0.0;
////        for (int i = 1; i <= n; i++)
////            result += Math.log(i);
////        return result;
//
//        if (n == 1) return Math.log(1);
//        return Math.log(n) + ln(n-1);
//    }
//    public static void main(String args[]) {
//        for (int n = 1; n <= 100; n++)
//            StdOut.println(n + " " + ln(n));
//    }
//}
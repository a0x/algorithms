package algs4;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Random;

public class FlipsMax {
    private static Counter max(Counter x, Counter y) {
        if (x.tally() > y.tally()) return x;
        else                       return y;
    }
    public static void main(String[] args) {
        Random random = new Random();
        int T = random.nextInt();
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");
        for (int t = 0; t < T; t++)
            if (StdRandom.bernoulli(0.5))
                heads.increment();
            else tails.increment();

        if (heads.tally() == tails.tally())
            StdOut.println("Tie");
        else StdOut.println(max(heads, tails) + " wins");
    }
}

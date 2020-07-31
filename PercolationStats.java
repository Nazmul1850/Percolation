/* *****************************************************************************
 *  Name:    Nazmul Hasan
 *  NetID:   1234
 *  Precept: P00
 *
 *  Description:  percolate mean standard deviation
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;


public class PercolationStats {

    private final int trials;
    private final double[] x;
    private double CONFIDENCE_95 = 1.96;
    private double mean;
    private double stddev;

    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException("Out of Bound");
        this.trials = trials;
        this.x = new double[trials];
        int count = 0;
        while (count < trials) {
            Percolation prs = new Percolation(n);
            while (!prs.percolates()) {
                int row = StdRandom.uniform(1, n + 1);
                int col = StdRandom.uniform(1, n + 1);
                prs.open(row, col);
            }
            x[count] = prs.numberOfOpenSites() / (double) (n * n);
            count++;
        }

    }


    public double mean() {
        mean = StdStats.mean(x);
        return mean;
    }

    public double stddev() {
        stddev = StdStats.stddev(x);
        return stddev;
    }

    public double confidenceLo() {
        return mean - ((CONFIDENCE_95 * stddev) / Math.sqrt(trials));
    }

    public double confidenceHi() {
        return mean + ((CONFIDENCE_95 * stddev) / Math.sqrt(trials));
    }

    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        System.out.println(x + " " + t);
        PercolationStats ps = new PercolationStats(x, t);
        System.out.println("mean                    = " + ps.mean());
        System.out.println("stddev                  = " + ps.stddev());
        System.out.println(
                "95% confidence interval = " + "[" + ps.confidenceLo() + "," + ps.confidenceHi()
                        + "]");

    }

}

package hw2;

import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {
    /**
     * Ratio.
     */
    private static final double RATIO = 1.96;

    /**
     * T represent computional experiment times.
     */
    private int T;

    /**
     * Percolation factory.
     */
    private PercolationFactory percolationFactory;

    /**
     * N represent num of grid.
     */
    private int N;

    /**
     * Fraction of opened sites.
     */
    private double[] x;

    /**
     * Perform T independent experiments on an N-by-N grid.
     * @param N
     * @param T
     * @param pf
     */
    public PercolationStats(int N, int T, PercolationFactory pf) {
        percolationFactory = pf;
        this.N = N;
        this.T = T;
        this.x = new double[T];
        // calculate
        compute();
    }

    /**
     * Compute fraction of opened sites in grid.
     */
    private void compute() {
        for (int i = 0; i < T; i++) {
            Percolation percolation = percolationFactory.make(N);
            while (!percolation.percolates()) {
                int row = StdRandom.uniform(N);
                int col = StdRandom.uniform(N);
                percolation.open(row, col);
            }
            x[i] = (double) percolation.numberOfOpenSites() / (N * N);
        }
    }

    /**
     * Sample mean of percolation threshold.
     * @return
     */
    public double mean() {
        double total = 0;
        for (double i : x) {
            total += i;
        }
        return total / T;
    }

    /**
     * Sample standard deviation of percolation threshold.
     * @return
     */
    public double stddev() {
        return StdStats.stddev(x);
    }

    /**
     * Low endpoint of 95% confidence interval.
     * @return
     */
    public double confidenceLow() {
        return mean() - RATIO * stddev() / Math.sqrt(T);
    }

    /**
     * High endpoint of 95% confidence interval.
     * @return
     */
    public double confidenceHigh() {
        return mean() + RATIO * stddev() / Math.sqrt(T);
    }

    /**
     * Main.
     * @param args
     */
    public static void main(String[] args) {
    }

}

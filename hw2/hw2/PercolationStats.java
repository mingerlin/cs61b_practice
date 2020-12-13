package hw2;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] fractions;
    private int intT;
    /* perform T independent experiments on an N-by-N grid */
    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N<=0 || T>=0) {
            throw new IllegalArgumentException("N or T cannot be smaller or equals to 0");
        }
        fractions = new double[T];
        intT = T;
        for (int i=0; i < T; i+=1) {
            Percolation sites = pf.make(N);
            while (!sites.percolates()) {
                int row = StdRandom.uniform(N);
                int col = StdRandom.uniform(N);
                sites.open(row, col);
            }
            int numOpenSites = sites.numberOfOpenSites();
            fractions[i] = (double) numOpenSites/(N*N);
        }
    }

    /* sample mean of percolation threshold */
    public double mean() {
        double all = 0.0;
        for (int i=0; i<intT; i++) {
            all += fractions[i];
        }
        return all/intT;
    }

    /* sample standard deviation of percolation threshold */
    public double stddev() {
        return StdStats.stddev(fractions);
    }

    /* low endpoint of 95% confidence interval */
    public double confidenceLow() {
        return mean()-(1.96*stddev()/Math.sqrt(intT));
    }

    /* high endpoint of 95% confidence interval */
    public double confidenceHigh() {
        return mean()+(1.96*stddev()/Math.sqrt(intT));
    }

//    public static void main(String[] args) {
//
//    }
}

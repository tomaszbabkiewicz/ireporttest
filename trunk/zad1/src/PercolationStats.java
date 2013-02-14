public class PercolationStats {    
    private double[] openedSitesCounts;
    
    // perform T independent computational experiments on an N-by-N grid
    public PercolationStats(int N, int T) {
        if ((N <= 0)  || (T <= 0)) throw new IllegalArgumentException();
        
        double allSiteCount = N * N;
        openedSitesCounts = new double[T];
        for (int i = 0; i < T; i++) {
            Percolation pre = new Percolation(N);
            int count = 0;
            while (!pre.percolates()) {
                int p = StdRandom.uniform(1, N+1);
                int q = StdRandom.uniform(1, N+1);
                if (!pre.isOpen(p, q)) {
                    pre.open(p, q);
                    count++;
                }
            }
            openedSitesCounts[i] = count / allSiteCount;
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(openedSitesCounts);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(openedSitesCounts);
    }

    // returns lower bound of the 95% confidence interval
    public double confidenceLo() {
        return mean() - (1.96 * stddev()) / Math.sqrt(openedSitesCounts.length);
    }

    // returns upper bound of the 95% confidence interval
    public double confidenceHi() {
        return mean() + (1.96 * stddev()) / Math.sqrt(openedSitesCounts.length);
    }

    // test client, described below
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        PercolationStats pStat = new PercolationStats(N, T);
        StdOut.println("mean                    = " + pStat.mean());
        StdOut.println("stddev                  = " + pStat.stddev());
        StdOut.println("95% confidence interval = " 
                + pStat.confidenceLo() + "," + pStat.confidenceHi());
    }
}
public class PercolationStats {
    
    private int[] openedSitesCount;
    
    // perform T independent computational experiments on an N-by-N grid
    public PercolationStats(int N, int T) {
        if ((N <= 0)  || (T <= 0))
            throw new IllegalArgumentException();
        
        openedSitesCount = new int[T];
        for (int i = 0; i < T; i++){
            Percolation pre = new Percolation(N);
            int count = 0;
            while (!pre.percolates()) {
                int p = StdRandom.uniform(1, N+1);
                int q = StdRandom.uniform(1, N+1);
                if (!pre.isOpen(p, q)){
                    pre.open(p, p);
                    count++;
                }
            }
            openedSitesCount[i] = count;
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(openedSitesCount);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return 0.0;
    }

    // returns lower bound of the 95% confidence interval
    public double confidenceLo() {
        return 0.0;
    }

    // returns upper bound of the 95% confidence interval
    public double confidenceHi() {
        return 0.0;
    }

    // test client, described below
    public static void main(String[] args) {
        PercolationStats pStat = new PercolationStats(10, 2);
        StdOut.println(pStat.mean());
    }
}
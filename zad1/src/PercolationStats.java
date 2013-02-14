public class PercolationStats {
    
    private Percolation percolation;
    
    // perform T independent computational experiments on an N-by-N grid
    public PercolationStats(int N, int T) {
        if ((N <= 0)  || (T <= 0))
            throw new IllegalArgumentException();
        
        percolation = new Percolation(N);
        for (int i = 0; i < T; i++){
            
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return 0.0;
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
    }
}
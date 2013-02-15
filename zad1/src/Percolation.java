public class Percolation {

    private WeightedQuickUnionUF union;
    private WeightedQuickUnionUF union2;
    private int gridSize;
    private int arraySize;
    private boolean[] openedSite;

    // create N-by-N grid, with all sites blocked
    public Percolation(int N) {
        arraySize = N * N + 2;
        union = new WeightedQuickUnionUF(arraySize);
        union2 = new WeightedQuickUnionUF(arraySize);
        gridSize = N;
        openedSite = new boolean[arraySize];
        openedSite[0] = true;
        openedSite[arraySize - 1] = true;
    }

    // open site (row i, column j) if it is not already
    public void open(int i, int j) {
        validateIndexe(i, j);
        
        openedSite[xyTo1D(i, j)] = true;

        if (i == 1) {
            union.union(0, xyTo1D(i, j));
            union2.union(0, xyTo1D(i, j));
        }
        if (i == gridSize)
            union.union(arraySize - 1, xyTo1D(i, j));

        if ((i > 1) && isOpen(i - 1, j)) {
            union.union(xyTo1D(i - 1, j), xyTo1D(i, j));
            union2.union(xyTo1D(i - 1, j), xyTo1D(i, j));
        }
        if ((i < gridSize) && isOpen(i + 1, j)) {
            union.union(xyTo1D(i + 1, j), xyTo1D(i, j));
            union2.union(xyTo1D(i + 1, j), xyTo1D(i, j));
        }
        if ((j > 1) && isOpen(i, j - 1)) {
            union.union(xyTo1D(i, j - 1), xyTo1D(i, j));
            union2.union(xyTo1D(i, j - 1), xyTo1D(i, j));
        }
        if ((j < gridSize) && isOpen(i, j + 1)) {
            union.union(xyTo1D(i, j + 1), xyTo1D(i, j));
            union2.union(xyTo1D(i, j + 1), xyTo1D(i, j));
        }
    }

    // is site (row i, column j) open?
    public boolean isOpen(int i, int j) {
        validateIndexe(i, j);
        return openedSite[xyTo1D(i, j)];
    }

    // is site (row i, column j) full?
    public boolean isFull(int i, int j) {
        validateIndexe(i, j);
        return isOpen(i, j) && union2.connected(0, xyTo1D(i, j));
    }

    // does the system percolate?
    public boolean percolates() {
        return union.connected(0, arraySize - 1);
    }

    private int xyTo1D(int i, int j) {
        return (i - 1) * gridSize + j;
    }

    private void validateIndexe(int i, int j) {
        if ((i <= 0) || (i > gridSize) || (j <= 0) || (j > gridSize))
            throw new IndexOutOfBoundsException("row index i out of bounds");
    }
}
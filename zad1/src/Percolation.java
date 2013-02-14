public class Percolation {

    private WeightedQuickUnionUF union;
    private int gridSize;
    private int arraySize;
    private int[] openedSite;

    // create N-by-N grid, with all sites blocked
    public Percolation(int N) {
        arraySize = N * N + 2;
        union = new WeightedQuickUnionUF(arraySize);
        gridSize = N;
        openedSite = new int[arraySize];
        for (int i = 0; i < openedSite.length; i++) {
            openedSite[i] = 0;
        }
        openedSite[0] = 1;
        openedSite[arraySize - 1] = 1;
    }

    // open site (row i, column j) if it is not already
    public void open(int i, int j) {
        validateIndexe(i);
        validateIndexe(j);
        
        openedSite[xyTo1D(i, j)] = 1;

        if (i == 1)
            union.union(0, xyTo1D(i, j));
        if (i == gridSize)
            union.union(arraySize - 1, xyTo1D(i, j));

        if ((i > 1) && isOpen(i - 1, j))
            union.union(xyTo1D(i - 1, j), xyTo1D(i, j));
        if ((i < gridSize) && isOpen(i + 1, j))
            union.union(xyTo1D(i + 1, j), xyTo1D(i, j));
        if ((j > 1) && isOpen(i, j - 1))
            union.union(xyTo1D(i, j - 1), xyTo1D(i, j));
        if ((j < gridSize) && isOpen(i, j + 1))
            union.union(xyTo1D(i, j + 1), xyTo1D(i, j));
    }

    // is site (row i, column j) open?
    public boolean isOpen(int i, int j) {
        validateIndexe(i);
        validateIndexe(j);
        return openedSite[xyTo1D(i, j)] == 1;
    }

    // is site (row i, column j) full?
    public boolean isFull(int i, int j) {
        validateIndexe(i);
        validateIndexe(j);
        return isOpen(i, j) && union.connected(0, xyTo1D(i, j));
    }

    // does the system percolate?
    public boolean percolates() {
        return union.connected(0, arraySize - 1);
    }

    private int xyTo1D(int i, int j) {
        return (i - 1) * gridSize + j;
    }

    private void validateIndexe(int i) {
        if (i <= 0 || i > gridSize)
            throw new IndexOutOfBoundsException("row index i out of bounds");
    }
}
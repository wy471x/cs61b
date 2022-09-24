package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    /**
     * N-by-N grids.
     */
    private int[][] grids;

    /**
     * Union-Find.
     */
    private WeightedQuickUnionUF unionUF;

    /**
     * Row num.
     */
    private int r;

    /**
     * Col num.
     */
    private int c;

    /**
     * Create N-by-N grid, with all sites initially blocked.
     * @param N
     */
    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("illegal argument.");
        }
        grids = new int[N][N];
        r = N;
        c = N;
        unionUF = new WeightedQuickUnionUF(N * N);
    }

    /**
     * Open the site (row, col) if it is not open already.
     * @param row
     * @param col
     */
    public void open(int row, int col) {
        if (row >= this.r || col >= this.c) {
            throw new IndexOutOfBoundsException("out of index.");
        }

        if (grids[row][col] == 1) {
            return;
        }

        grids[row][col] = 1;
        // down
        if (row + 1 < this.r && isOpen(row + 1, col)) {
            unionUF.union(xyTo1D(row, col), xyTo1D(row + 1, col));
        }
        // up
        if (row - 1 > -1 && isOpen(row - 1, col)) {
            unionUF.union(xyTo1D(row, col), xyTo1D(row - 1, col));
        }
        // right
        if (col + 1 < this.c && isOpen(row, col + 1)) {
            unionUF.union(xyTo1D(row, col), xyTo1D(row, col + 1));
        }
        // left
        if (col - 1 >  -1 && isOpen(row, col - 1)) {
            unionUF.union(xyTo1D(row, col), xyTo1D(row, col - 1));
        }
    }

    /**
     * Is the site (row, col) open?
     * @param row
     * @param col
     * @return
     */
    public boolean isOpen(int row, int col) {
        if (row >= this.r || col >= this.c) {
            throw new IndexOutOfBoundsException("out of index.");
        }
        return grids[row][col] == 1;
    }

    /**
     * Is the site (row, col) full?
     * @param row
     * @param col
     * @return
     */
    public boolean isFull(int row, int col) {
        if (row >= this.r || col >= this.c) {
            throw new IndexOutOfBoundsException("out of index.");
        }

        for (int i = 0; i < this.c; i++) {
            if (unionUF.connected(xyTo1D(0, i), xyTo1D(row, col))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Number of open sites.
     * @return
     */
    public int numberOfOpenSites() {
        int num = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grids[i][j] == 1) {
                    num++;
                }
            }
        }
        return num;
    }

    /**
     * Row and col map to one dimension.
     * @param x
     * @param y
     * @return
     */
    private int xyTo1D(int x, int y) {
        return x * r + y;
    }

    /**
     * Does the system percolate?
     * @return
     */
    public boolean percolates() {
        boolean percolateFlag = false;
        for (int i = 0; i < c; i++) {
            if (isFull(r - 1, i)) {
                percolateFlag = true;
            }
        }
        return percolateFlag;
    }

    /**
     * Main.
     * @param args
     */
    public static void main(String[] args) {
    }
}

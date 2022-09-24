package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import org.junit.Assert;

/**
 * @source https://github.com/oak2278/percolation/blob/master/Percolation.java
 */
public class Percolation {
    private boolean[][] grid;
    private WeightedQuickUnionUF wqfGrid;
    private WeightedQuickUnionUF wqfFull;
    private int gridSize;
    private int gridSquared;
    private int virtualTop;
    private int virtualBottom;
    private int openSites;

    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("N must be > 0");
        }
        gridSize = n;
        gridSquared = n * n;
        grid = new boolean[gridSize][gridSize];
        wqfGrid = new WeightedQuickUnionUF(gridSquared + 2); // includes virtual top bottom
        wqfFull = new WeightedQuickUnionUF(gridSquared + 1); // includes virtual top
        virtualBottom = gridSquared + 1;
        virtualTop = gridSquared;
        openSites = 0;
    }

    /**
     * Open the site (row, col) if it is not open already.
     * @param row
     * @param col
     */
    public void open(int row, int col) {
        validateSite(row, col);

        int shiftRow = row;
        int shiftCol = col;
        int flatIndex = flattenGrid(row, col);

        // If already open, stop
        if (isOpen(row, col)) {
            return;
        }

        // Open Site
        grid[shiftRow][shiftCol] = true;
        openSites++;

        // Top Row
        if (row == 0) {
            wqfGrid.union(virtualTop, flatIndex);
            wqfFull.union(virtualTop, flatIndex);
        }

        // Bottom Row
        if (row == gridSize - 1) {
            wqfGrid.union(virtualBottom, flatIndex);
        }

        // Check and Open Left
        if (isOnGrid(row, col - 1) && isOpen(row, col - 1)) {
            wqfGrid.union(flatIndex, flattenGrid(row, col - 1));
            wqfFull.union(flatIndex, flattenGrid(row, col - 1));
        }

        // Check and Open Right
        if (isOnGrid(row, col + 1) && isOpen(row, col + 1)) {
            wqfGrid.union(flatIndex, flattenGrid(row, col + 1));
            wqfFull.union(flatIndex, flattenGrid(row, col + 1));
        }

        // Check and Open Up
        if (isOnGrid(row - 1, col) && isOpen(row - 1, col)) {
            wqfGrid.union(flatIndex, flattenGrid(row - 1, col));
            wqfFull.union(flatIndex, flattenGrid(row - 1, col));
        }

        // Check and Open Down
        if (isOnGrid(row + 1, col) && isOpen(row + 1, col)) {
            wqfGrid.union(flatIndex, flattenGrid(row + 1, col));
            wqfFull.union(flatIndex, flattenGrid(row + 1, col));
        }
    }

    /**
     * Is the site (row, col) open?
     * @param row
     * @param col
     * @return
     */
    public boolean isOpen(int row, int col) {
        validateSite(row, col);
        return grid[row][col];
    }

    /**
     * Is the site (row, col) full?
     * @param row
     * @param col
     * @return
     */
    public boolean isFull(int row, int col) {
        validateSite(row, col);
        return wqfFull.connected(virtualTop, flattenGrid(row, col));
    }

    /**
     * Number of open sites.
     * @return
     */
    public int numberOfOpenSites() {
        return openSites;
    }

    /**
     * Does the system percolate?
     * @return
     */
    public boolean percolates() {
        return wqfGrid.connected(virtualTop, virtualBottom);
    }

    /**
     *Transfer location to one dimension.
     * @param row
     * @param col
     * @return
     */
    private int flattenGrid(int row, int col) {
        return gridSize * row + col;
    }

    /**
     * Check position if it is correct.
     * @param row
     * @param col
     */
    private void validateSite(int row, int col) {
        if (!isOnGrid(row, col)) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
    }

    /**
     * Check position if it is in grids.
     * @param row
     * @param col
     * @return
     */
    private boolean isOnGrid(int row, int col) {
        int shiftRow = row;
        int shiftCol = col;
        return (shiftRow >= 0 && shiftCol >= 0 && shiftRow < gridSize && shiftCol < gridSize);
    }

    /**
     * Main.
     * @param args
     */
    public static void main(String[] args) {
        Percolation percolation = new Percolation(1);
        Assert.assertFalse(percolation.percolates());
        percolation.open(0, 0);
        Assert.assertTrue(percolation.percolates());

        Percolation percolation2 = new Percolation(5);
        Assert.assertFalse(percolation2.percolates());
        percolation2.open(0, 0);
        Assert.assertFalse(percolation2.percolates());
        percolation2.open(0, 1);
        percolation2.open(0, 3);
        percolation2.open(0, 4);
        percolation2.open(0, 2);
        percolation2.open(4, 4);
        percolation2.open(4, 0);
        Assert.assertFalse(percolation2.percolates());

        Percolation percolation3 = new Percolation(3);
        Assert.assertFalse(percolation3.percolates());
        Assert.assertEquals(0, percolation3.numberOfOpenSites());
        percolation3.open(2, 0);
        percolation3.open(2, 2);
        Assert.assertEquals(2, percolation3.numberOfOpenSites());
        Assert.assertFalse(percolation3.isFull(0, 0));
    }
}

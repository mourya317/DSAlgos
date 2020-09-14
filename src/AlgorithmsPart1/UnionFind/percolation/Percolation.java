package AlgorithmsPart1.UnionFind.percolation;/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private static final boolean BLOCKED = false;
    private static final boolean OPEN = true;
    private final int n;
    private int noOfOpenedSites;
    private final boolean[][] grid;
    private final WeightedQuickUnionUF weightedQuickUnionUF;

    /* private class Grid {
        int n;
        State state;

        public Grid(int n, State state) {
            this.n = n;
            this.state = state;
        }
    }*/

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.noOfOpenedSites = 0;
        this.weightedQuickUnionUF = new WeightedQuickUnionUF((n * n) + 2);
        this.n = n;
        this.grid = new boolean[n][n];

       /* //Create 2 virtual sites and call connected between them
        int vs1 = n * n;
        int vs2 = n * n + 1;
        //connect Top , bottom sites
        for (int c = 0; c < n; c++) {
            weightedQuickUnionUF.union(vs1, c);
            weightedQuickUnionUF.union(vs2, ((n - 1) * n) + c);
        }*/

    }

    private boolean validate(int r, int c) {
        return (r > -1 && r < n) && (c > -1 && c < n);
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (!isOpen(row, col)) {
            row--;
            col--;

            grid[row][col] = OPEN;
            if (row == 0) {
                weightedQuickUnionUF.union(n * n, twoDtoOneDIndex(row, col));
            }
            if (row == n - 1) {
                weightedQuickUnionUF.union(n * n + 1, twoDtoOneDIndex(row, col));
            }

            ++noOfOpenedSites;
            // 1
            if (validate(row + 1, col)) {
                if (grid[row + 1][col] == OPEN) {
                    // Open site
                    weightedQuickUnionUF
                            .union(twoDtoOneDIndex(row, col), twoDtoOneDIndex(row + 1, col));
                }
            }
            // 2
            if (validate(row - 1, col)) {
                if (grid[row - 1][col] == OPEN) {
                    // Open site
                    weightedQuickUnionUF
                            .union(twoDtoOneDIndex(row, col), twoDtoOneDIndex(row - 1, col));
                }
            }
            // 3
            if (validate(row, col - 1)) {
                if (grid[row][col - 1] == OPEN) {
                    weightedQuickUnionUF
                            .union(twoDtoOneDIndex(row, col), twoDtoOneDIndex(row, col - 1));
                }
            }
            // 4
            if (validate(row, col + 1)) {
                if (grid[row][col + 1] == OPEN) {
                    weightedQuickUnionUF
                            .union(twoDtoOneDIndex(row, col), twoDtoOneDIndex(row, col + 1));
                }
            }
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (!validate(row - 1, col - 1)) {
            throw new IllegalArgumentException();
        }
        return grid[row - 1][col - 1] != BLOCKED;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (!validate(row - 1, col - 1)) {
            throw new IllegalArgumentException();
        }
        // When this element connected to any virtual site 0
        return weightedQuickUnionUF.find(n * n) == weightedQuickUnionUF
                .find(twoDtoOneDIndex(row - 1, col - 1));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return noOfOpenedSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return weightedQuickUnionUF.find(n * n) == weightedQuickUnionUF.find(n * n + 1);
    }

    private int twoDtoOneDIndex(int x, int y) {
        if (!validate(x, y)) {
            throw new IllegalArgumentException();
        }
        return x * n + y;
    }

}

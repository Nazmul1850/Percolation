/* *****************************************************************************
 *  Name:    Nazmul Hasan
 *  NetID:   1234
 *  Precept: P00
 *
 *  Description:  this is a percolation class
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
    private final WeightedQuickUnionUF uf;
    private final int n;
    private int openSites;
    private int[][] grid;
    private boolean[][] openCheck;

    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException("Value must be positive");
        this.n = n;
        this.openSites = 0;
        this.grid = new int[n][n];
        this.openCheck = new boolean[n][n];
        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = count;
                openCheck[i][j] = false;
                count++;

            }
        }
        this.uf = new WeightedQuickUnionUF((n * n) + 1);
        for (int i = 1; i <= n; i++) {
            if (n == 1) break;
            uf.union(0, i);

        }
    }


    public boolean isFull(int row, int col) {
        row -= 1;
        col -= 1;
        if (row < 0 || row >= n || col < 0 || col >= n) {
            throw new IllegalArgumentException("Out Of Bounds");
        }
        return openCheck[row][col] && (uf.find(0) == uf.find(grid[row][col]));
    }

    public boolean isOpen(int row, int col) {
        row -= 1;
        col -= 1;
        if (row < 0 || row >= n || col < 0 || col >= n) {
            throw new IllegalArgumentException("Out Of Bounds");
        }
        return openCheck[row][col];
    }

    public int numberOfOpenSites() {
        return openSites;
    }

    public boolean percolates() {
        for (int i = (n * n); i > (n * n) - n; i--) {
            if (uf.find(0) == uf.find(i)) return true;
        }
        return false;

    }

    public void open(int row, int col) {
        row -= 1;
        col -= 1;
        if (row < 0 || row >= n || col < 0 || col >= n) {
            throw new IllegalArgumentException("Out Of Bounds");
        }
        else {
            if (n == 1) uf.union(0, 1);
            if (!openCheck[row][col]) {
                openCheck[row][col] = true;
                openSites++;
            }

            int x = grid[row][col];

            if (row - 1 >= 0) {
                if (openCheck[row - 1][col]) uf.union(x, grid[row - 1][col]);
            }
            if (row + 1 < n) {
                if (openCheck[row + 1][col]) uf.union(x, grid[row + 1][col]);
            }
            if (col - 1 >= 0) {
                if (openCheck[row][col - 1]) uf.union(x, grid[row][col - 1]);
            }
            if (col + 1 < n) {
                if (openCheck[row][col + 1]) uf.union(x, grid[row][col + 1]);
            }
        }
    }

    public static void main(String[] args) {
        //For checking the class

    }


}

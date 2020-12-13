package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import java.lang.IllegalArgumentException;
import java.util.List;

public class Percolation {
    private boolean[][] grid;
    private int numOpen, topSite, bottomSite;
    private final int intN;
    private WeightedQuickUnionUF grid1D;

    /* create N-by-N grid, with all sites initially blocked */
    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("N cannot be equal or less than 0");
        }
        grid = new boolean[N][N];
        intN = N;
        numOpen = 0;
        grid1D = new WeightedQuickUnionUF(N*N+2);
        topSite = N*N;
        bottomSite = N*N+1;
    }

    /* private method to check if given row and col is out-of-bound */
    private void checkBoundary(int row, int col) {
        if (row < 0 || row >= intN) {
            throw new IllegalArgumentException("row index is out of bound");
        } else if (col < 0 || col >= intN) {
            throw new IllegalArgumentException("col index is out of bound");
        }
    }

    /* convert row col to an integer */
    private int xyTo1D(int row, int col) {
        return row*intN+col;
    }

    /* connect to the left neighbors */
    private void connectLeft(int row, int col, int pos1D) {
        // do nothing if is the leftmost column or its left neighbor not open
        if (col==0 || !isOpen(row,col-1)) {
            return;
        }
        grid1D.union(pos1D, pos1D - 1);
    }

    /* connect to the right neighbors */
    private void connectRight(int row, int col, int pos1D) {
        // do nothing if is the rightmost column or its right neighbor not open
        if (col==(intN-1) || !isOpen(row,col+1)) {
            return;
        }
        grid1D.union(pos1D, pos1D + 1);
    }

    /* connect to the top neighbors */
    private void connectTop(int row, int col, int pos1D) {
        // do nothing if is the topmost column or its top neighbor not open
        if (row==0) {
            grid1D.union(pos1D, topSite);
            return;
        } else if (!isOpen(row-1,col)) {
            return;
        }
        grid1D.union(pos1D, pos1D - 5);
    }

    /* connect to the bottom neighbors */
    private void connectBottom(int row, int col, int pos1D) {
        // do nothing if is the bottommost column or its bottom neighbor not open
        if (row==(intN-1)) {
            grid1D.union(pos1D, bottomSite);
            return;
        } else if (!isOpen(row+1,col)) {
            return;
        }
        grid1D.union(pos1D, pos1D + 5);
    }

    /* open the site (row, col) if it is not open already */
    public void open(int row, int col) {
        checkBoundary(row, col);
        if (isOpen(row, col)) {
            return;
        }
        grid[row][col] = true;
        int pos1D = xyTo1D(row, col);
        numOpen += 1;
        connectLeft(row, col, pos1D);
        connectRight(row, col, pos1D);
        connectTop(row, col, pos1D);
        connectBottom(row, col, pos1D);
    }

    /* is the site (row, col) open? */
    public boolean isOpen(int row, int col) {
        checkBoundary(row, col);
        return grid[row][col];
    }

    /* is the site (row, col) full? */
    public boolean isFull(int row, int col) {
        checkBoundary(row, col);
        int pos1D = xyTo1D(row, col);
        if (row==0) {
            return grid1D.connected(pos1D, topSite);
        } else {
            return grid1D.connected(pos1D, topSite) && isOpen(row-1,col);
        }
    }

    /* number of open sites */
    public int numberOfOpenSites() {
        return numOpen;
    }

    /* does the system percolate? */
    public boolean percolates() {
        return grid1D.connected(topSite, bottomSite);
    }

    public static void main(String[] args) {
        // test xyTo1D()
        Percolation p1 = new Percolation(5);
//        System.out.println(p1.xyTo1D(3,4)); // 19
//        System.out.println(p1.xyTo1D(2,4)); // 14
//        System.out.println(p1.xyTo1D(4,1)); // 21
//        System.out.println(p1.xyTo1D(0,0)); // 0

        // test1 --> pass
//        p1.open(3,4);
//        p1.open(2,4);
//        p1.open(2,2);
//        p1.open(2,3);
//        p1.open(0,2);
//        p1.open(1,2);
//        System.out.println("This should be true: "+p1.isFull(2,2));

        // test2 --> pass
//        p1.open(0,2);
//        p1.open(1,2);
//        p1.open(2,2);
//        p1.open(3,2);
//        p1.open(4,2);
//        p1.open(4,4);
//        p1.open(3,4);
//        p1.open(2,4);
//        System.out.println("This should be false: "+p1.isFull(2,4));

        // test3
        p1.open(3,4);
        p1.open(2,4);
        p1.open(2,2);
        p1.open(2,3);
        p1.open(0,2);
        p1.open(1,2);
        System.out.println("This should be true: "+p1.isFull(2,2));

        p1.open(1,1);
        p1.open(1,0);
        p1.open(0,0);
        System.out.println("This should be true: "+p1.isFull(1,0));
    }

}

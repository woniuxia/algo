package cn.weihuachao.leetcode;

import java.util.LinkedList;

/**
 * RottingOranges
 */
public class RottingOranges {

    class Data {
        int x;
        int y;
        int count;

        Data(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public int orangesRotting(int[][] grid) {
        if (null == grid) {
            return -1;
        }
        int[] xx = new int[] { 0, 0, 1, -1 };
        int[] yy = new int[] { 1, -1, 0, 0 };
        LinkedList<Data> queue = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Data(i, j, 0));
                }
            }
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            Data data = queue.pop();
            ans = Math.max(ans, data.count);
            for (int i = 0; i < 4; i++) {
                int tmpX = data.x + xx[i];
                int tmpY = data.y + yy[i];
                if (isValid(tmpX, tmpY, row, col)) {
                    if (grid[tmpX][tmpY] == 1) {
                        grid[tmpX][tmpY] = 2;
                        queue.add(new Data(tmpX, tmpY, data.count + 1));
                    }
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }

    public boolean isValid(int x, int y, int row, int col) {
        return x >= 0 && y >= 0 && x < row && y < col;
    }

    public static void main(String[] args) {

    }
}
package com.yyf.lc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yifei yang
 */
public class HappyMines {

    public static void main(String[] args) {
        int x = 3;
        int y = 2;
        boolean[][] field = {{true,false,true,true,false},{true,false,false,false,false},{false,false,false,false,false},{true,false,false,false,false}};
        int[][] arr = new HappyMines().solution(field, x, y);
        for (int i = 0; i < 4; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

    }
    int[][] solution(boolean[][] field, int x, int y) {
        int m = field.length;
        int n = field[0].length;
        int[][] res = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = -1;
            }
        }
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        res[x][y] = 0;
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Point curr = queue.poll();
                int[] offsetX = {1, 0, -1, 1, -1, -1, 0, -1};
                int[] offsetY = {-1, -1, -1, 0, 0, 1, 1, 1};
                for (int i = 0; i < 8; i++) {
                    int xx = curr.x + offsetX[i];
                    int yy = curr.y + offsetY[i];

                    if (!isValid(xx, yy, field)) {
                        continue;
                    }
                    int num = getMines(xx, yy, field);
                    res[xx][yy] = num;
                    if (num == 0 && !visited[xx][yy]) {
                        visited[xx][yy] = true;
                        queue.offer(new Point(xx, yy));
                    }
                }
            }

        }
        return res;

    }



    public boolean isValid(int x, int y, boolean[][] field) {
        int m = field.length;
        int n = field[0].length;
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public int getMines(int x, int y, boolean[][] field) {
        int count = 0;
        int[] offsetX = {-1,-1,-1,0,0,1,1,1};
        int[] offsetY = {1,0,-1,1,-1,-1,0,1};
        for (int i = 0; i < 8; i++) {
            int xx = x + offsetX[i];
            int yy = y + offsetY[i];
            if (isValid(xx, yy, field) && field[xx][yy]) {
                count++;
            }
        }
        return count;
    }
}

class Point {
    int x;
    int y;
    public Point(int x,  int y) {
        this.x = x;
        this.y = y;
    }
}


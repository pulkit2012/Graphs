package Algos;

import java.util.LinkedList;
import java.util.Queue;

public class StepsByKnight {
    static class Cell {
        int x;
        int y;
        int dist;

        public Cell(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static boolean lieInChess(int x, int y, int N) {
        if (x >= 1 && x <= N && y >= 1 && y <= N) {
            return true;
        }
        return false;
    }
    //Time :- O(n^2)
    static int minimumStepsByKnight(int[] knightPos, int[] targetPos, int N) {
        boolean[][] chess = new boolean[N + 1][N + 1];
        int[] x_direc = {1, -1, 2, 2, -2, -2, 1, -1};
        int[] y_direc = {2, 2, 1, -1, 1, -1, -2, -2};
        for (int i = 1; i <= N; i++) {
            for (int i1 = 1; i1 <= N; i1++) {
                chess[i][i1] = false;
            }
        }
        chess[knightPos[0]][knightPos[1]] = true;
        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(knightPos[0], knightPos[1], 0));
        Cell cell;
        int x;
        int y;
        while (!queue.isEmpty()) {
            cell = queue.poll();
            if (cell.x == targetPos[0] && cell.y == targetPos[1]) {
                return cell.dist;
            }
            for (int i = 0; i < 8; i++) {
                x = cell.x + x_direc[i];
                y = cell.y + y_direc[i];
                if (lieInChess(x, y, N) && !chess[x][y]) {
                    chess[x][y] = true;
                    queue.add(new Cell(x, y, cell.dist + 1));
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {

        int n = 6;
        int[] knightPos = {4, 5};
        int[] targetPos = {1, 1};
        System.out.println(minimumStepsByKnight(knightPos, targetPos, n));
    }
}

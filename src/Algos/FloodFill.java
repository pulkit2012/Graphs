package Algos;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class FloodFill {

    static int[][] makeNewColor(int x,int y, int newColor, int[][] matrix){
        int color = matrix[x][y];
        if(color != newColor){
            floodFill(color,matrix,x,y,newColor);
        }
        return matrix;
    }
    static void floodFill(int color,int[][] matrix, int x_start, int y_start, int newColor) {
        if(matrix[x_start][y_start] == color){
            matrix[x_start][y_start] = newColor;
            if(x_start >= 1){
                floodFill(color, matrix, x_start-1, y_start, newColor);
            }
            if(y_start >= 1){
                floodFill(color, matrix, x_start, y_start-1, newColor);
            }
            if(x_start + 1 < matrix.length){
                floodFill(color, matrix, x_start+1, y_start, newColor);
            }
            if(y_start + 1 < matrix[0].length){
                floodFill(color, matrix, x_start, y_start+1, newColor);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,1,0},{1,0,1}};
        makeNewColor(1,1,2,matrix);
        System.out.println(Arrays.deepToString(matrix));

    }
}

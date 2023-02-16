package main.java.com.demo.algo.matrix;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MatrixUtils {
    // https://leetcode.cn/problems/flood-fill
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] traversedLocation = new int[image.length][image[0].length];
        floodFill(image, sr, sc, image[sr][sc], color, traversedLocation);
        return image;
    }

    private static void floodFill(int[][] image, int x, int y, int originalColor, int newColor, int[][] traversedLocation) {
        if(y < 0 || y >= image[0].length) {
            return;
        }

        if(x < 0 || x >= image.length) {
            return;
        }

        if(traversedLocation[x][y] == 1) {
            return;
        }
        if(image[x][y] == originalColor) {
            traversedLocation[x][y] = 1;
            image[x][y] = newColor;
            floodFill(image, x, y - 1, originalColor, newColor, traversedLocation);
            floodFill(image, x, y + 1, originalColor, newColor, traversedLocation);
            floodFill(image, x - 1, y, originalColor, newColor, traversedLocation);
            floodFill(image, x + 1, y, originalColor, newColor, traversedLocation);
        }
    }
}

package test.java.com.demo.algo;

import lombok.extern.slf4j.Slf4j;
import main.java.com.demo.algo.matrix.MatrixUtils;

import org.junit.Test;

@Slf4j
public class MatrixTest {
    @Test
    public void testFloodFill() {
        int[][] image = new int[][] {{0,0,0}, {0,0,0}};
        int[][] res = MatrixUtils.floodFill(image, 0, 0, 2);
        log.info("Result: {}.", res);
    }
}

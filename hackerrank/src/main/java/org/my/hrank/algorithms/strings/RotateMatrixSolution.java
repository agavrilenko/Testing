package org.my.hrank.algorithms.strings;

public class RotateMatrixSolution {
    public int[][] rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i <= (len - 1) / 2; i++) {
            for (int j = i; j < len - i - 1; j++) {
                rotateFour(len, i, j, matrix);
            }
        }
        return matrix;
    }

    private void rotateFour(int len, int i, int j, int[][] matrix) {
        int tmp, tmp1, tmp2, tmp3;
        tmp = matrix[i][j];
        tmp1 = matrix[j][len - i - 1];
        tmp2 = matrix[len - i - 1][len - 1 - j];
        tmp3 = matrix[len - 1 - j][i];
        matrix[i][j] = tmp3;
        matrix[j][len - i - 1] = tmp;
        matrix[len - i - 1][len - 1 - j] = tmp1;
        matrix[len - 1 - j][i] = tmp2;
    }
}

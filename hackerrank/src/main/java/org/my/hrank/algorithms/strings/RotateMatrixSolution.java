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
        int l = len - 2 * i;//  length of square
        if (l == 1) {
            return;
        }
        int delta = 0;
        if(l==2){
            delta = 1;
        }
        tmp = matrix[i][j];
        tmp1 = matrix[j + i - delta][i + l - 1];
        tmp2 = matrix[i + l - 1][i + l - 1 - j + delta];
        tmp3 = matrix[i + l - 1 - j + delta][i];
        matrix[i][j] = tmp3;
        matrix[j + i - delta][i + l - 1] = tmp;
        matrix[i + l - 1][i + l - 1 - j + delta] = tmp1;
        matrix[i + l - 1 - j + delta][i] = tmp2;
    }
}

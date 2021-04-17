package com.ningmeng.base.dp;


import java.util.Arrays;

/**
 * -------------------------
 *  | X |  |  |  |  |  |  |  |
 * --------------------------
 *  |  |  |  |  |  |  |  |  |
 * -------------------------
 *  |  |  |  |  |  |  |  |  |
 * --------------------------
 *  |  |  |  |  |  |  |  | Y |
 * --------------------------
 *
 * 机器人在X点出发,一步只能走右或者下,求到Y点有多少种方式
 */
public class RobotWalk {

    public static void main(String[] args) {

        int walk = walk(9, 9);

        System.out.println(walk);
    }


    // f(x, y) = f(x-1, y) + f(x, y -1)
    public static int walk(int x, int y) {

        int[][] matrix = new int[x + 1][y + 1];
        for (int i = 1; i < x + 1; i++) {
            matrix[0][i] = 1;
        }
        for (int i = 1; i < y + 1; i++) {
            matrix[i][0] = 1;
        }

        matrix[0][0] = 0;

        for (int i = 1; i <= x ; i++) {
            for (int j = 1; j <= y; j++) {
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j-1];
            }
        }


        for (int i = 0; i < x + 1; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        return matrix[x][y];

    }
}

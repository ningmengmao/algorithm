package com.ningmeng.leetcode;

import java.util.Arrays;

/**
 * @Author ningmengmao
 * @Date 2021-05-20 10:09:12
 * @Version 1.0
 */
public class JZ29 {

	public static void main(String[] args) {
		var matrix = new int[][] {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};

		var main = new JZ29();
		var ints = main.spiralOrder(matrix);
		System.out.println(Arrays.toString(ints));
	}

	public int[] spiralOrder(int[][] matrix) {
		if (matrix.length == 0) {
			return new int[]{};
		}
		boolean[][] used = new boolean[matrix.length][matrix[0].length];

		int[] res = new int[matrix.length * matrix[0].length];

		used[0][0] = true;
		res[0] = matrix[0][0];
		int[] n = new int[] {0,0};
		int index = 1;

		// 1 右
		// 2 下
		// 3 左
		// 4 上
		int nextDirection = 1;

		while(true) {
			nextDirection = next(n, nextDirection, used);
			if (nextDirection == -1) {
				break;
			}
			res[index++] = matrix[n[0]][n[1]];
		}

		return res;

	}

	private int next(int[] n, int nextDirection, boolean[][] used) {
		int xLen = used.length;
		int yLen = used[0].length;
		int x = n[0];
		int y = n[1];

		if (check(n, used) ) {
			return -1;
		}

		// 右
		if(nextDirection == 2) {
			// 可以左走
			if (x + 1 < xLen ) {
				if (!used[x + 1][y]){
					n[0] = x + 1;
					used[x + 1][y] = true;
					return nextDirection;
				} else {
					return next(n, 3, used);
				}
			}
			return next(n, 3, used);
		}

		// 右
		if(nextDirection == 1) {
			// 可以下走
			if (y + 1 < yLen ) {
				if (!used[x][y + 1]){
					n[1] = y + 1;
					used[x][y + 1] = true;
					return nextDirection;
				} else {
					return next(n, 2, used);
				}
			}
			return next(n, 2, used);
		}

		// 左
		if(nextDirection == 3) {
			// 可以左走
			if (y - 1 >= 0 ) {
				if (!used[x][y - 1]){
					n[1] = y - 1;
					used[x][y - 1] = true;
					return nextDirection;
				} else {
					return next(n, 4, used);
				}
			}
			return next(n, 4, used);
		}

		// 上
		if(nextDirection == 4) {
			// 可以上走
			if (x - 1 >= 0 ) {
				if (!used[x -1][y]){
					n[0] = x - 1;
					used[x - 1][y] = true;
					return nextDirection;
				} else {
					return next(n, 1, used);
				}
			}
			return next(n, 1, used);
		}

		return -1;
	}

	private boolean check(int[] n, boolean[][] used) {
		int x = n[0];
		int y = n[1];

		if ( x - 1 >= 0) {
			if (!used[x - 1][y]) {
				return false;
			}
		}
		if (x + 1 < used.length) {
			if (!used[x + 1][y]) {
				return false;
			}
		}
		if (y - 1 >= 0) {
			if (!used[x][y - 1]) {
				return false;
			}
		}

		if (y + 1 < used[0].length) {
			if (!used[x][y + 1]) {
				return false;
			}
		}
		return true;
	}

}

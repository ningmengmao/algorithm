package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-04-23 21:48:02
 * @Version 1.0
 */
public class Number997 {

	public static void main(String[] args) {
		int[][] arr = {{1,2}};
		System.out.println(findJudge(2, arr));
	}

	public static int findJudge2(int N, int[][] trust) {
		int[] in = new int[N];
		int[] out = new int[N];

		for (int[] i : trust) {
			in[i[1]] += 1;
			out[i[0]] += 1;
		}


		for (int i = 0; i < N; i++) {

			if (in[i] == N - 2 && out[i] == 0) {
				return i;
			}
		}

		return -1;
	}

	// 出度为0, 入度为N-1

	public static int findJudge(int N, int[][] trust) {
		boolean[][] matrix = new boolean[N][N];

		for (int[] i : trust) {
			matrix[i[0] - 1][i[1] - 1] = true;
		}


		for (int i = 0; i < N; i++) {
			int count = 0;
			for (int j = 0; j < N; j++) {
				if (!matrix[i][j] && matrix[j][i]) {
					count += 1;
				}
			}

			// 不相信任何人
			if (count == N - 1) {
				return i + 1;
			}
		}

		return -1;
	}
}

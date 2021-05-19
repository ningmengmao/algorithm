package com.ningmeng.leetcode;

import java.util.PriorityQueue;

/**
 * @Author ningmengmao
 * @Date 2021-05-19 15:34:34
 * @Version 1.0
 */
public class Number1738 {


	public int kthLargestValue(int[][] matrix, int k) {
		int[][] arr = new int[matrix.length][matrix[0].length];

		arr[0][0] = matrix[0][0];

		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
		pq.offer(arr[0][0]);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (i == 0 && j == 0) {
					continue;
				} else if (i == 0) {
					arr[i][j] = matrix[i][j] ^ arr[i][j - 1];
				} else if (j == 0) {
					arr[i][j] = matrix[i][j] ^ arr[i - 1][j];
				} else {
					arr[i][j] = matrix[i][j] ^ arr[i - 1][j] ^ arr[i][j - 1] ^ arr[i - 1][j - 1];
				}
				if (arr[i][j] >= pq.peek()) {
					pq.offer(arr[i][j]);
				}
			}
		}

		int i = 0;
		int res = 0;
		while (i < k) {
			res = pq.remove();
			i++;
		}
		return res;
//		return Arrays.stream(arr).flatMapToInt(Arrays::stream).boxed().sorted((a, b) -> Integer.compare(b, a))
//				.skip(k)
//				.findFirst()
//				.orElse(0);
	}
}

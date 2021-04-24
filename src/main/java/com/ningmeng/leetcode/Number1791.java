package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-04-23 22:30:38
 * @Version 1.0
 */
public class Number1791 {

	public int findCenter(int[][] edges) {
		if (edges[0][0] == edges[1][0]) {
			return edges[0][0];
		}  else if (edges[0][0] == edges[1][1]) {
			return edges[0][0];
		} else {
			return edges[0][1];
		}
		// int[] res = new int[100 * 100 * 10 + 1];
		// int max = 0;
		// int result = -1;
		// for(int i = 0; i < edges.length; i++) {
		//     int from = edges[i][0];
		//     int to = edges[i][1];
		//     res[from] += 1;
		//     res[to] += 1;

		//     if (res[from] > max) {
		//         max = res[from];
		//         result = from;
		//     }

		//     if (res[to] > max) {
		//         max = res[to];
		//         result = to;
		//     }
		// }
		// return result;
	}
}

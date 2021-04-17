package com.ningmeng.nowcoder;

/**
 * @Author ningmengmao
 * @Date 2021-04-10 13:17:06
 * @Version 1.0
 */
public class NC145 {


	public static void main(String[] args) {
		NC145 nc145 = new NC145();
		int[][] vw = {
				{1,3},
				{10,4}
		};
		System.out.println(nc145.knapsack(10,2,vw));
	}

	public int knapsack (int V, int n, int[][] vw) {
		// FIXME: 写错了
		// write code here
		int[] result = new int[V + 1];
		result[0] = 0;

		for(int i = 1; i < V + 1; i++) {
			result[i] = Integer.MIN_VALUE;

			for (int j=0; j < vw.length; j++) {
				if ( i - vw[j][0] >= 0 && result[i - vw[j][0]] != Integer.MIN_VALUE) {
					result[i] = Math.max(result[i], result[i - vw[j][0]] + vw[j][1]);
				}
			}
		}

		return result[V];
	}
}

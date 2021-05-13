package com.ningmeng.leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author ningmengmao
 * @Date 2021-05-13 20:50:16
 * @Version 1.0
 */
public class Number983 {

	public static void main(String[] args) {
		var days = new int[] {1,2,3,4,5,6,7,8,9,10,30,31};
//		var days = new int[] {1,4,6,7,8,20};
		var costs = new int[] {2, 7, 15};
		System.out.println(mincostTickets(days, costs));
	}

	/**
	 * 	f(n) 为第n天,最低花费的票价
	 * 	f(n) = min(	f(n - 1) + costs[0], f(n - 7) + costs[1], f(n - 30) + costs[2])
 	 */
	public static int mincostTickets(int[] days, int[] costs) {

		Set<Integer> set = Arrays.stream(days).boxed().collect(Collectors.toSet());
		int last = days[days.length - 1];

		int[] dp = new int[last + 1];
		dp[0] = 0;

		for (int i = 1; i <= last; i++) {
			int a, b, c;

			if (!set.contains(i)) {
				dp[i] = dp[i - 1];
				continue;
			}

			if (i - 1 < 0) {
				c = costs[0];
			} else {
				c = dp[i - 1] + costs[0];
			}

			if (i - 7 < 0) {
				b = costs[1];
			} else {
				b = costs[1] + dp[i - 7];
			}

			if(i - 30 < 0) {
				a = costs[2];
			} else {
				a = dp[i - 30] + costs[2];
			}

			dp[i] = Math.min(a, Math.min(b ,c));
		}


		return dp[last];
	}
}

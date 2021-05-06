package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-05-06 20:30:53
 * @Version 1.0
 */
public class MST0801 {

	/**
	 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。
	 * 实现一种方法，计算小孩有多少种上楼梯的方式。
	 * 结果可能很大，你需要对结果模1000000007。
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/three-steps-problem-lcci
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * @param n
	 * @return
	 */
	public int waysToStep(int n) {

		if (n < 4) {
			switch(n) {
				case 0:
				case 1:
					return 1;
				case 2:
					return 2;
				case 3:
					return 4;
				default:
					throw new IllegalStateException("Unexpected value: " + n);
			}
		}
		long[] dp = new long[n];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for (int i = 4; i < n; i++) {
			dp[i] = (dp[i - 3] + dp[i -2] + dp[i - 1]) % 1000000007L;
		}

		return (int) (((dp[n - 1] + dp[n -2] + dp[n -3])) % 1000000007L);

	}
}

package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-04-29 21:57:36
 * @Version 1.0
 */
public class Number1266 {

	public int minTimeToVisitAllPoints(int[][] points) {
		int sum = 0;

		for(int i = 0; i < points.length - 1; i++) {
			sum += move(points[i], points[i + 1]);
		}

		return sum;
	}


	/**
	 * 移动时间为x,y轴最大的值
	 *
	 * 输入：points = [[1,1],[3,4],[-1,0]]
	 * 输出：7
	 * 解释：一条最佳的访问路径是： [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]
	 * 从 [1,1] 到 [3,4] 需要 3 秒
	 * 从 [3,4] 到 [-1,0] 需要 4 秒
	 * 一共需要 7 秒
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/minimum-time-visiting-all-points
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 *
	 * @param a
	 * @param b
	 * @return
	 */

	public int move(int[] a, int[] b) {

		int x = Math.abs(a[0] - b[0]);
		int y = Math.abs(a[1] - b[1]);
		if (x >= y) {
			return x;
		} else {
			return y;
		}
	}
}

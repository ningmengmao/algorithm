package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-04-13 22:21:01
 * @Version 1.0
 */
public class Number1689 {

	/*
	如果一个十进制数字不含任何前导零，且每一位上的数字不是 0 就是 1 ，那么该数字就是一个 十-二进制数 。例如，101 和 1100 都是 十-二进制数，而 112 和 3001 不是。
	给你一个表示十进制整数的字符串 n ，返回和为 n 的 十-二进制数 的最少数目。
	来源：力扣（LeetCode）
	链接：https://leetcode-cn.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


	输入：n = "32"
	输出：3
	解释：10 + 11 + 11 = 32

	输入：n = "82734"
	输出：8
	 */
	// 只要找到最大的那个数字,其他位可以通过0,1补充
	public int minPartitions(String n) {

		int result = 0;
		for(String s : n.split("")) {
			result = Math.max(Integer.parseInt(s), result);
		}
		return result;
	}
}

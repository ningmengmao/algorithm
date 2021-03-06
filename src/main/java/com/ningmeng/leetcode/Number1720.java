package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-05-06 20:32:43
 * @Version 1.0
 */
public class Number1720 {

	/**
	 *
	 * 异或满足交换律, 结合律
	 * 0异或x = x
	 * x异或x = 0
	 *
	 * 未知 整数数组 arr 由 n 个非负整数组成。
	 *
	 * 经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
	 *
	 * 给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
	 *
	 * 请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/decode-xored-array
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * @param encoded
	 * @param first
	 * @return
	 */

	public int[] decode(int[] encoded, int first) {
		var result = new int[encoded.length + 1];
		result[0] = first;
		for(var i = 1; i < encoded.length + 1; i++) {
			result[i] = result[i - 1] ^ encoded[i - 1];
		}

		return result;
	}
}

package com.ningmeng.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author ningmengmao
 * @Date 2021-05-07 20:07:27
 * @Version 1.0
 */
public class Number78 {


	/**
	 * 给你一个整数数组nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
	 *
	 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
	 * 示例 1
	 * 输入：nums = [1,2,3]
	 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
	 * 示例 2：
	 * 输入：nums = [0]
	 * 输出：[[],[0]]
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/subsets
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static List<List<Integer>> subsets(int[] nums) {

		List<List<Integer>> dp = new LinkedList<>();
		// f n = f (n - 1) + nums[n]  f(n - 1) 中的每个list都append一下n



		dp.add(new LinkedList<>());

		for (int i = 0; i < nums.length; i++) {
			int finalI = i;
			LinkedList<LinkedList<Integer>> l = dp.stream().map(list -> {
				LinkedList<Integer> res = new LinkedList<>(list);
				res.add(nums[finalI]);
				return res;
			}).collect(Collectors.toCollection(LinkedList::new));
			dp.addAll(l);
		}

		return dp;

	}


}

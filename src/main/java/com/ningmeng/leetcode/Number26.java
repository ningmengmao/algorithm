package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-04-18 18:24:27
 * @Version 1.0
 */
public class Number26 {

	/**
	 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
	 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
	 *
	 * 输入：nums = [1,1,2]
	 * 输出：2, nums = [1,2]
	 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public int removeDuplicates(int[] nums) {
		if (nums.length < 2) {
			return nums.length;
		}

		int p = 0;
		int current = nums[0];
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] != current) {
				nums[p] = current;
				current = nums[i];
				p++;
			}

		}
		nums[p] = nums[nums.length - 1];

		return p + 1;
	}
}

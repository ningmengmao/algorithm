package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-05-09 20:34:29
 * @Version 1.0
 */
public class MST0803 {

	public static void main(String[] args) {
		var arr = new int[]{0,0,2};
		System.out.println(findMagicIndex(arr));
	}


	public static int findMagicIndex(int[] nums) {
		int res = -1;
		for( int i = nums.length - 1; i >= 0; i --) {
			if (nums[i] == i) {
				res = i;
			}
		}
		return res;



	}
}

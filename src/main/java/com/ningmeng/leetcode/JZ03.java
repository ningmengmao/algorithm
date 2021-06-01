package com.ningmeng.leetcode;

import java.util.BitSet;

/**
 * @Author ningmengmao
 * @Date 2021-06-01 22:27:55
 * @Version 1.0
 */
public class JZ03 {

	public static void main(String[] args) {
		System.out.println(findRepeatNumber(new int[]{0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}));
	}

	public static int findRepeatNumber(int[] nums) {

		BitSet bs = new BitSet(nums.length);
		for (int i : nums) {
			if(bs.get(i)){
				return i;
			}
			bs.set(i);
		}
		return -1;

	}


}

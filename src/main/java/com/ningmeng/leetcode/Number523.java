package com.ningmeng.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ningmengmao
 * @Date 2021-06-02 21:40:45
 * @Version 1.0
 */
public class Number523 {

	public static void main(String[] args) {
		checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6);
	}

	/**
	 * 同余定理：如果两个整数m、n满足n-m能被k整除，那么n和m对k同余
	 *
	 * 即 ( pre(j) - pre (i) ) % k == 0 则 pre(j) % k == pre(i) % k
	 * @param nums
	 * @param k
	 * @return
	 */


	public static boolean checkSubarraySum(int[] nums, int k) {
		if (nums.length < 2) {
			return false;
		}
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int a = 0;
		for (int i = 0; i < nums.length; i++) {
			a = ( a + nums[i]) % k;
			if (map.containsKey(a)) {
				int prevIndex = map.get(a);
				if(i - prevIndex >= 2) {
					return true;
				}
			} else {
				map.put(a, i);
			}
		}
		return false;

	}
}

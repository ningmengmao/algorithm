package com.ningmeng.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ningmengmao
 * @Date 2021-05-13 22:17:33
 * @Version 1.0
 */
public class JZ56 {

	// 可以用32位的桶来装nums[i]的二进制数
	// 只要桶中的数为1此就表示为只出现一次的那个数的一位

	public int singleNumber(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for(int i : nums) {
			map.merge(i, 1, Integer::sum);
		}
		return map.entrySet().stream().filter(e -> e.getValue() == 1)
				.map(Map.Entry::getKey)
				.findAny()
				.orElse(0);
	}
}

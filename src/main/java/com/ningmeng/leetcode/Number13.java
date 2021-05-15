package com.ningmeng.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ningmengmao
 * @Date 2021-05-15 12:13:48
 * @Version 1.0
 */
public class Number13 {

	public int romanToInt(String s) {
		Map<Character, Integer> symbolValues = new HashMap<>();
		symbolValues.put('I', 1);
		symbolValues.put('V', 5);
		symbolValues.put('X', 10);
		symbolValues.put('L', 50);
		symbolValues.put('C', 100);
		symbolValues.put('D', 500);
		symbolValues.put('M', 1000);

		int ans = 0;
		int n = s.length();
		for (int i = 0; i < n; ++i) {
			int value = symbolValues.get(s.charAt(i));
			if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
				ans -= value;
			} else {
				ans += value;
			}
		}
		return ans;

	}
}

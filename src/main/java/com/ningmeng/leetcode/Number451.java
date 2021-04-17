package com.ningmeng.leetcode;

import java.util.HashMap;

/**
 * @Author ningmengmao
 * @Date 2021-04-17 18:32:20
 * @Version 1.0
 */
public class Number451 {

	public static void main(String[] args) {

		String s = "cccaaabb";
		HashMap<Character, Integer> map = new HashMap<>();

		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

		StringBuilder sb = new StringBuilder();

		map.entrySet().stream().sorted((entry1, entry2) -> -Integer.compare(entry1.getValue(), entry2.getValue())).forEach(entry -> {
			for (int i = 0; i < entry.getValue(); i++) {
				sb.append(entry.getKey());
			}
		});

		System.out.println(sb);
	}
}

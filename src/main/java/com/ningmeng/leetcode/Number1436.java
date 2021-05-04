package com.ningmeng.leetcode;

import java.util.HashSet;
import java.util.List;

/**
 * @Author ningmengmao
 * @Date 2021-05-04 14:27:22
 * @Version 1.0
 */
public class Number1436 {

	// 终点出度为0, 即在出度set中不存在

	public String destCity(List<List<String>> paths) {

		HashSet<String> set1 = new HashSet<>();
		HashSet<String> set2 = new HashSet<>();

		for(List<String> list : paths) {
			String from = list.get(0);
			String to = list.get(1);

			set1.add(from);
			set2.add(to);
		}

		for (String str : set2) {
			if (!set1.contains(str)) {
				return str;
			}
		}
		return null;
	}
}

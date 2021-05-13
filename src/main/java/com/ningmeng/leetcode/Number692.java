package com.ningmeng.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author ningmengmao
 * @Date 2021-05-13 22:15:26
 * @Version 1.0
 */
public class Number692 {


	public List<String> topKFrequent(String[] words, int k) {

		HashMap<String, Integer> map = new HashMap<>();

		PriorityQueue<String> queue = new PriorityQueue<>((s1, s2) -> {
			int r = Integer.compare(map.get(s1), map.get(s2));
			if (r == 0) {
				return s1.compareTo(s2);
			} else {
				return -r;
			}
		});
		for (String s : words) {
			if(map.containsKey(s)) {
				map.merge(s, 1, Integer::sum);
			} else {
				map.put(s, 1);
			}
		}
		map.keySet().forEach(queue::offer);
		LinkedList<String> list = new LinkedList<>();
		for(int i = 0; i < k; i++) {
			list.add(queue.remove());
		}

		return list;
	}
}

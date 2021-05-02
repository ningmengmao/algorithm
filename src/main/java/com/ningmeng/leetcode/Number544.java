package com.ningmeng.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ningmengmao
 * @Date 2021-05-02 10:30:14
 * @Version 1.0
 */
public class Number544 {

	public int leastBricks(List<List<Integer>> wall) {
		int n = wall.size();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0, sum = 0; i < n; i++, sum = 0) {
			for (int cur : wall.get(i)) {
				sum += cur;
				map.put(sum, map.getOrDefault(sum, 0) + 1);
			}
			map.remove(sum); // 不能从两边穿过，需要 remove 掉最后一个
		}
		int ans = n;
		for (int u : map.keySet()) {
			int cnt = map.get(u);
			ans = Math.min(ans, n - cnt);
		}
		return ans;
	}
}

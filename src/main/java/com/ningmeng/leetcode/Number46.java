package com.ningmeng.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author ningmengmao
 * @Date 2021-05-07 20:53:43
 * @Version 1.0
 */
public class Number46 {

	List<List<Integer>> res = new LinkedList<>();
	public List<List<Integer>> permute(int[] nums) {

		List<Integer> sources = IntStream.of(nums).boxed().collect(Collectors.toList());

		dfs(new LinkedList<>(), sources);

		return res;

	}


	private void dfs(List<Integer> target, List<Integer> sources) {

		if (target.size() == sources.size()) {
			res.add(target);
			return;
		}

		for(int i : sources) {
			if (!target.contains(i)) {
				List<Integer> t = new LinkedList<>(target);
				t.add(i);
				dfs(t, sources);
			}
		}

	}
}

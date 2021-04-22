package com.ningmeng.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author ningmengmao
 * @Date 2021-04-22 13:49:18
 * @Version 1.0
 */
public class Number590 {

	public List<Integer> postorder(Node root) {

		LinkedList<Integer> res = new LinkedList<>();

		dfs(root, res);

		return res;
	}

	public void dfs(Node node, List<Integer> list) {
		if (node == null) {
			return;
		}

		if (node.children != null) {
			node.children.forEach(e -> {
				dfs(e, list);
			});
		}
		list.add(node.val);
	}
}

package com.ningmeng.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author ningmengmao
 * @Date 2021-06-05 22:52:35
 * @Version 1.0
 */
public class Number145 {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new LinkedList<>();
		dfs(root, list);
		return list;
	}

	private void dfs (TreeNode node, List<Integer> list) {
		if (node == null) {
			return;
		}
		dfs(node.left, list);
		dfs(node.right, list);
		list.add(node.val);
	}
}

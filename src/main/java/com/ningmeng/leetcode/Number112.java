package com.ningmeng.leetcode;

import java.util.HashSet;

/**
 * @Author ningmengmao
 * @Date 2021-05-22 20:03:21
 * @Version 1.0
 */
public class Number112 {

	HashSet<Integer> set = new HashSet<>();
	public boolean hasPathSum(TreeNode root, int targetSum) {
		dfs(root, root.val);
		return set.contains(targetSum);
	}

	private void dfs(TreeNode node, int sum) {
		if (node == null) {
			set.add(sum);
			return;
		}
		dfs(node.left, sum + node.val);
		dfs(node.right, sum + node.val);
	}
}

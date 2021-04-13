package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-04-13 09:33:23
 * @Version 1.0
 */
public class Number783 {



	public static void main(String[] args) {
		Number783 number783 = new Number783();

	}

	int prv = Integer.MIN_VALUE + 10000000;
	int min = Integer.MAX_VALUE;
	public int minDiffInBST(TreeNode root) {
		dfs(root);
		return min;
	}


	public void dfs(TreeNode node) {
		if(node == null) {
			return;
		}
		dfs(node.left);
		min = Math.min(node.val - prv, min);
		prv = node.val;
		dfs(node.right);
	}
}

package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-05-17 09:01:52
 * @Version 1.0
 */
public class Number993 {

	public static void main(String[] args) {
		var main = new Number993();
		Integer[] arr = {1,2,3,null,4,null,5};
		var root = Number101.generate(arr);
		main.isCousins(root, 5, 4);
	}

	int parent = -1;
	public boolean isCousins(TreeNode root, int x, int y) {
		int a = dfs(root, 0, x);
		int ap = parent;
		int b = dfs(root, 0, y);
		return a == b && ap != parent;
	}

	private int dfs(TreeNode node, int deep, int x) {
		if (node == null) {
			return -1;
		}
		if (node.left != null && node.left.val == x) {
			parent = node.val;
			return deep + 1;
		}else if (node.right != null && node.right.val == x) {
			parent = node.val;
			return deep + 1;
		} else {
			 int i = dfs(node.left, deep + 1, x);
			 int j = dfs(node.right, deep + 1, x);
			 return Math.max(i, j);
		}
	}


}

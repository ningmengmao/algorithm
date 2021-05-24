package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-05-24 17:45:47
 * @Version 1.0
 */
public class Number114 {

	public static void main(String[] args) {
		var root = Number101.generate(new Integer[]{1,2,5,3,4,null,6});
		var main = new Number114();
		main.flatten(root);
	}

	public void flatten(TreeNode root) {
		TreeNode node  = dfs(root);
		root.left = null;
		root.right = node.right;

	}


	private TreeNode dfs(TreeNode node) {
		if (node == null) {
			return null;
		}
		TreeNode n = new TreeNode(node.val);
		TreeNode l = dfs(node.left);
		TreeNode r = dfs(node.right);
		if (l != null) {
			n.right = l;
			while (l.right != null) {
				l = l.right;
			}
			l.right = r;
		} else {
			n.right = r;
		}
		return n;
	}
}

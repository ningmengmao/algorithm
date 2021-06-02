package com.ningmeng.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author ningmengmao
 * @Date 2021-06-02 22:09:19
 * @Version 1.0
 */
public class Number144 {

	/**
	 * 二叉树前序遍历
	 * @param root
	 * @return
	 */

	public List<Integer> preorderTraversal(TreeNode root) {

		if(root == null) {
			return new LinkedList<>();
		}

		LinkedList<TreeNode> stack = new LinkedList<>();
		List<Integer> list = new LinkedList<>();

		stack.push(root);
		while(!stack.isEmpty()){
			root = stack.pop();
			list.add(root.val);
			if (root.right != null) {
				stack.push(root.right);
			}

			if(root.left != null) {
				stack.push(root.left);
			}
		}

		return list;

	}
}

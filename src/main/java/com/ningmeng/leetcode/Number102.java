package com.ningmeng.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author ningmengmao
 * @Date 2021-06-04 20:34:52
 * @Version 1.0
 */
public class Number102 {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new LinkedList<>();
		if (root == null) {
			return res;
		}

		LinkedList<TreeNode> queue = new LinkedList<>();
		LinkedList<TreeNode> tempQueue = new LinkedList<>();

		queue.addLast(root);
		LinkedList<TreeNode> t;
		while(!queue.isEmpty()) {
			LinkedList<Integer> temp = new LinkedList<>();
			while (!queue.isEmpty()) {
				root = queue.remove();
				temp.add(root.val);
				if (root.left != null) {
					tempQueue.offer(root.left);
				}
				if(root.right != null) {
					tempQueue.offer(root.right);
				}
			}
			t = queue;
			queue = tempQueue;
			tempQueue = t;
			res.add(temp);
		}
		return res;
	}
}

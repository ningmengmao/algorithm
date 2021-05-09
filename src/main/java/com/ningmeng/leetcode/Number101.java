package com.ningmeng.leetcode;

import java.util.LinkedList;

/**
 * @Author ningmengmao
 * @Date 2021-05-08 11:07:21
 * @Version 1.0
 */
public class Number101 {

	public static void main(String[] args) {
		TreeNode generate = generate();

		System.out.println(isSymmetric(generate));
	}

	public static boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return false;
		}
		LinkedList<TreeNode> node = new LinkedList<>();

		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.addLast(root);

		while(!queue.isEmpty()){
			root = queue.removeFirst();
			node.add(root);
			if (root != null && root.left != null && root.right != null) {
				queue.addLast(root.left);
				queue.addLast(root.right);
			}
		}

		int r = (node.size() - 1 - 1) / 2;
		int l = (int) (Math.log(r) / Math.log(2));
		l = (int) Math.pow(2, l - 1);
		l = r - l;
		while (r != 0){
			if (l >= r) {
				int i = (int) (Math.log(r) / Math.log(2));

				r -= (int) Math.pow(2, i);
				l = (int) (Math.log(r) / Math.log(2));
				l = (int) Math.pow(2, l - 1);
				l = r - l;
			}
			TreeNode right = node.get(r);
			TreeNode left = node.get(l);
			if (left.left.val != right.right.val) {
				return false;
			}
			if(left.right.val != right.left.val) {
				return false;
			}

			l++;
			r--;

		}
		return true;
	}


	public static TreeNode generate() {
		Integer[] arr = {1,2,2,3,4,4,3};
		LinkedList<TreeNode> treeNodes = new LinkedList<>();
		treeNodes.add(new TreeNode(arr[0]));
		for (int i = 1; i < arr.length; i++) {
			TreeNode t = null;
			if (arr[i] != null) {
				t = new TreeNode(arr[i]);
			}
			treeNodes.add(t);
			int parent = (i - 1) / 2;
			TreeNode node = treeNodes.get(parent);
			if (node == null) {
				continue;
			}
			if ( i / 2 == parent) {
				node.left = t;
			} else {
				node.right = t;
			}
		}

		return treeNodes.get(0);
	}
}

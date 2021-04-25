package com.ningmeng.leetcode;

import java.util.LinkedList;

/**
 * @Author ningmengmao
 * @Date 2021-04-25 09:27:28
 * @Version 1.0
 */
public class Number897 {

	public static void main(String[] args) {
		TreeNode root = generate();

		TreeNode treeNode = increasingBST(root);
		System.out.println(treeNode);

	}


	public static TreeNode generate() {
		Integer[] arr = {5,3,6,2,4,null,8,1,null,null,null,null,null,7,9};
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


	public static TreeNode increasingBST(TreeNode root) {
		LinkedList<TreeNode> stack = new LinkedList<>();
		TreeNode newRoot = null;
		TreeNode res = null;
		TreeNode temp  = root;


		while(!stack.isEmpty() || temp != null) {
			while (temp != null) {
				stack.push(temp);
				temp = temp.left;
			}

			temp = stack.pop();
			if (newRoot == null) {
				newRoot = new TreeNode(temp.val);
				res = newRoot;
			} else {
				newRoot.right = new TreeNode(temp.val);
				newRoot = newRoot.right;
			}
			temp = temp.right;
		}
		return res;
	}
}

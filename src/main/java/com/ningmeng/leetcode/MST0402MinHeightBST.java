package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-04-18 18:22:27
 * @Version 1.0
 */
public class MST0402MinHeightBST {

	/**
	 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
	 *
	 * 给定有序数组: [-10,-3,0,5,9],
	 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
	 *           0
	 *          / \
	 *        -3   9
	 *        /   /
	 *      -10  5
	 * 链接：https://leetcode-cn.com/problems/minimum-height-tree-lcci
	 */

	/**
	 * 分治 + 递归 + BST的插入
	 */

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0) {
			return null;
		} else {
			if (nums.length == 1) {
				return new TreeNode(nums[0]);
			}
		}

		return sort(nums, 0, nums.length);
	}


	public TreeNode sort(int[] nums, int start, int end) {
		int base = (end - start) / 2 + start;
		TreeNode root = new TreeNode(nums[base]);

		if (end -start == 1) {
			root.val = nums[start];
			return root;
		}
		if (end - start == 2) {
			root.val = nums[start];
			add(root, nums[end - 1]);
			return  root;
		}
		if (end - start < 4) {
			add(root, nums[start]);
			add(root, nums[end - 1]);
			return  root;
		}

		root.left = sort(nums, start, base);
		root.right = sort(nums, base + 1, end);

		return root;

	}


	public void add(TreeNode node, int val) {
		if (node.val < val) {
			if (node.right != null) {
				add(node.right, val);
			} else {
				node.right = new TreeNode(val);
			}
		} else if (node.val > val) {
			if (node.left != null) {
				add(node.left, val);
			} else {
				node.left = new TreeNode(val);
			}
		}
	}
}

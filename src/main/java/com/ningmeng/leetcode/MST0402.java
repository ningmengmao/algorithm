package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-04-18 12:56:06
 * @Version 1.0
 */
public class MST0402 {

	public static void main(String[] args) {
		int[] arr = {0,1,2,3,4,5,6,7,8};

		MST0402 m = new MST0402();
		TreeNode root = m.sortedArrayToBST(arr);
		System.out.println(root);
	}

	public TreeNode sortedArrayToBST(int[] nums) {

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

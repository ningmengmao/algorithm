package com.ningmeng.leetcode;

import java.util.List;

/**
 * @Author ningmengmao
 * @Date 2021-04-22 13:50:31
 * @Version 1.0
 */
public class Node {
	public int val;
	public List<Node> children;

	public Node() {}

	public Node(int val) {
		this.val = val;
	}

	public Node(int val, List<Node> children) {
		this.val = val;
		this.children = children;
	}
};

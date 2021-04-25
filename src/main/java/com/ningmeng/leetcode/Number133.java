package com.ningmeng.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author ningmengmao
 * @Date 2021-04-24 19:52:12
 * @Version 1.0
 */
public class Number133 {

	public static void main(String[] args) {

	}


	public Node cloneGraph(Node node) {

		if (node == null) {
			return null;
		}
		HashMap<Integer, Node> map = new HashMap<>();
		int val = node.val;

		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(node);
		boolean[] used = new boolean[100];

		used[node.val - 1] = true;
		while (!queue.isEmpty()) {
			node = queue.removeFirst();
			if (!map.containsKey(node.val)) {
				map.put(node.val, new Node(node.val));
			}
			if (node.neighbors != null) {
				for (Node neighbor : node.neighbors) {
					Node n1;
					if (map.containsKey(neighbor.val)) {
						n1 = map.get(neighbor.val);
					} else {
						n1 = new Node(neighbor.val, new ArrayList<>());
					}
					Node get = map.get(node.val);
					get.neighbors.add(n1);
					map.put(neighbor.val, n1);
					if (!used[neighbor.val - 1]) {
						queue.addLast(neighbor);
					}
					used[neighbor.val - 1] = true;
				}
			}
		}

		return map.get(val);
	}


	class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<>();
		}

		public Node(int val) {
			this.val = val;
			neighbors = new ArrayList<>();
		}

		public Node(int val, ArrayList<Node> neighbors) {
			this.val = val;
			this.neighbors = neighbors;
		}
	}
}

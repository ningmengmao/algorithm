package com.ningmeng.base.tree;

import java.util.LinkedList;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @Author ningmengmao
 * @Date 2021-04-02 09:08:31
 * @Version 1.0
 */
public class App {

	public static void main(String[] args) {
		Node node = buildTree();
		System.out.println("前序");
		VLR(node);
		System.out.println("\n中序");
		LDR(node);
		System.out.println("\n后序");
		LRD(node);
		System.out.println("\n前序递归");
		VLR1(node);
		System.out.println("\n中序递归");
		LDR1(node);


	}

	public static void VLR1(Node node) {
		if(node == null) {
			return;
		}
		System.out.print(node.data + ",  ");
		VLR1(node.leftChild);
		VLR1(node.rightChild);
	}

	public static void LDR1(Node node) {
		if(node == null) {
			return;
		}
		LDR1(node.leftChild);
		System.out.print(node.data + ",  ");
		LDR1(node.rightChild);
	}


	// 前序遍历
	public static void VLR(Node node) {
		LinkedList<Node> stack = new LinkedList<>();
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				stack.push(node);
				System.out.print(node.data + ",  ");
				node = node.leftChild;
			}
			if (!stack.isEmpty() ) {
				node = stack.pop().rightChild;
			}
		}
	}

	// 中序遍历
	public static void LDR(Node node) {
		LinkedList<Node> stack = new LinkedList<>();
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				stack.push(node);
				node = node.leftChild;
			}
			if (!stack.isEmpty() ) {
				node = stack.pop();
				System.out.print(node.data + ",  ");
				node = node.rightChild;
			}
		}
	}

	// 后续遍历
	public static void LRD(Node node) {
		if (node == null) {
			return;
		}

		LRD(node.leftChild);
		LRD(node.rightChild);
		System.out.print(node.data + ",  ");
	}


	private static Node buildTree() {
		Random random = new Random();
		int[] array = IntStream.range(0, 13).toArray();
		return build(array, 0);
	}

	private static Node build(int[] array, int index) {
		if (index >= array.length) {
			return null;
		}
		Node node = new Node(array[index]);
		node.leftChild = build(array, index * 2 + 1);
		node.rightChild = build(array, index * 2 + 2);
		return node;
	}

	private static class Node {
		int data;
		Node leftChild;
		Node rightChild;

		public Node() {
		}

		public Node(int data) {
			this.data = data;
		}

		public Node(int data, Node leftChild, Node rightChild) {
			this.data = data;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}

		@Override
		public String toString() {
			return "Node{" +
					"data=" + data +
					", leftChild=" + leftChild +
					", rightChild=" + rightChild +
					'}';
		}
	}
}

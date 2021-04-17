package com.ningmeng.leetcode;


/**
 * @Author ningmengmao
 * @Date 2021-04-02 23:22:10
 * @Version 1.0
 */
public class Number115 {

	public static void r() {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {
		r();
		MinStack minStack = new MinStack();
		minStack.push(2147483646);
		minStack.push(2147483646);
		minStack.push(2147483647);

		minStack.top();
		minStack.pop();
		minStack.getMin();
		minStack.pop();
		minStack.getMin();
		minStack.pop();
		minStack.push(2147483647);
		minStack.top();
		minStack.getMin();
		minStack.push(-2147483648);
		minStack.top();
		minStack.getMin();
		minStack.pop();
		minStack.getMin();
	}

	static class MinStack {

		Node stack = null;

		MinStack minStack = null;

		/** initialize your data structure here. */
		public MinStack() {

		}

		private void minPush(int val) {
			if (stack == null) {
				stack = new Node(val);
				return;
			}
			int top = this.top();
			if (top > val) {
				Node n = new Node(val);
				n.next = stack;
				stack = n;
			} else {
				Node temp = stack;
				Node before = null;
				while (temp != null) {
					if (temp.value > val) {
						Node n = new Node(val);
						before.next = n;
						n.next =temp;
						return;
					}
					before = temp;
					temp = temp.next;
				}
				before.next = new Node(val);
			}
		}

		public void push(int val) {
			Node node = new Node(val);
			node.next = stack;
			stack = node;

			if (minStack == null) {
				minStack = new MinStack();
				minStack.stack = new Node(val);
			} else {
				minStack.minPush(val);
			}
		}

		public void pop() {
			int top = top();
			stack = stack.next;
			minStack.remove(top);
		}

		private void remove(int val) {
			Node temp = stack;
			Node before = null;
			while (temp != null) {
				if (temp.value == val) {
					if (before != null) {
						before.next = temp.next;
						break;
					} else {
						stack = temp.next;
					}
				}
				before = temp;
				temp = temp.next;
			}
		}

		public int top() {
			return stack.value;
		}

		public int getMin() {
			return minStack.top();
		}

		class Node {
			int value;
			Node next;

			public Node(int value) {
				this.value = value;
			}
		}
	}
}

package com.ningmeng.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author ningmengmao
 * @Date 2021-05-30 22:50:48
 * @Version 1.0
 */
public class Number225 {

	class MyStack {
		Queue<Integer> stack;
		Queue<Integer> temp;


		/** Initialize your data structure here. */
		public MyStack() {
			stack = new LinkedList<>();
			temp = new LinkedList<>();
		}

		/** Push element x onto stack. */
		public void push(int x) {
			int size = stack.size();
			stack.offer(x);
			for (int i = 0; i < size; i++) {
				stack.offer(stack.poll());
			}
//			while(!stack.isEmpty()) {
//				temp.offer(stack.poll());
//			}
//			stack.offer(x);
//			while(!temp.isEmpty()) {
//				stack.offer(temp.poll());
//			}

		}

		/** Removes the element on top of the stack and returns that element. */
		public int pop() {
			return stack.poll();
		}

		/** Get the top element. */
		public int top() {
			return stack.element();
		}

		/** Returns whether the stack is empty. */
		public boolean empty() {
			return stack.isEmpty();
		}
	}
}

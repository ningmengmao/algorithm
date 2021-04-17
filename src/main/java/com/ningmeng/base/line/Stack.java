package com.ningmeng.base.line;

import java.util.NoSuchElementException;

/**
 * @Author ningmengmao
 * @Date 2020-12-12 20:26:15
 * @Version 1.0
 */
public class Stack<T> {

	private final Object[] stack;
	private final int size;

	/**
	 * 指向栈的下一个空余位置
 	 */
	private int top;


	public Stack(int size) {
		this.size = size;
		stack = new Object[size];
		top = 0;
	}

	public Stack() {
		this.size = 10;
		stack = new Object[size];
		top = 0;
	}

	public void push(T object) {
		if (top == size) {
			throw new StackOverflowError();
		}
		this.stack[top] = object;
		top++ ;
	}

	@SuppressWarnings("unchecked")
	public T pop() {
		if (top == 0) {
			throw new NoSuchElementException();
		}
		Object o = this.stack[--top];
		return (T) o;
	}

	@SuppressWarnings("unchecked")
	public T peek() {
		if (top == 0) {
			throw new NoSuchElementException();
		}
		return (T) this.stack[top - 1];
	}

	public boolean isEmpty() {
		return top > 0;
	}

	public int size() {
		return top;
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}
	}

}

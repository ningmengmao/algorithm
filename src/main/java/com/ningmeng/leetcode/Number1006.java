package com.ningmeng.leetcode;

import java.util.LinkedList;

/**
 * @Author ningmengmao
 * @Date 2021-04-18 21:41:10
 * @Version 1.0
 */
public class Number1006 {

	public static void main(String[] args) {
		System.out.println(t(10000));

		LinkedList<Integer> list = new LinkedList<>();

	}

	public static int t(int N) {
		if (N == 1) {
			return 1;
		}
		LinkedList<Long> stack = new LinkedList<>();
		char[] factory = {'*', '/', '+', '-'};
		int idx = 0;
		stack.push((long) N);
		long n = N - 1;
		while (n != 0) {
			switch (factory[idx++]) {
				case '+':
					stack.push(n);
					break;
				case '-':
					stack.push(-n);
					break;
				case '*':
					Long l = stack.pop();
					stack.push(l * n);
					break;
				case '/':
					Long m = stack.pop();
					stack.push(m / n);
					break;
				default:
			}
			n -= 1;
			if (idx == 4) {
				idx = 0;
			}

		}
		long sum = 0;
		while (!stack.isEmpty()) {
			sum += stack.pop();
		}

		return (int) sum;
	}

}

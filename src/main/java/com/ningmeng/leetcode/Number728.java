package com.ningmeng.leetcode;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author ningmengmao
 * @Date 2021-05-04 22:40:50
 * @Version 1.0
 */
public class Number728 {

	public static void main(String[] args) {
		Number728 main = new Number728();
		main.selfDividingNumbers(1,22).forEach(e -> System.out.print(e + "\t"));
	}


	public List<Integer> selfDividingNumbers(int left, int right) {
		return IntStream.range(left, right + 1)
				.filter(this::filter)
				.boxed()
				.collect(Collectors.toList());
	}

	private boolean filter(int n) {
		if (n < 10) {
			return true;
		}
		String str = String.valueOf(n);
		if (str.contains("0")) {
			return false;
		}

		for(char c : str.toCharArray()) {
			int i = c - '0';
			if (n % i != 0) {
				return false;
			}
		}

		return true;
	}
}

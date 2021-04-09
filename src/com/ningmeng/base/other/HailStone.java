package com.ningmeng.base.other;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author ningmengmao
 * @Date 2020-12-19 15:56:39
 * @Version 1.0
 */
public class HailStone {

	public List<Integer> generate(int n) {
		LinkedList<Integer> list = new LinkedList<>();
		while(1 < n) {
			if (n % 2 == 0) {
				n = n / 2;
				list.add(n);
			} else {
				n = n * 3 + 1;
				list.add(n);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		List<Integer> generate = new HailStone().generate(102);
		generate.forEach(System.out::println);
	}
}

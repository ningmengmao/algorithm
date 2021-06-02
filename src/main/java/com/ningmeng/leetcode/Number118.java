package com.ningmeng.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author ningmengmao
 * @Date 2021-06-02 23:12:58
 * @Version 1.0
 */
public class Number118 {

	public static void main(String[] args) {
		System.out.println(generate(5));
	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new LinkedList<>();

		List<Integer> list = new ArrayList<>(1);
		list.add(1);
		res.add(list);

		for(int i = 2 ; i <= numRows; i++) {
			List<Integer> temp = new ArrayList<>(i);
			List<Integer> before = res.get(i - 2);
			for (int j = 0; j < i; j++) {

				if (j == 0 || j == i - 1) {
					temp.add(1);
				} else {
					int l = before.get(j - 1);
					int r = before.get(j);
					temp.add(l + r);
				}

			}
			res.add(temp);
		}

		return res;

	}
}

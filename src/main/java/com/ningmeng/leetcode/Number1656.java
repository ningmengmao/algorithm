package com.ningmeng.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author ningmengmao
 * @Date 2021-05-04 13:35:26
 * @Version 1.0
 */
public class Number1656 {
	private final String[] array ;
	private int index = 0;

	public Number1656(int n) {
		array = new String[n];
	}

	public List<String> insert(int idKey, String value) {
		List<String> res = new LinkedList<>();
		array[idKey - 1] = value;

		while((array.length > index + 1) && array[index] != null){
			res.add(array[index++]);
		}

		return res;

	}
}

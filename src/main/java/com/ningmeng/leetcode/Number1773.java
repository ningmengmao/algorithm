package com.ningmeng.leetcode;

import java.util.List;

/**
 * @Author ningmengmao
 * @Date 2021-04-03 21:54:13
 * @Version 1.0
 */
public class Number1773 {


}
class Solution {
	public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

		return (int) items.stream().filter(e -> f(e, ruleKey, ruleValue)).count();
	}

	public boolean f(List<String> list, String ruleKey, String ruleValue) {
		switch (ruleKey) {
			case "type":
				return ruleValue.equals(list.get(0));
			case "color":
				return ruleValue.equals(list.get(1));
			case "name":
				return ruleValue.equals(list.get(2));
			default:
				return false;
		}
	}
}
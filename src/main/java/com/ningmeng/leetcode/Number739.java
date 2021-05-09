package com.ningmeng.leetcode;

import java.util.*;

/**
 * @Author ningmengmao
 * @Date 2021-05-08 09:43:01
 * @Version 1.0
 */
public class Number739 {

	public static void main(String[] args) {
		Number739 main = new Number739();
		int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
		int[] res = main.dailyTemperatures(arr);
		System.out.println(Arrays.toString(res));
	}



	public int[] dailyTemperatures(int[] T) {
		int length = T.length;
		int[] ans = new int[length];
		Deque<Integer> stack = new LinkedList<>();
		for (int i = 0; i < length; i++) {
			int temperature = T[i];
			while (!stack.isEmpty() && temperature > T[stack.peek()]) {
				int prevIndex = stack.pop();
				ans[prevIndex] = i - prevIndex;
			}
			stack.push(i);
		}
		return ans;
	}

	public int[] dailyTemperatures2(int[] T) {
		Map<Integer, List<Integer>> bucket = new HashMap<>();

		for (int i = 0; i < T.length; i++) {
			if (bucket.containsKey(T[i])) {
				bucket.get(T[i]).add(i);
			} else {
				List<Integer> list = new LinkedList<>();
				list.add(i);
				bucket.put(T[i], list);
			}
		}

		int[] res = new int[T.length];
		for(int i = 0; i < T.length; i++) {
			int current = T[i];

			int finalI = i;
			res[i] =  bucket.entrySet().stream()
					.filter(e -> e.getKey() > current)
					.map(Map.Entry::getValue)
					.flatMap(List::stream)
					.filter(e -> e > finalI)
					.sorted()
					.findFirst()
					.orElse(i) - i;
		}

		return res;

	}

}

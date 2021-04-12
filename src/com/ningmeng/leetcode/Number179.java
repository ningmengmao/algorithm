package com.ningmeng.leetcode;

import java.util.stream.IntStream;

/**
 * @Author ningmengmao
 * @Date 2021-04-12 09:05:12
 * @Version 1.0
 */
public class Number179 {

	public static void main(String[] args) {
		Number179 number179 = new Number179();
		int[] arr = {3,30,34,5,9,0};
//		System.out.println(number179.largestNumber(arr));

		String reduce = IntStream.of(arr)
				.boxed()
				.map(String::valueOf)
				.sorted((e1, e2) -> {
					String sum1 = e1 + e2;
					String sum2 = e2 + e1;

					for(int i = 0; i < sum1.length(); i++){
						if(sum1.charAt(i) != sum2.charAt(i)){
							return sum2.charAt(i) - sum1.charAt(i);
						}
					}
					return 0;
				}).reduce("", (s1, s2) -> s1 + s2);

		System.out.println(reduce);
	}

	public String largestNumber(int[] nums) {

		int[] bucket  =  new int[10];

		for(int i : nums) {
			for(char c : String.valueOf(i).toCharArray()) {
				int index =  c - '0';
				bucket[index]++;
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 9; i>=0; i--) {
			sb.append(String.valueOf(i).repeat(Math.max(0, bucket[i])));
		}

		return sb.toString();
	}
}

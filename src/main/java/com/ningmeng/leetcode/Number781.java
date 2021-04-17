package com.ningmeng.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @Author ningmengmao
 * @Date 2021-04-04 10:34:27
 * @Version 1.0
 */
public class Number781 {

	public static void main(String[] args) {
		Solution solution = new Solution();

		int[] arr = {0,3,2,0,3,3,4,2,4,3,2,4,4,3,0,1,3,4,4,3};
		System.out.println(solution.numRabbits(arr));
		System.out.println(solution.n(arr));

	}


	static class Solution {
		public int numRabbits(int[] answers) {
			int[] radix = new int[1001];
			int[] total = new int[1001];

			for (int i : answers) {
				if (i == 0) {
					radix[1] += 1;
				} else {
					total[i + 1] += 1;
					if (radix[i + 1] == 0) {
						radix[i + 1] += 1;
					} else if (total[i + 1] > i + 1) {
						radix[i + 1] += 1;
						total[i + 1] = 1;
					}
				}
			}
			int sum = 0;
			for (int i = 0; i < radix.length; i++) {
				sum += ( i * radix[i]);
			}

			return sum;
		}


		public int n(int[] answers) {
			int[] radix = new int[1000];
			for (int i : answers) {
				radix[i] += 1;
			}

			int sum = radix[0];
			for (int i = 1; i < radix.length; i++) {
				if(radix[i] > 0) {
					int count = radix[i] / (i + 1);
					if (count > 0) {
						if (radix[i] % (1 + i) > 0 ){
							sum += (count + 1) * (i + 1);
						} else {
							sum += radix[i];
						}
					} else {
						sum += i + 1;
					}
				}
			}

			return sum;
		}
	}
}


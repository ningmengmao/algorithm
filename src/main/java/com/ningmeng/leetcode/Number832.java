package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-04-12 23:09:46
 * @Version 1.0
 */
public class Number832 {

	public int[][] flipAndInvertImage(int[][] image) {
		int[][] result = new int[image.length][image[0].length];

		for(int i=0; i<image.length; i++) {
			for(int j=0; j<image.length; j++) {
				result[i][j] = Math.abs(image[i][image.length - 1 - j] - 1);
			}
		}

		return result;

	}
}

package com.ningmeng.base.dp;

/**
 * 有n块事故体育分别在x轴的0,1,...,n-1的位置
 * 一只青蛙在石头0,想跳到石头n-1
 * 如果青蛙在第i块石头上,它最多可以向右跳距离a[i]
 * 问青蛙能否跳到石头n-1
 *
 * 例
 * input: [2,3,1,1,4]
 * output: true
 * input: [3,2,1,0,4]
 * output: false
 *
 * @Author ningmengmao
 * @Date 2021-04-11 12:49:20
 * @Version 1.0
 */
public class JumpingFrog {
	public static void main(String[] args) {
		int[] arr = {2,3,1,1,4};

		System.out.println(jump(arr));

		int[] arr2 = {3,2,1,0,4};
		System.out.println(jump(arr2));

	}


	public static boolean jump(int[] arr) {
		boolean[] result = new boolean[arr.length];

		result[0] = true;

		// result[i] && arr[i] + i >= targetIndex

		for(int i = 1; i < arr.length ; i++) {

			for (int j = 0; j < i; j++) {
				if(result[j] && arr[j] + j >= i ) {
					result[i] = true;
					break;
				}
			}
		}

		return result[arr.length - 1];

	}
}

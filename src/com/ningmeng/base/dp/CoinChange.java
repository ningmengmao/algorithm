package com.ningmeng.base.dp;

/**
 * 给定一组硬币int[] coins，和一个目标数字int target，使用最少的硬币拼出目标数字，返回最少的硬币数，无法拼出则返回-1
 */
public class CoinChange {


    public static void main(String[] args) {
        int[] coins = {2,5,7};

        System.out.println(change(coins, 27));
        System.out.println(change(coins, 11));
    }


    /*
    f(n) 表示拼成n需要的硬币数
    f(n) = min(f(n-coins[0]) + 1, f(n-coins[1])+1, f(n-coins[2]) + 1.....)
     */
    public static int change(int[] coins, int target) {
        int[] f = new int[target + 1];

        f[0] = 0;
        for (int i = 1; i <= target ; i++) {
            f[i] = Integer.MAX_VALUE;

            for (int coin : coins) {
                if (i - coin >= 0 && f[i - coin] != Integer.MAX_VALUE) {
                    f[i] = Math.min(f[i - coin] + 1, f[i]);
                }
            }
        }
        return f[target] == Integer.MAX_VALUE ? -1 : f[target] ;
    }
}

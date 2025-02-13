package algorithm;

import java.util.Arrays;

public class Dp {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    static int maxCount = Integer.MAX_VALUE;

    public static void calCount(int[] coins, int amout,int count){
        if (amout < 0 || count >= maxCount){
        }else if (amout == 0){
            if (count < maxCount){
                maxCount = count;
            }
        }else {
            for (int i = 0; i < coins.length; i++) {
                calCount(coins,amout - coins[i],count +1);
            }
        }
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0){
            return 0;
        }
        if (coins.length == 1 && amount != coins[0]){
            return -1;
        }
        calCount(coins,amount,0);
        return maxCount == Integer.MAX_VALUE ? -1:maxCount;
    }

    public static int coinChange1(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount + 1);
        dp[0] = 0;
        for (int i = 0; i < amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j]<= i){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1) ;
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

        public static void main(String[] args) {
        int[] coins = {2};
        int amount = 3;
        System.out.println(coinChange(coins,amount));
    }
}
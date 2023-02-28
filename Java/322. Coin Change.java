package Java;

class Solution {
  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    // init
    for (int i = 0; i < dp.length; i++) {
      dp[i] = 10005;
    }

    dp[0] = 0;

    for (int i = 0; i < amount + 1; i++) {
      if (dp[i] == 10005) {
        continue;
      }
      for (int coin : coins) {
        if (i <= amount - coin) {
          dp[coin + i] = Math.min(dp[i] + 1, dp[coin + i]);
        }
      }
    }

    return dp[amount] == 10005 ? -1 : dp[amount];
  }
}
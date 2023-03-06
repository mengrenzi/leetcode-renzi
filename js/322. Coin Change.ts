function coinChange(coins: number[], amount: number): number {
  const dp = Array.from({length: amount + 1}, (value, index) => {
    return amount + 1;
  });
    dp[0] = 0;

  for(let i = 0; i < dp.length; i++) {
    if(dp[i] === amount + 1) {
       continue;
    }
    for(const coin of coins) {
      if(i <= amount - coin) {
        dp[i + coin] = Math.min(dp[i + coin], dp[i] + 1);
      }
    }
  }

  return dp[amount] === amount + 1 ? -1 : dp[amount];
};
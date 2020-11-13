package tyr.leet.code;

import java.util.Arrays;
import java.util.Map;

public class Solution322 {

  class Solution {

    public int coinChange(int[] coins, int amount) {
      // return coinChangeWithCache(coins, amount, new HashMap<>());
      return coinChangeWithDP(coins, amount);
    }

    private int coinChangeWithDP(int[] coins, int amount) {
      int[] dp = new int[amount + 1];
      Arrays.fill(dp, -1);
      dp[0] = 0;
      for (int i = 0; i < dp.length; i++) {
        for (int coin : coins) {
          if (i - coin >= 0 && dp[i - coin] >= 0) {
            if (dp[i] < 0 || dp[i - coin] + 1 < dp[i]) {
              dp[i] = dp[i - coin] + 1;
            }
          }
        }
      }
      return dp[amount];
    }

    private int coinChangeWithCache(int[] coins, int amount, Map<Integer, Integer> cache) {
      if (amount < 0) {
        return -1;
      } else if (amount == 0) {
        return 0;
      }
      Integer cached = cache.get(amount);
      if (cached != null) {
        return cached;
      }
      int min = -1;
      for (int coin : coins) {
        int nextMin = coinChangeWithCache(coins, amount - coin, cache);
        if (min < 0 || (nextMin >= 0 && nextMin < min)) {
          min = nextMin;
        }
      }
      if (min >= 0) {
        min++;
      }
      cache.put(amount, min);
      return min;
    }
  }

}

class Solution {
    public int coinChange(int[] coins, int amount) {

        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for (int i = 1; i < amount + 1; i++) {
            for (int coin : coins) {
                int value = i - coin;
                if (value < 0) {
                    continue;
                }

                if (value == 0) {
                    dp[i] = 1;
                    continue;
                }

                if (dp[i] == 0) {
                    dp[i] = dp[value] + 1;
                } else {
                    if (dp[value] == -1) {
                        continue;
                    }
                    dp[i] = Math.min(dp[i], dp[value] + 1);
                }
            }

            if (dp[i] == 0) {
                dp[i] = -1;
            }
        }

        return dp[amount];
    }
}
